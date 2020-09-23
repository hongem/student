package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Employee;
import com.example.demo.sevice.EmployeeService;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        final Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        System.out.println(employee.getLast_name());
        System.out.println(employeeDto.getFirst_name());
        return employeeDto;
    }

//    @GetMapping
//    public EmployeeDto getAllEmployees(){
//        final List<Employee> employee = employeeRepository.findAll();
//        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//        return employeeDto;
//    }

    @GetMapping
    public List<EmployeeDto> getAll(){
        final List<Employee> employee = (List<Employee>) employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
                employeeDtos = modelMapper.map(employee, (Type) EmployeeDto.class);
        return employeeDtos;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeById(@PathVariable int id){
        empService.deleteEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee emp) {
        return empService.addEmployee(emp);
    }

//    @GetMapping("/lastname/{lastName}")
//    public List<Employee> getEmployeeByLastName(@PathVariable String lastName) {
//        return empService.getEmployeeByLastName(lastName);
//    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object>updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return empService.updateEmployee(id, emp);
    }
}