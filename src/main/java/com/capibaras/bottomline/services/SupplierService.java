package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Supplier;
import com.capibaras.bottomline.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public Supplier updateSupplier(Supplier supplier) {
        Optional<Supplier> existingSupplier = supplierRepository.findById(supplier.getId());
        if (existingSupplier.isPresent()) {
            Supplier updatedSupplier = existingSupplier.get();
            updatedSupplier.setEnterprise_name(supplier.getEnterprise_name());
            updatedSupplier.setContact_name(supplier.getContact_name());
            updatedSupplier.setContact_telephone(supplier.getContact_telephone());
            updatedSupplier.setEmail(supplier.getEmail());
            updatedSupplier.setDirection(supplier.getDirection());
            updatedSupplier.setCity(supplier.getCity());
            updatedSupplier.setCountry(supplier.getCountry());
            updatedSupplier.setPostal_code(supplier.getPostal_code());
            return supplierRepository.save(updatedSupplier);
        } else {
            throw new RuntimeException("Supplier with ID " + supplier.getId() + " not found");
        }
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Long countSuppliers() {
        return supplierRepository.count();
    }
}
