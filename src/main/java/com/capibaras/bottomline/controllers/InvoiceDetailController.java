package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.InvoiceDetail;
import com.capibaras.bottomline.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoice_detail")
@CrossOrigin
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping
    public ResponseEntity<List<InvoiceDetail>> getAllInvoiceDetails() {
        List<InvoiceDetail> invoiceDetails = invoiceDetailService.getAllInvoiceDetails();
        return new ResponseEntity<>(invoiceDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetail> getInvoiceDetailById(@PathVariable Long id) {
        Optional<InvoiceDetail> invoiceDetail = invoiceDetailService.getInvoiceDetailById(id);
        if (invoiceDetail.isPresent()) {
            return new ResponseEntity<>(invoiceDetail.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
