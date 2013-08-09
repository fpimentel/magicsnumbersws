/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Transactional
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Transactional
    public List<User> findAll() {
       return userDao.findAll();
    }
    
}
