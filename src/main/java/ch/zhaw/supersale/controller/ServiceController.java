package ch.zhaw.supersale.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.supersale.model.Customer;
import ch.zhaw.supersale.model.CustomerSetStateDTO;
import ch.zhaw.supersale.model.CustomerState;
import ch.zhaw.supersale.service.CustomerService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    CustomerService customerService;

    @PutMapping("/customerstate")
    public ResponseEntity<Customer> setCustomerState(@RequestBody CustomerSetStateDTO cs) {
        String email = cs.getEmail();
        CustomerState state = cs.getState();
        Optional<Customer> customer = customerService.setCustomerState(email, state);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
