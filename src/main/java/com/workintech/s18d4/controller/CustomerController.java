package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
@AllArgsConstructor
public class CustomerController {


    private CustomerService customerService;


    @GetMapping()
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }


    @PostMapping()
    public CustomerResponse save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return new CustomerResponse(savedCustomer.getId(),
                savedCustomer.getEmail(), savedCustomer.getSalary());
    }


//    @PutMapping("/{id}")
//    public CustomerResponse update(@PathVariable("id") Long id, @RequestBody Customer customer) {
//        return customerService.
//    }

}
