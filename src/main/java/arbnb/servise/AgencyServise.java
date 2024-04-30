package arbnb.servise;

import arbnb.entyti.Agensy;

import java.util.List;

public interface AgencyServise {
    String save(Agensy agensy);
    String   getAgencyById(Long agencytid);

    Agensy updateAgencyById(Long agencyId, Agensy newAgency);

    String deleteAgencyById(Long id);
    List<Agensy> getAllAgency();
}

