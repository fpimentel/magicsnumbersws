package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.containers.ConsortiumContainer;
import com.exception.magicsnumbersws.dao.ConsortiumDao;
import com.exception.magicsnumbersws.dao.ConsortiumGeneralLimitDao;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import com.exception.magicsnumbersws.exception.DeleteConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import com.exception.magicsnumbersws.service.ConsortiumService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 02-sept-2013
 */
@Service
@Transactional
public class ConsortiumServiceImpl implements ConsortiumService {

    @Autowired
    private ConsortiumDao consortiumDao;
    @Autowired
    private ConsortiumGeneralLimitDao consortiumGeneralLimitDao;

    public ConsortiumServiceImpl() {
    }

    public ConsortiumServiceImpl(ConsortiumDao consortiumDao) {
        this.consortiumDao = consortiumDao;
    }

    public ConsortiumDao getConsortiumDao() {
        return consortiumDao;
    }

    public void setConsortiumDao(ConsortiumDao consortiumDao) {
        this.consortiumDao = consortiumDao;
    }

    @Override
    public void add(Consortium consortium) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Consortium consortium) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int consortiumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consortium findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consortium> findByUserId(int userId) throws SearchAllConsortiumException {
        return consortiumDao.findByUserId(userId);
    }

    @Override
    public void saveConsortiumsData(List<Consortium> consortiums) throws SaveConsortiumDataException {
        consortiumDao.saveConsortiumsData(consortiums);
    }

    
    
    @Transactional
    @Override
    public void saveConsortiumData(ConsortiumContainer consortiumContainer) throws SaveConsortiumDataException {
        try {
            consortiumDao.saveConsortiumData(consortiumContainer.getConsortium());            
            //Se eliminan los limites de la base de datos.
            consortiumGeneralLimitDao.deleteByConsortiumId(consortiumContainer.getConsortium().getId());
            if (consortiumContainer.getConsortiumGeneralLimit() != null) {
                //Se procede a grabar los limites.
                for (ConsortiumGeneralLimit currConsLimit : consortiumContainer.getConsortiumGeneralLimit()) {
                    currConsLimit.setConsortium(consortiumContainer.getConsortium());
                    consortiumGeneralLimitDao.add(currConsLimit);
                }
            }
        } catch (DeleteConsortiumGeneralLimitException ex) {
            Logger.getLogger(ConsortiumServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) {
            throw new SaveConsortiumDataException();
        }
    }

    @Override
    public List<Consortium> findActiveConsortium() throws SearchAllConsortiumException {
        return consortiumDao.findActiveConsortium();
    }
}