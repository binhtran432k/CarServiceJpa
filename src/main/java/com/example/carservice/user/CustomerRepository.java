package com.example.carservice.user;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Set<Customer> findByIdIn(Set<Integer> ids);

}
