package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> findAll(){
        return (List<Employee>) employeeRepository.findAll();
    }
}
