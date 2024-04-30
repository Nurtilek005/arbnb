package arbnb.servise;

import arbnb.entyti.Rent_info;

import java.util.List;

public interface RentInfoServise {
    String save(Rent_info rentInfo);
    String   getrentInfoById(Long rentInfoid);

    Rent_info updateRentInfoById(Long rentInfoId, Rent_info newRentinfo);

    String deleteRentInfoById(Long id);
    List<Rent_info> getAllRentInfo();
}
