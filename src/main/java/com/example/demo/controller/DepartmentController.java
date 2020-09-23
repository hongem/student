package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.sevice.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department addepartment(@RequestBody Department department) {
        return departmentService.addName(department);
    }

    @GetMapping
    public List<Department> getListdepartment(){
        return departmentService.getList();
    }
}
