package arbnb.dao.daoImpl;

import arbnb.config.HibernetConfig;
import arbnb.dao.CostumerDao;
import arbnb.entyti.Address;
import arbnb.entyti.Agensy;
import arbnb.entyti.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CostumerDaoImp implements CostumerDao {
    EntityManagerFactory entityManagerFactory = HibernetConfig.getentityManeger();

    @Override
    public String save(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Succses saved!✅" + customer;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public String getCostumerById(Long costumerId) {


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Customer customer = entityManager.find(Customer.class,costumerId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "result: " + customer;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public Customer updateCostumerById(Long costumeeerId, Customer newCostumer) {


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer customer = null;
        try {
            entityManager.getTransaction().begin();
            customer=entityManager.find(Customer.class,costumeeerId);
            customer.setEmail(newCostumer.getEmail());
            customer.setGender(newCostumer.getGender());
            customer.setNationality(newCostumer.getNationality());
            customer.setFirstName(newCostumer.getFirstName());
            customer.setFamilyStarus(newCostumer.getFamilyStarus());
            customer.setRentInfos(newCostumer.getRentInfos());
            customer.setLastName(newCostumer.getLastName());
            customer.setDateOfBirth(newCostumer.getDateOfBirth());

            entityManager.getTransaction().commit();
            entityManager.close();
            return customer;
        }catch (Exception e ){
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public String deleteCostumerById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Customer customer = entityManager.find(Customer.class, id);
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "succses deleted!✅" + customer;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
        }
    }
    @Override
    public List<Customer> getAllCostumer() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().commit();
            List<Customer> customers = entityManager.createQuery("select a from Customer  a ",Customer.class).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return customers;
        }catch (Exception e ){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        return null;
    }
}
