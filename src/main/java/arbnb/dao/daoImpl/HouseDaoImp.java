package arbnb.dao.daoImpl;

import arbnb.config.HibernetConfig;
import arbnb.dao.HouseDao;
import arbnb.entyti.House;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class HouseDaoImp implements HouseDao {
    EntityManagerFactory entityManagerFactory = HibernetConfig.getentityManeger();
    @Override
    public String save(House house) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
try{
    entityManager.getTransaction().begin();
    entityManager.persist(house);
    entityManager.getTransaction().commit();
    entityManager.close();

}catch (Exception e){
    if (entityManager.getTransaction().isActive()){
        entityManager.getTransaction().rollback();
    }
    System.out.println(e.getMessage());
}
        return "saved";
    }

    @Override
    public String getHouseById(Long houseId) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try{
           entityManager.getTransaction().begin();
           House house = entityManager.find(House.class,houseId);
           entityManager.getTransaction().commit();
           entityManager.close();
           return "result : "+ house ;
       }catch (Exception e ){
           if (entityManager.getTransaction().isActive();
               entityManager.getTransaction().rollback();
           }
        return e.getMessage();

    }

    @Override
    public House updateHouseById(Long houseId, House newHouse) {

          EntityManager entityManager = entityManagerFactory.createEntityManager();
          try {
          House house = null;
          entityManager.getTransaction().begin();
          house = entityManager.find(House.class, houseId);
          house.setHouseType(newHouse.getHouseType());
          house.setAddres(newHouse.getAddres());
          house.setPrice(newHouse.getPrice());
          house.setOwner(newHouse.getOwner());
          house.setRoom(newHouse.getRoom());
          house.setRentInfo(newHouse.getRentInfo());
          house.setDescription(newHouse.getDescription());
      return house;
      }catch (Exception e){
          if (entityManager.getTransaction().isActive();
              entityManager.getTransaction().rollback();
          }
              System.out.println(e.getMessage());

        return null;
    }

    @Override
    public String deleteHouseById(Long id) {
  EntityManager entityManager   =entityManagerFactory.createEntityManager();
     try{

         entityManager.getTransaction().begin();
         House house= entityManager.find(House.class,id);
         entityManager.remove(id);
         entityManager.getTransaction().commit();
         entityManager.close();
         return"del"+ house;
     }catch (Exception e){
         entityManager.getTransaction().isActive();
         entityManager.getTransaction().rollback();
         }
    return "delete";
    }



    @Override
    public List<House> getAllHouse() {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try{
           List<House> h = entityManager.createQuery("select h from House  h", House.class).getResultList();
           return
       }

        return null;
    }
}
