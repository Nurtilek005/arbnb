package arbnb.servise;

import arbnb.entyti.Customer;

import java.util.List;

public interface CostumerServise {
    String save(Customer customer);
    String   getCostumerById(Long costumerid);

    Customer updateCostumerById(Long costumeeerId, Customer newCostumer);

    String deleteCostumerById(Long id);
    List<Customer> getAllCostumer();
}
