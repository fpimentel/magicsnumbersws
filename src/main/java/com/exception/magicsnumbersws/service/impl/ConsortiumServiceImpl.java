package com.exception.magicsnumbersws.service.impl;
import com.exception.magicsnumbersws.dao.ConsortiumDao;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import com.exception.magicsnumbersws.service.ConsortiumService;
import java.util.List;
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

    @Override
    public void saveConsortiumData(Consortium consortium) throws SaveConsortiumDataException {
        try {
            consortiumDao.saveConsortiumData(consortium);
        } catch (Exception ex) {
            throw new SaveConsortiumDataException();
        }
    }
}