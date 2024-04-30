package arbnb.dao;

import arbnb.entyti.Agensy;
import arbnb.entyti.Customer;

import java.util.List;

public interface CostumerDao {
    String save(Customer customer);
    String   getCostumerById(Long costumerid);

    Customer updateCostumerById(Long costumeeerId, Customer newCostumer);

    String deleteCostumerById(Long id);
    List<Customer> getAllCostumer();
}
