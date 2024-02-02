package com.capibaras.bottomline.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String enterprise_name;
    private String contact_name;
    private String contact_telephone;
    private String email;
    private String direction;
    private String city;
    private String country;
    private String postal_code;

    @ManyToMany(mappedBy = "vendor_for_product")
    Set<Product> products_selled_by_vendor;

    @OneToMany(cascade =
            CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "vendor")
    private Set<Invoice> invoices_for_vendor;
}
