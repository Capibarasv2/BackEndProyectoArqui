package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/index")
    public List<Employee> index(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        return employeeOptional.orElse(null);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployeeOptional = employeeService.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setFull_name(employee.getFull_name());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone_number(employee.getPhone_number());
            existingEmployee.setAddress(employee.getAddress());
            existingEmployee.setCity(employee.getCity());
            existingEmployee.setCountry(employee.getCountry());
            existingEmployee.setPostal_code(employee.getPostal_code());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setHire_date(employee.getHire_date());
            existingEmployee.setPayrolls(employee.getPayrolls());
            existingEmployee.setSalesCommissions(employee.getSalesCommissions());
            return employeeService.save(existingEmployee);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/count")
    public long count() {
        return employeeService.count();
    }

}
