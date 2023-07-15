package com.learning.employeeManagement.controller;

import com.learning.employeeManagement.entity.Employee;
import com.learning.employeeManagement.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model model){
        List<Employee> list = service.findAll();
        model.addAttribute("empList",list);
        return "index";
    }

    @GetMapping("/addEmp")
    public String addEmp(){
        return "add_emp";
    }

    @PostMapping("/register")
    public String registerEmp(@ModelAttribute Employee e, HttpSession session){
        //System.out.println(e);
        service.addEmp(e);
        session.setAttribute("msg","Employee "+ e.getName() + " added successfully...");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmp(@PathVariable int id, Model model){
        Employee employee = service.getEmpById(id);
        model.addAttribute("emp",employee);
        return "edit_emp";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e, HttpSession session){
        service.addEmp(e);
        session.setAttribute("msg","Employee "+ e.getName() + " updated successfully...");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session){
        Employee employee = service.getEmpById(id);
        service.deleteEmp(id);
        session.setAttribute("msg","Employee "+ employee.getName() + " deleted successfully...");
        return "redirect:/";
    }
}
