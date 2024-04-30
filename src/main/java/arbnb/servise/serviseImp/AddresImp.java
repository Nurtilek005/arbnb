package arbnb.servise.serviseImp;

import arbnb.dao.AddresDao;
import arbnb.dao.daoImpl.AddresDaoImp;
import arbnb.entyti.Address;
import arbnb.servise.AddresServise;

import java.util.List;

public class AddresImp implements AddresServise {
    AddresDao addresDao = new AddresDaoImp();
    @Override
    public String save(Address addres) {
        return addresDao.save(addres);
    }

    @Override
    public String getAddresById(Long addrestid) {
        return addresDao.getAddresById(addrestid);
    }

    @Override
    public Address updateAddresById(Long addresId, Address newAddres) {
        return addresDao.updateAddresById(addresId,newAddres);
    }

    @Override
    public String deleteAddresById(Long id) {
        return addresDao.deleteAddresById(id);
    }

    @Override
    public List<Address> getAllAddres() {

        return addresDao.getAllAddres();
    }
}
