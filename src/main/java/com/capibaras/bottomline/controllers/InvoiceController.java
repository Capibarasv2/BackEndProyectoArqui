package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.models.Invoice;
import com.capibaras.bottomline.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/index")
    public List<Invoice> index(){
        return invoiceService.listInvoices();
    }


}
