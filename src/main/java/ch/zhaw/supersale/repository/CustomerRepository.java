package ch.zhaw.supersale.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.supersale.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    
}
