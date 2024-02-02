package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Transaction;
import com.capibaras.bottomline.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @GetMapping("/index")
    public List<Transaction> index(){
        return transactionService.findAll();
    }

}
