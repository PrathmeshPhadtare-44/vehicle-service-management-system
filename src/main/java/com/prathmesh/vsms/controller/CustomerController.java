package com.prathmesh.vsms.controller;


import com.prathmesh.vsms.dto.CustomerLoginDto;
import com.prathmesh.vsms.dto.CustomerRegisterDto;
import com.prathmesh.vsms.entity.Customer;
import com.prathmesh.vsms.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

private CustomerService customerService;
public CustomerController(CustomerService customerService){
    this.customerService = customerService;
}
    // =========================
    // Registration
    // =========================

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute(
                "customerRegisterDto",
                new CustomerRegisterDto()
        );

    return "register";
    }


    @PostMapping("/register")
    public String registerData(@Valid CustomerRegisterDto dto,
                                BindingResult result,
                               Model model){
    if (result.hasErrors()){
        return "register";
    }
//    if (!dto.getPassword().equals(dto.getConfirmPassword())){
//        model.addAttribute("errorMessage", "Passwords do not match");
//        return "register";
//    }
        try {
                customerService.register(dto);
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
    // =========================
    // Login
    // =========================

    @GetMapping("/login")
    public String loginPage(){
    return "login";
    }

    @PostMapping("/login")
    public String loginData(@Valid CustomerLoginDto dto,
                            BindingResult result,
                            HttpSession session,
                            Model model){
    if (result.hasErrors()){
        return  "login";
    }
try {
    Customer customer = customerService.login(dto);

    session.setAttribute(
            "user",
                customer    );

    return "home";
}
catch (RuntimeException e){
    model.addAttribute("errorMessage"
    , e.getMessage());
    return "login";
}

    }

    // =========================
    // Logout
    // =========================

    @GetMapping("/logout")
    public String logout(HttpSession session){
    session.invalidate();
    return "home";

    }


}
