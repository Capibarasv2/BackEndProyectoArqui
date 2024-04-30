package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Employee;
import com.capibaras.bottomline.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void testIndex() throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());

        when(employeeService.findAll()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }

    @Test
    void testFindById() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFull_name("John Doe");

        when(employeeService.findById(1L)).thenReturn(Optional.of(employee));

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.full_name").value("John Doe"));
    }

    @Test
    void testCreate() throws Exception {
        Employee employee = new Employee();
        employee.setFull_name("Jane Doe");

        //when(employeeService.save(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"full_name\": \"Jane Doe\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.full_name").value("Jane Doe"));
    }

    @Test
    void testUpdate() throws Exception {
        Employee existingEmployee = new Employee();
        existingEmployee.setId(1L);
        existingEmployee.setFull_name("John Doe");

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(1L);
        updatedEmployee.setFull_name("Jane Doe");

        when(employeeService.findById(1L)).thenReturn(Optional.of(existingEmployee));
        //when(employeeService.save(any(Employee.class))).thenReturn(updatedEmployee);

        mockMvc.perform(MockMvcRequestBuilders.put("/employees/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"full_name\": \"Jane Doe\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.full_name").value("Jane Doe"));
    }



    @Test
    void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(employeeService, times(1)).deleteById(1L);
    }

    @Test
    void testCount() throws Exception {
        when(employeeService.count()).thenReturn(5L);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/count"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5"));
    }
}
