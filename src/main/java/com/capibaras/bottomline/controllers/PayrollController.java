package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Payroll;
import com.capibaras.bottomline.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
@CrossOrigin
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll createdPayroll = payrollService.createPayroll(payroll);
        return new ResponseEntity<>(createdPayroll, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayroll() {
        List<Payroll> payrolls = payrollService.getAllPayroll();
        return new ResponseEntity<>(payrolls, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        Optional<Payroll> payroll = payrollService.getPayrollById(id);
        if (payroll.isPresent()) {
            return new ResponseEntity<>(payroll.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payroll> updatePayroll(@PathVariable Long id, @RequestBody Payroll payroll) {
        payroll.setId(id);
        Payroll updatedPayroll = payrollService.updatePayroll(payroll);
        return new ResponseEntity<>(updatedPayroll, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
