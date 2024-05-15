package com.capibaras.bottomline.services;

import com.capibaras.bottomline.dtos.EmployeeDTO;
import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.models.User;
import com.capibaras.bottomline.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        return getEmployee(employeeDto, employee);
    }

    public Employee update(Long id, EmployeeDTO employeeDto) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            return getEmployee(employeeDto, existingEmployee);
        }
        throw new RuntimeException("Employee not found with id: " + id);
    }

    private Employee getEmployee(EmployeeDTO employeeDto, Employee existingEmployee) {
        existingEmployee.setFull_name(employeeDto.getFull_name());
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setPhone_number(employeeDto.getPhone_number());
        existingEmployee.setAddress(employeeDto.getAddress());
        existingEmployee.setCity(employeeDto.getCity());
        existingEmployee.setCountry(employeeDto.getCountry());
        existingEmployee.setPostal_code(employeeDto.getPostal_code());
        existingEmployee.setSalary(employeeDto.getSalary());
        existingEmployee.setHire_date(employeeDto.getHire_date());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public long count() {
        return employeeRepository.count();
    }
}
