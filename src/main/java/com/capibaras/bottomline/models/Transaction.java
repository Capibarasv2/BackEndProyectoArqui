package com.capibaras.bottomline.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date transaction_date;
    private String transaction_type;
    private String payment_method;
    private String card_type;
    private String bank_name;
    private float amount;


    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;


}
