package com.prathmesh.vsms.service;

import com.prathmesh.vsms.config.PasswordConfig;
import com.prathmesh.vsms.entity.Customer;
import com.prathmesh.vsms.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private  BCryptPasswordEncoder passwordEncoder;
    public CustomerService(CustomerRepository customerRepository
    , BCryptPasswordEncoder passwordEncoder){
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer register(Customer customer){
        customer.setPassword(
                passwordEncoder.encode(customer.getPassword())
        );
        return customerRepository.save(customer);
    }
}
