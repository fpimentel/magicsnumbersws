/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.User;
import java.util.List;

/**
 *
 * @author fpimentel
 */
public interface UserDao {
    
    public void add(User user);
    public void update(User user);
    public void delete(int userId);
    public User findById(int id);
    public List<User> findAll();    
    public User getUserByCredentials(String userName, String pass);
    
}
