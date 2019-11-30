package com.oguzhan.demoticket.resource;

import com.oguzhan.demoticket.model.Airport;
import com.oguzhan.demoticket.model.Customer;
import com.oguzhan.demoticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Customer> allAirport() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Customer> getAirport(@PathVariable long id) {
        //System.out.println("İd -------------------" + id);
        return customerService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }
}
