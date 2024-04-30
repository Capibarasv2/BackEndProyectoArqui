package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.models.Invoice;
import com.capibaras.bottomline.models.InvoiceDetail;
import com.capibaras.bottomline.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
@CrossOrigin
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/getAll")
    public List<Invoice> index(){
        return invoiceService.listInvoices();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceService.getInvoiceById(id);
        if (invoice.isPresent()) {
            return new ResponseEntity<>(invoice.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
