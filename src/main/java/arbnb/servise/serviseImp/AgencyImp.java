package arbnb.servise.serviseImp;

import arbnb.dao.AgencyDao;
import arbnb.dao.daoImpl.AgencyDaoImp;
import arbnb.entyti.Agensy;
import arbnb.servise.AgencyServise;

import java.util.List;

public class AgencyImp implements AgencyServise {
  AgencyDao agencyDao = new AgencyDaoImp();
    @Override
    public String save(Agensy agensy) {
        return agencyDao.save(agensy);
    }

    @Override
    public String getAgencyById(Long agencytid) {

        return agencyDao.getAgencyById(agencytid);
    }

    @Override
    public Agensy updateAgencyById(Long agencyId, Agensy newAgency) {

        return agencyDao.updateAgencyById(agencyId,newAgency);
    }

    @Override
    public String deleteAgencyById(Long id) {

        return agencyDao.deleteAgencyById(id);
    }

    @Override
    public List<Agensy> getAllAgency() {

        return agencyDao.getAllAgency();
    }
}
