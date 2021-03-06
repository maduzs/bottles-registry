package muni.fi.pa165.liquorbottles.service.services.impl;

import java.util.List;
import javax.persistence.PersistenceException;
import muni.fi.pa165.liquorbottles.persistenceLayer.dao.PoliceDAO;
import muni.fi.pa165.liquorbottles.persistenceLayer.entities.Police;
import muni.fi.pa165.liquorbottles.api.dto.PoliceDTO;
import muni.fi.pa165.liquorbottles.service.dto.convertor.DozerPoliceDTOConvertor;
import muni.fi.pa165.liquorbottles.api.services.PoliceService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.NonTransientDataAccessResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author Matus Novak, Masaryk University
 */
@Service
@Transactional
public class PoliceServiceImpl implements PoliceService {

    PoliceDAO policeDAO;
    DozerPoliceDTOConvertor dozerPoliceDTOConvertor = new DozerPoliceDTOConvertor();

    @Override
    @Secured({"ROLE_ADMIN"})
    public List<PoliceDTO> findAll() {
        try {
            List<Police> police = policeDAO.findAll();
            return dozerPoliceDTOConvertor.fromEntityToDTO(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public PoliceDTO findById(long id) {
        try {
            Police police = policeDAO.findById(id);
            return dozerPoliceDTOConvertor.fromEntityToDTO(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public PoliceDTO findByUsername(String userName) {
        try {
            Police police = policeDAO.findByUsername(userName);
            return dozerPoliceDTOConvertor.fromEntityToDTO(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public PoliceDTO findByName(String name) {
        try {
            Police police = policeDAO.findByName(name);
            return dozerPoliceDTOConvertor.fromEntityToDTO(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public PoliceDTO findByAddress(String address) {
        try {
            Police police = policeDAO.findByAddress(address);
            return dozerPoliceDTOConvertor.fromEntityToDTO(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public List<PoliceDTO> findByFilter(String name, String address) {
        try {
            List<Police> police = policeDAO.findByFilter(name, address);
            return dozerPoliceDTOConvertor.fromEntityToDTO(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public void insertPolice(PoliceDTO policeDTO) {
        try {
            Police police = dozerPoliceDTOConvertor.fromDTOToEntity(policeDTO);
            policeDAO.insertPolice(police);
            policeDTO.setId(police.getId());
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public void updatePolice(PoliceDTO policeDTO) {
        try {
            Police police = dozerPoliceDTOConvertor.fromDTOToEntity(policeDTO);
            if(police.getPassword().equals("")){
                police.setPassword(policeDAO.findById(police.getId()).getPassword());
            }
            policeDAO.updatePolice(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public void deletePolice(PoliceDTO policeDTO) {
        try {
            Police police = dozerPoliceDTOConvertor.fromDTOToEntity(policeDTO);
            policeDAO.deletePolice(police);
        } catch (PersistenceException ex) {
            throw new NonTransientDataAccessResourceException("Operation failed!", ex);
        }
    }

    @Required
    @Secured({"ROLE_ADMIN"})
    public void setPoliceDAO(PoliceDAO policeDAO) {
        this.policeDAO = policeDAO;
    }

}
