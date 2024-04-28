package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.InvoiceDetail;
import com.capibaras.bottomline.repository.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {
    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public List<InvoiceDetail> getAllInvoiceDetails() {
        return invoiceDetailRepository.findAll();
    }

    public Optional<InvoiceDetail> getInvoiceDetailById(Long id) {
        return invoiceDetailRepository.findById(id);
    }
}
