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
@Entity(name = "products")
public class Product {

//    id int [PK]
//    name varchar
//    description varchar
//    category varchar
//    serial_number datetime
//    purchase_price decimal
//    sale_price decimal
//    quantity_available int
//    product_thumbnail varchar
//    product_state ENUM('activo', 'inactivo', 'en espera')

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String category;
    private String serial_number;
    private double purchase_price;
    private double sale_price;
    private int quantity_available;
    private String product_thumbnail;
    private String product_state;

    @ManyToMany
    @JoinTable(
            name = "product_vendors",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "vendor_id"))
    Set<Vendor> vendor_for_product;

    @ManyToMany
    @JoinTable(
            name = "product_customers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    Set<Customer> customer_for_product;

    @ManyToMany
    @JoinTable(
            name = "product_invoices",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id"))
    Set<Invoice> invoices_for_product;


}
