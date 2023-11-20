package com.application.vocealuga.controller;

import com.application.vocealuga.dto.TransactionDto;
import com.application.vocealuga.service.impl.TransactionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class TransactionController {
    /* repository */
    private TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/pagamento")
    public String transaction(Model model) {
        model.addAttribute("transaction", new TransactionDto());
        return "transaction";
    }

    @PostMapping("/pagar")
    public String createTransaction(@ModelAttribute TransactionDto transactionDto) {
        try {
            transactionService.saveTransaction(transactionDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/pagamento?error";
        }

        return "redirect:/pagamento?success";
    }
}
