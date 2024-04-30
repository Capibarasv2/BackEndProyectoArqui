package com.capibaras.bottomline.dtos;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String full_name;
    private String email;
    private String phone_number;
    private String address;
    private String city;
    private String country;
    private String postal_code;
    private float salary;
    private String hire_date;
    private Long user_id;
}
