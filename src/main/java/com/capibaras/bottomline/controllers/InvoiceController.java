package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.models.Invoice;
import com.capibaras.bottomline.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@CrossOrigin
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/index")
    public List<Invoice> index(){
        return invoiceService.listInvoices();
    }


}
