package com.capibaras.bottomline.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="sales_comissions")
public class SalesCommission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float commission_amount;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="transaction_id")
    private Transaction transaction;



}
