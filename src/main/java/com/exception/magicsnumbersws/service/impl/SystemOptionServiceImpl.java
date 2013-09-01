package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.StatusDao;
import com.exception.magicsnumbersws.dao.SystemOptionDao;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import com.exception.magicsnumbersws.service.SystemOptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
@Service
@Transactional
public class SystemOptionServiceImpl implements SystemOptionService {

    @Autowired
    private SystemOptionDao systemOptionDao;

    public SystemOptionServiceImpl() {
    }

    public SystemOptionServiceImpl(SystemOptionDao systemOptionDao) {
        this.systemOptionDao = systemOptionDao;
    }

    public SystemOptionDao getSystemOptionDao() {
        return systemOptionDao;
    }

    public void setSystemOptionDao(SystemOptionDao systemOptionDao) {
        this.systemOptionDao = systemOptionDao;
    }

    @Override
    public void add(SystemOption systemOption) {
        systemOptionDao.add(systemOption);
    }

    @Override
    public void update(SystemOption systemOption) {
        systemOptionDao.update(systemOption);
    }

    @Override
    public void delete(int systemOptionId) {
        systemOptionDao.delete(systemOptionId);
    }

    @Override
    public SystemOption findById(int id) {
        return systemOptionDao.findById(id);
    }

    @Override
    public List<SystemOption> findAll() throws SearchAllSystemOptionException {
        return systemOptionDao.findAll();
    }

    @Override
    public void saveSystemOptionsData(List<SystemOption> systemOptions) throws SaveSystemOptionsDataException {
     try{
            systemOptionDao.saveSystemOptionsData(systemOptions);
     }
     catch(Exception ex){
         throw new SaveSystemOptionsDataException("",ex);
     }
     
    }
}
