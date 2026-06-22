package com.prathmesh.vsms.controller;


import com.prathmesh.vsms.entity.Customer;
import com.prathmesh.vsms.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
private CustomerService customerService;
public CustomerController(CustomerService customerService){
    this.customerService = customerService;
}
    @GetMapping("/register")
    public String registerPage(){
    return "register";
    }
    @PostMapping("/register")
    public String registerData(Customer customer , Model model){
        try {
                customerService.register(customer);
                model.addAttribute(
                        "successMessage" , "Registration Successful"
                );
                return "home";
        }
        catch (RuntimeException e){
            model.addAttribute(
                    "errorMessage" , e.getMessage()
            );
            return "register";
        }
    }

}
