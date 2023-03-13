package ch.zhaw.supersale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.supersale.model.Customer;
import ch.zhaw.supersale.model.CustomerState;
import ch.zhaw.supersale.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> setCustomerState(String email, CustomerState state) {
        List<Customer> customerList = customerRepository.findByEmail(email);
        if (customerList.size() == 1) {
            Customer customer = customerList.get(0);
            if (customer.getState() == CustomerState.NEW) {
                customer.setState(state);
                customerRepository.save(customer);
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

}
