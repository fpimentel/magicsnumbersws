/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author fpimentel
 */
public interface UserDao {
    public void add(User user);   
    public void update(User user);
    public void delete(int userId);
    public User findById(int id);    
    public List<User> findAll() throws SearchAllUserException;
    public User getUserByCredentials(String userName, String pass);        
    public void saveUsersData(List<User> users) throws SaveUsersDataException;    
}
