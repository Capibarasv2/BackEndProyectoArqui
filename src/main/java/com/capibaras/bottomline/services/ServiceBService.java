package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.ServiceB;
import com.capibaras.bottomline.repository.ServiceBRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBService {

    private final ServiceBRepository serviceBRepository;

    public ServiceBService(ServiceBRepository serviceBRepository) {
        this.serviceBRepository = serviceBRepository;
    }

    public List<ServiceB> getAllServices() {
        return serviceBRepository.findAll();
    }

    public Optional<ServiceB> getServiceById(Long id) {
        return serviceBRepository.findById(id);
    }
}
