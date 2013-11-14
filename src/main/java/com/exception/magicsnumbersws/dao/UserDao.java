package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
public interface UserDao {

    public void add(User user);

    public void update(User user);

    public void delete(int userId);
    
    public User findById(int id);

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<User> findAll() throws SearchAllUserException;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public User getUserByCredentials(String userName, String pass);

    public void saveUsersData(List<User> users) throws SaveUsersDataException;

    public User findByUserName(String userName) throws SearchAllUserException;
    
    public void saveUser(User user) throws SaveUsersDataException;
    
    public void deleteBetBankingsUserByUserId(int userId);
}
