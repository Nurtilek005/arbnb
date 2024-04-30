package arbnb.dao;

import arbnb.entyti.Customer;
import arbnb.entyti.Owner;

import java.util.List;

public interface OwnerDao {
    String save(Owner owner);
    String   getOwnerById(Long ownerId);

    Owner updateOwnerById(Long ownerid, Owner newOwner);

    String deleteOwnerById(Long id);
    List<Owner> getAllowner();
}
