package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Vendor;
import com.capibaras.bottomline.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorController {

    private VendorRepository vendorRepository;

    @Autowired
    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> listVendors(){
        return vendorRepository.findAll();
    }
}
