package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.dtos.EmployeeDTO;
import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> index(){
        return employeeService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Employee findById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        return employeeOptional.orElse(null);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody EmployeeDTO employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDto) {
        Employee updatedEmployee = employeeService.update(id, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/count")
    public long count() {
        return employeeService.count();
    }

}
