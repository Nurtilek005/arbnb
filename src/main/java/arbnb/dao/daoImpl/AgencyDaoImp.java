package arbnb.dao.daoImpl;

import arbnb.config.HibernetConfig;
import arbnb.dao.AgencyDao;
import arbnb.entyti.Address;
import arbnb.entyti.Agensy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class AgencyDaoImp implements AgencyDao {

    EntityManagerFactory entityManagerFactory = HibernetConfig.getentityManeger();

    @Override
    public String save(Agensy agensy) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(agensy);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Succses saved!✅" + agensy;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

        return e.getMessage();
    }
    }

    @Override
    public String getAgencyById(Long agensyId ) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Agensy agensy11 = entityManager.find(Agensy.class,agensyId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "result: " + agensy11;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
    return e.getMessage();
        }
    }

    @Override
    public Agensy updateAgencyById(Long agencyId, Agensy newAgency) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Agensy agensy = null;
        try {
            entityManager.getTransaction().begin();
            agensy=entityManager.find(Agensy.class,agencyId);
            agensy.setAddres(newAgency.getAddres());
            agensy.setName(newAgency.getName());
            agensy.setOwners(newAgency.getOwners());
            agensy.setRentInfo(newAgency.getRentInfo());
            agensy.setPhoneNumber(newAgency.getPhoneNumber());
            agensy.setId(newAgency.getId());
            entityManager.getTransaction().commit();
            entityManager.close();
            return agensy;
        }catch (Exception e ){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
                System.out.println(e.getMessage());
            }

        return null;
    }

    @Override
    public String deleteAgencyById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Agensy agensy= entityManager.find(Agensy.class,id);
            entityManager.remove(agensy);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "succses deleted!✅"+agensy;
        }catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return e.getMessage();
    }
    }

    @Override
    public List<Agensy> getAllAgency() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().commit();
            List<Agensy> agensies = entityManager.createQuery("select a from Agensy  a ",Agensy.class).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return agensies;
        }catch (Exception e ){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        return null;
    }
}
