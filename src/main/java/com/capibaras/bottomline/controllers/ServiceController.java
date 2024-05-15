package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Role;
import com.capibaras.bottomline.models.ServiceB;
import com.capibaras.bottomline.services.RoleService;
import com.capibaras.bottomline.services.ServiceBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/services")
@CrossOrigin
public class ServiceController {
    @Autowired
    private ServiceBService serviceBService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceB>> getAllRoles() {
        List<ServiceB> services = serviceBService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ServiceB> getRoleById(@PathVariable Long id) {
        Optional<ServiceB> service = serviceBService.getServiceById(id);
        return service.map(serviceB -> new ResponseEntity<>(serviceB, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
