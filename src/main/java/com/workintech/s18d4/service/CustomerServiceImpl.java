package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        //simplifies to return foundCustomer.orElse(null); !!!
        if(foundCustomer.isEmpty()) {
            return null;
        }
        return foundCustomer.get();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if(foundCustomer.isEmpty()) {
            return null;
        }
        customerRepository.delete(foundCustomer.get());
        return foundCustomer.get();
    }
}
