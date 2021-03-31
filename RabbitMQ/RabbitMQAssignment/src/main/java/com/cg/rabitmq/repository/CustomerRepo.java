package com.cg.rabitmq.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rabitmq.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

}
