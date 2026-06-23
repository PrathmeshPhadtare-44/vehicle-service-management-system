package com.prathmesh.vsms.service;

import com.prathmesh.vsms.config.PasswordConfig;
import com.prathmesh.vsms.dto.CustomerLoginDto;
import com.prathmesh.vsms.dto.CustomerRegisterDto;
import com.prathmesh.vsms.entity.Customer;
import com.prathmesh.vsms.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private  BCryptPasswordEncoder passwordEncoder;
    public CustomerService(CustomerRepository customerRepository
    , BCryptPasswordEncoder passwordEncoder){
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public Customer register(CustomerRegisterDto dto){
        Customer customer = new Customer();
        customer.setEmail(dto.getEmail());
        customer.setName(dto.getName());
        customer.setCity(dto.getCity());
        if (!dto.getPassword().equals(dto.getConfirmPassword())){
            throw  new RuntimeException("Password do not match!");
        }
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );
        return customerRepository.save(customer);
    }
}
