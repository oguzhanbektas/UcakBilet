package com.oguzhan.demoticket.controller;

import com.oguzhan.demoticket.model.Customer;
import com.oguzhan.demoticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Customer> allCustomer() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomer(@PathVariable long id) {
        return customerService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer save(@RequestBody @Valid Customer customer) {
        return customerService.save(customer);
    }
}
