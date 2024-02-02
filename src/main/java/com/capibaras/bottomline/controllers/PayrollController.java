package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Payroll;
import com.capibaras.bottomline.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("/index")
    public List<Payroll> index(){
        return payrollService.findAll();
    }

}
