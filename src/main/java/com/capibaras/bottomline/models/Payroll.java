package com.capibaras.bottomline.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date payment_date;
    private Float amount;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

}
