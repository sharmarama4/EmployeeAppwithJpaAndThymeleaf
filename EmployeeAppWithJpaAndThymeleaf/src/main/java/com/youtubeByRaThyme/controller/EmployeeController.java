package com.youtubeByRaThyme.controller;



import com.youtubeByRaThyme.entity.Employee;
import com.youtubeByRaThyme.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//display list of employees
    @GetMapping("/employees")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return"index";
    }
    @GetMapping("/showNewEmployeesForm")
    public String showNewEmployeesForm(Model model) {
        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee( @ModelAttribute("employee") Employee employee){
        //save employee to database
      employeeService.saveEmployee(employee);
      return "redirect:/employees";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable long id, Model model) {
        //get employee from the service
        Employee employee =employeeService.getEmployeeById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update-employee";
    }
    @GetMapping("/showFormForDelete/{id}")
    public String showFormForDelete(@PathVariable long id, Model model) {

       //call delete employee methode
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}
