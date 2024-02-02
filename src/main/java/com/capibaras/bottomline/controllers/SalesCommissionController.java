package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.SalesCommission;
import com.capibaras.bottomline.services.SalesCommissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales_commission")
public class SalesCommissionController {

    private SalesCommissionService salesCommissionService;

    @GetMapping("/index")
    public List<SalesCommission> index(){
        return salesCommissionService.findAll();
    }

}
