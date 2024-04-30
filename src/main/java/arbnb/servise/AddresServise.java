package arbnb.servise;

import arbnb.entyti.Address;

import java.util.List;

public interface AddresServise {
    String save(Address addres);
    String   getAddresById(Long addrestid);

    Address updateAddresById(Long addresId, Address newAddres);

    String deleteAddresById(Long id);
    List<Address> getAllAddres();
}
