package com.learning.employeeManagement.service;

import com.learning.employeeManagement.entity.Employee;
import com.learning.employeeManagement.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee e){
        repo.save(e);
    }

    public List<Employee> findAll(){
        return repo.findAll();
    }

    public Employee getEmpById(int id){
        return repo.findById(id).orElse(new Employee());
    }

    public void deleteEmp(int id){
        repo.deleteById(id);
    }
}
