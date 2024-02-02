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
@Entity(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String invoice_number;
    private String invoice_date;
    private double total_amount;

    @OneToMany(cascade =
            CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "invoice")
    private Set<Transaction> transactions;

    @ManyToMany(mappedBy = "invoices_for_product")
    Set<Product> products_in_invoice;

//    No es necesario crear los atributos de las tablas relacionadas, ya que se crean automaticamente
//    ManyToOne se encarga de gestionar que al objeto vendor se le asigne un id de la tabla vendors
//    Lo mismo con customer

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
