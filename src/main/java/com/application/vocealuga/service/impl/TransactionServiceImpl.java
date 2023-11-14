package com.application.vocealuga.service.impl;

import com.application.vocealuga.dto.TransactionDto;
import com.application.vocealuga.entity.TransactionEntity;
import com.application.vocealuga.repository.TransactionRepository;
import com.application.vocealuga.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void saveTransaction(TransactionDto transactionDto) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setForma(transactionDto.getForma());
        transactionEntity.setDescricao(transactionDto.getDescricao());

        try {
            transactionRepository.save(transactionEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTransaction() {
        return;
    }

    public void updateTransaction() {
        return;
    }
}
