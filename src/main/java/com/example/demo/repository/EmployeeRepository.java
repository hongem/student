package com.example.demo.repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //List<Employee> findByLast_name(String lastName);
    @Query(nativeQuery = true,value = "call get_employee(:id)")  // call store procedure
    List<Employee> get_employee(@Param("id")Integer id);

}