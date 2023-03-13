package ch.zhaw.supersale.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.supersale.model.Customer;
import ch.zhaw.supersale.model.CustomerAggregationDTO;
import ch.zhaw.supersale.model.CustomerAggregationDTO2;
import ch.zhaw.supersale.model.CustomerCreateDTO;
import ch.zhaw.supersale.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreateDTO cDTO) {
        Customer newCustomer = new Customer(cDTO.getEmail(), cDTO.getName());
        Customer f = customerRepository.save(newCustomer);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(@RequestParam(required = false) String email) {
        if (email != null) {
            return customerRepository.findByEmail(email);
        }
        return customerRepository.findAll();
    }
    
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(c.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/aggregation/state")
    public List<CustomerAggregationDTO> getJobStateAggregation() {
        return customerRepository.getCustomerStateAggregation();
    }

    @GetMapping("/customer/aggregation2/state")
    public List<CustomerAggregationDTO2> getJobStateAggregation2() {
        return customerRepository.getCustomerStateAggregation2();
    }
}
