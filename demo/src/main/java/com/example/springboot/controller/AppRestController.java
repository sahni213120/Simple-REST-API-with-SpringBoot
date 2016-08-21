package com.example.springboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Customer;
import com.example.springboot.repositories.CustomerRepository;

/**
 * Rest Controller of the application where all REST HTTP methods are defined and implemented
 * 
 * @author SahniH
 *
 */
@RestController
@RequestMapping("/customers")
public class AppRestController {

    /**
     * Customer Repository will be autowired once application starts
     */
    @Autowired
    private CustomerRepository repository;

    /**
     * GET method to get all customers from the database
     * 
     * @return - A list of customers in the database
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        return new ResponseEntity<>((Collection<Customer>) repository.findAll(), HttpStatus.OK);
    }

    /**
     * GET method to retrieve a customer based on customer id
     * 
     * @param customer id
     * @return customer information
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Customer> getPieWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    /**
     * GET method to retrieve a customer based on customer name
     * 
     * @param Customer name
     * @return customer information
     */
    @RequestMapping(method = RequestMethod.GET, params = { "name" })
    public ResponseEntity<Collection<Customer>> findPieWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    /**
     * POST method to add a new customer in the database
     * 
     * @param Customer
     * @return Customer information that is added
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPie(@RequestBody Customer input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.OK);
    }

    /**
     * DELETE method to delete a customer from the database
     * 
     * @param customer id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deletePie(@PathVariable Long id) {
        repository.delete(id);
    }

}
