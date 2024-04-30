package arbnb.servise.serviseImp;

import arbnb.dao.CostumerDao;
import arbnb.dao.daoImpl.CostumerDaoImp;
import arbnb.entyti.Customer;
import arbnb.servise.CostumerServise;

import java.util.List;

public class CostumerImp implements CostumerServise {
   CostumerDao costumerDao = new CostumerDaoImp();
    @Override
    public String save(Customer customer) {
        return costumerDao.save(customer);
    }

    @Override
    public String getCostumerById(Long costumerid) {
        return costumerDao.getCostumerById(costumerid);
    }

    @Override
    public Customer updateCostumerById(Long costumeeerId, Customer newCostumer) {
        return costumerDao.updateCostumerById(costumeeerId,newCostumer);
    }

    @Override
    public String deleteCostumerById(Long id) {
        return costumerDao.deleteCostumerById(id);
    }

    @Override
    public List<Customer> getAllCostumer() {
        return costumerDao.getAllCostumer();
    }
}
