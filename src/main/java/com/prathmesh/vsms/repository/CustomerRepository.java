package com.prathmesh.vsms.repository;

import com.prathmesh.vsms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer , Long> {


    Optional<Customer> findByEmail(String email);
}
