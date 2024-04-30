package arbnb.servise;

import arbnb.entyti.Owner;

import java.util.List;

public interface OwnerServise {
    String save(Owner owner);
    String   getOwnerById(Long ownerId);

    Owner updateOwnerById(Long ownerid, Owner newOwner);

    String deleteOwnerById(Long id);
    List<Owner> getAllowner();
}
