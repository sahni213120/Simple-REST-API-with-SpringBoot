package com.example.springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.model.Customer;

/**
 * Interface that extends CrudRepository that allows CRUD (Create, Retrieve,
 * Update, Delete) operations on customer model object
 * 
 * @author Himanshu Sahni
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByName(String name);
}
