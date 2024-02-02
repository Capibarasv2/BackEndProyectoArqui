package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.SalesCommission;
import com.capibaras.bottomline.models.Transaction;
import com.capibaras.bottomline.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Transactional(readOnly = true)
    public List<Transaction> findAll(){
        return (List<Transaction>) transactionRepository.findAll();
    }

}
