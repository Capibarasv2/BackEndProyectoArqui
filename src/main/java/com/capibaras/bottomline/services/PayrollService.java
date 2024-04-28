package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Payroll;
import com.capibaras.bottomline.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    @Autowired
    private final PayrollRepository payrollRepository;

    public PayrollService(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    public Payroll createPayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public List<Payroll> getAllPayroll() {
        return payrollRepository.findAll();
    }

    public Optional<Payroll> getPayrollById(Long id) {
        return payrollRepository.findById(id);
    }

    public Payroll updatePayroll(Payroll payroll) {
        Optional<Payroll> existingPayroll = payrollRepository.findById(payroll.getId());
        if (existingPayroll.isPresent()) {
            Payroll updatedPayroll = existingPayroll.get();
            updatedPayroll.setPayment_date(payroll.getPayment_date());
            updatedPayroll.setAmount(payroll.getAmount());
            updatedPayroll.setEmployee(payroll.getEmployee());
            return payrollRepository.save(updatedPayroll);
        } else {
            throw new RuntimeException("Payroll with ID " + payroll.getId() + " not found");
        }
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }

    public Long countPayroll() {
        return payrollRepository.count();
    }
}
