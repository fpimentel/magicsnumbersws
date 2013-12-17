package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;
import javax.ws.rs.PathParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
@Service
public interface UserService {

    public void add(User user);

    public void update(User user);

    public void delete(int userId);

    @Transactional(readOnly = true)
    public User findById(int id);

    @Transactional(readOnly = true)
    public List<User> findAll() throws SearchAllUserException;

    @Transactional(readOnly = true)
    public User getUserByCredentials(String userName, String pass);

    public void saveUsersData(List<User> users) throws SaveUsersDataException;
    
    public List<User> findUsersByConsortiumIds(int userId) throws SearchAllUserException; 
    
    public void saveUser(User user) throws SaveUsersDataException;   
    
    public User findUserByUserName(String userName) throws SearchAllUserException;
    
    public void updateUserPassword(int idUser, String newPassword) throws SaveUsersDataException;
}
