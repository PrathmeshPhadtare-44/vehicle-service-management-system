package com.prathmesh.vsms.repository;

import com.prathmesh.vsms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long> {

}
