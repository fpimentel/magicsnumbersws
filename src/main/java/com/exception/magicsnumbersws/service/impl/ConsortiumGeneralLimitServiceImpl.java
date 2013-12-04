package com.exception.magicsnumbersws.service.impl;
import com.exception.magicsnumbersws.dao.ConsortiumDao;
import com.exception.magicsnumbersws.dao.ConsortiumGeneralLimitDao;
import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import com.exception.magicsnumbersws.exception.DeleteConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.exception.FindConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.service.ConsortiumGeneralLimitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 03-dic-2013
 */
@Service
public class ConsortiumGeneralLimitServiceImpl implements ConsortiumGeneralLimitService {

    @Autowired
    private ConsortiumGeneralLimitDao consortiumGeneralLimitDao;

    public ConsortiumGeneralLimitServiceImpl() {
    }

    public ConsortiumGeneralLimitDao getConsortiumGeneralLimitDao() {
        return consortiumGeneralLimitDao;
    }

    public void setConsortiumGeneralLimitDao(ConsortiumGeneralLimitDao consortiumGeneralLimitDao) {
        this.consortiumGeneralLimitDao = consortiumGeneralLimitDao;
    }      

    @Override
    public void add(ConsortiumGeneralLimit consLimit) {
        consortiumGeneralLimitDao.add(consLimit);
    }

    @Override
    public void update(ConsortiumGeneralLimit consLimit) {
        consortiumGeneralLimitDao.update(consLimit);
    }
    @Transactional
    @Override
    public void delete(int consLimitId) {
        consortiumGeneralLimitDao.delete(consLimitId);
    }

    @Transactional
    @Override
    public void deleteByConsortiumId(int consortiumId) throws DeleteConsortiumGeneralLimitException {
        consortiumGeneralLimitDao.deleteByConsortiumId(consortiumId);
    }

    @Transactional
    @Override
    public ConsortiumGeneralLimit findById(int id) throws FindConsortiumGeneralLimitException {
        return consortiumGeneralLimitDao.findById(id);
    }

    @Transactional
    @Override
    public List<ConsortiumGeneralLimit> findByConsortiumId(int consortiumId) throws FindConsortiumGeneralLimitException {
        return consortiumGeneralLimitDao.findByConsortiumId(consortiumId);
    }
}