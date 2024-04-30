package arbnb.dao;

import arbnb.entyti.Agensy;

import java.util.List;

public interface AgencyDao {
    String save(Agensy agensy);
    String   getAgencyById(Long agencytid);

    Agensy updateAgencyById(Long agencyId, Agensy newAgency);

    String deleteAgencyById(Long id);
    List<Agensy> getAllAgency();
}
