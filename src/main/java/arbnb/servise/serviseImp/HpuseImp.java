package arbnb.servise.serviseImp;

import arbnb.dao.HouseDao;
import arbnb.dao.daoImpl.HouseDaoImp;
import arbnb.entyti.House;
import arbnb.servise.HouseServise;

import java.util.List;

public class HpuseImp implements HouseServise {
    HouseDao houseDao = new HouseDaoImp();
    @Override
    public String save(House house) {

        return houseDao.save(house);
    }

    @Override
    public String getHouseById(Long houseId) {

        return houseDao.getHouseById(houseId);
    }

    @Override
    public House updateHouseById(Long houseId, House newHouse) {

        return houseDao.updateHouseById(houseId,newHouse);
    }

    @Override
    public String deleteHouseById(Long id) {

        return houseDao.deleteHouseById(id);
    }

    @Override
    public List<House> getAllHouse() {

        return houseDao.getAllHouse();
    }
}
