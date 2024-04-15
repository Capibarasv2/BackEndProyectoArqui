package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Invoice;
import com.capibaras.bottomline.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> listInvoices(){
        return invoiceRepository.findAll();
    }

}
