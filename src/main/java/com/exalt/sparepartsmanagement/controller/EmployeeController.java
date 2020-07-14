package com.exalt.sparepartsmanagement.controller;


import com.exalt.sparepartsmanagement.model.Employee;
import com.exalt.sparepartsmanagement.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/api/v1/employees",params = {"page","pageSize"})
    public List<Employee> getEmployees(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize) {
        logger.info("Employee controller method -getEmployees");
        return employeeService.getAll(page, pageSize);
    }

    @GetMapping(value = "/api/v1/employees/{name}")
    public Employee getSpecificEmployee(@PathVariable String name) {
        logger.info("Employee controller method -getSpecificEmployee");
        return employeeService.get(name);
    }

    @PostMapping(value = "/api/v1/employees")
    public String createNewEmployee(@Valid @RequestBody Employee employee) {
        logger.info("employee controller method -createNewEmployee");
        employeeService.save(employee);
        return "Employee added successfully";
    }

    @PutMapping(value = "/api/v1/employees/{name}")
    public String updateEmployee(@PathVariable String name, @RequestBody Employee employee) {
        logger.info("Employee controller method -updateEmployee");
        employeeService.update(name, employee);
        return "Employee updated successfully ";
    }

    @DeleteMapping(value = "/api/v1/employees/{name}")
    public String deleteEmployee(@PathVariable String name) {
        logger.info("employee controller method -deleteEmployee");
        employeeService.delete(name);
        return "Employee deleted successfully";
    }

}
