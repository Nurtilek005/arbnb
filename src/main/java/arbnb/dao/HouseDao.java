package arbnb.dao;

import arbnb.entyti.Customer;
import arbnb.entyti.House;

import java.util.List;

public interface HouseDao {
    String save(House house);
    String   getHouseById(Long houseId);

    House updateHouseById(Long houseId, House newHouse);

    String deleteHouseById(Long id);
    List<House> getAllHouse();
}
