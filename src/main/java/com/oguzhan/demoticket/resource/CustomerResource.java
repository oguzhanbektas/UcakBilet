package com.oguzhan.demoticket.resource;

import com.oguzhan.demoticket.model.Airport;
import com.oguzhan.demoticket.model.Customer;
import com.oguzhan.demoticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Customer save(@RequestBody @Valid Customer customer) {
        return customerService.save(customer);
    }
}
