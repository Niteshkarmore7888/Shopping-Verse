package com.example.shoppingverse.repository;

import com.example.shoppingverse.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
     public Customer findByMobileNo(String mobile);
     public Customer findByEmailId(String email);
}
