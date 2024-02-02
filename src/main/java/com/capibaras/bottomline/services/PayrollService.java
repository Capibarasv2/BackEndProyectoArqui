package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Payroll;
import com.capibaras.bottomline.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Transactional(readOnly = true)
    public List<Payroll> findAll(){
        return (List<Payroll>) payrollRepository.findAll();
    }

}
