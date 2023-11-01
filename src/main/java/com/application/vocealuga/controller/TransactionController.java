package com.application.vocealuga.controller;

import com.application.vocealuga.dto.TransactionDto;
import com.application.vocealuga.entity.TransactionEntity;
import com.application.vocealuga.repository.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class TransactionController {
    /* repository */
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/pagamento")
    public String transaction(Model model) {
        model.addAttribute("transaction", new TransactionDto());
        return "transaction";
    }

    @PostMapping("/pagamento")
    public String createTransaction(TransactionDto transactionDto) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setForma(transactionDto.getForma());
        transactionEntity.setDescricao(transactionDto.getDescricao());

        try {
            transactionRepository.save(transactionEntity);
        } catch (Exception e) {
            return "redirect:/pagamento?error";
        }

        return "transaction?success";
    }
}
