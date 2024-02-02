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
@Entity(name = "customers")
public class Customer {
//    id int [PK]
//    full_name varchar
//    email varchar
//    phone_number varchar
//    address varchar
//    city varchar
//    country varchar
//    postal_code varchar

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String full_name;
    private String email;
    private String phone_number;
    private String address;
    private String city;
    private String country;
    private String postal_code;

    @ManyToMany(mappedBy = "customer_for_product")
    Set<Product> products_bought_by_customer;

    @OneToMany(cascade =
            CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "customer")
    private Set<Invoice> invoices_for_customer;


}
