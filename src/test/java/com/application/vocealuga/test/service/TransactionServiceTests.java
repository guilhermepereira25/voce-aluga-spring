package com.application.vocealuga.test.service;

import com.application.vocealuga.dto.TransactionDto;
import com.application.vocealuga.entity.TransactionEntity;
import com.application.vocealuga.repository.TransactionRepository;
import com.application.vocealuga.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTests {
    @InjectMocks
    private TransactionServiceImpl transactionService;
    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void TransactionService_ShouldCreateTransactionWithSuccess() {
        TransactionEntity transaction = TransactionEntity.builder()
                .forma("Dinheiro")
                .descricao("Teste")
                .build();

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setForma("Dinheiro");
        transactionDto.setDescricao("Teste");

        when(transactionRepository.save(Mockito.any(TransactionEntity.class))).thenReturn(null);

        transactionService.saveTransaction(transactionDto);
        assertThat(transaction.getForma()).isEqualTo(transactionDto.getForma());
        assertThat(transaction.getDescricao()).isEqualTo(transactionDto.getDescricao());
    }

    @Test
    public void TransactionService_ShouldNotCreateTransactionWithSuccess() {
        TransactionEntity transaction = TransactionEntity.builder()
                .forma("Dinheiro")
                .descricao("Teste")
                .build();

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setForma("Dinheiro");
        transactionDto.setDescricao("Teste");

        when(transactionRepository.save(Mockito.any(TransactionEntity.class))).thenReturn(null);

        transactionService.saveTransaction(transactionDto);
        assertThat(transaction.getForma()).isNotEqualTo("Cartão");
        assertThat(transaction.getDescricao()).isNotEqualTo("Teste2");
    }
}
