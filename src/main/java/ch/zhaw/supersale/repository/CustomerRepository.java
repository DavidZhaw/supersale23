package ch.zhaw.supersale.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.supersale.model.Customer;
import ch.zhaw.supersale.model.CustomerAggregationDTO;
import ch.zhaw.supersale.model.CustomerAggregationDTO2;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByEmail(String email);

    @Aggregation("{'$group': {'id': '$state', 'customer': {'$push': '$email'}}}")
    List<CustomerAggregationDTO> getCustomerStateAggregation();

    @Aggregation("{'$group': {'_id': '$state', 'customer': {'$push': {'name': '$name', 'email': '$email'}}}}")
    List<CustomerAggregationDTO2> getCustomerStateAggregation2();
}
