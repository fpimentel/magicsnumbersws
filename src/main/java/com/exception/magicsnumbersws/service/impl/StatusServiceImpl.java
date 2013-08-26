
package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.StatusDao;
import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import com.exception.magicsnumbersws.service.StatusService;
import com.exception.magicsnumbersws.service.UserService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
@Service
@Transactional
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusDao statusDao;    

    public StatusServiceImpl() {
    }

    public StatusServiceImpl(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    public StatusDao getUserDao() {
        return statusDao;
    }

    public void setUserDao(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    @Override
    public void add(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int statusId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Status findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Status> findAll() {
        return statusDao.findAll();
    }
       
}
