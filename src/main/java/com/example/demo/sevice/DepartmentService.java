package com.example.demo.sevice;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addName(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getList(){
        return (List<Department>) departmentRepository.findAll();
    }
}
