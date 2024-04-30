package arbnb.dao.daoImpl;

import arbnb.config.HibernetConfig;
import arbnb.dao.AddresDao;
import arbnb.entyti.Address;
import arbnb.entyti.Agensy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;

import java.util.List;

public class AddresDaoImp implements AddresDao {

    EntityManagerFactory entityManagerFactory = HibernetConfig.getentityManeger();

    @Override
    public String save(Address addres) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {


            entityManager.getTransaction().begin();
            entityManager.persist(addres);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Succses saved!✅" + addres;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public String getAddresById(Long addrestid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Address addres = entityManager.find(Address.class, addrestid);
            entityManager.getTransaction().commit();

            return "result: " + addres;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public Address updateAddresById(Long addresId, Address newAddres) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Address addres = null;
        try {
            entityManager.getTransaction().begin();
            addres = entityManager.find(Address.class, addresId);
            addres.setCity(newAddres.getCity());
            addres.setRegion(newAddres.getRegion());
            addres.setStreet(newAddres.getStreet());
            entityManager.getTransaction().commit();
            entityManager.close();
            return addres;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String deleteAddresById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Address addres = entityManager.find(Address.class, id);
            entityManager.remove(addres);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "succses deleted!✅" + addres;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public List<Address> getAllAddres() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<Address> a = entityManager.createQuery("select  a from Address a  ", Address.class).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return a;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        return null;

    }
}
