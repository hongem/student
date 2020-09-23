package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

//    public ResponseEntity<EmployeeDto> getAllEmployees(){
//        List<EmployeeDto> employeeDtos = employeeRepository.get_employee();
//        return new ResponseEntity<>(EmployeeDto, HttpStatus.OK);
//    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }

    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

//    public List<Employee> getEmployeeByLastName(String lastName) {
//        return employeeRepository.findByLast_name(lastName);
//    }

    public ResponseEntity<Object> updateEmployee(int id, Employee employee){
        Optional<Employee> employeeCurrent = employeeRepository.findById(id);
        if(!employeeCurrent.isPresent()){
            return ResponseEntity.ok().body("Something wrong!");
        }
        employeeCurrent.get().setFirst_name(employee.getFirst_name());
        employeeCurrent.get().setLast_name(employee.getLast_name());
        employeeRepository.save(employeeCurrent.get());
        return null;
    }
}