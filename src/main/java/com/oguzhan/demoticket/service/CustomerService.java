package com.oguzhan.demoticket.service;

import com.oguzhan.demoticket.model.Customer;
import com.oguzhan.demoticket.model.Fly;
import com.oguzhan.demoticket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> findById(long id){
        return customerRepository.findById(id);
    }
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

}
