package com.exception.magicsnumbersws.service.impl;
import com.exception.magicsnumbersws.dao.UserConsortiumDao;
import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import com.exception.magicsnumbersws.service.UserService;
import java.util.ArrayList;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserConsortiumDao userConsortiumDao;
    
    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(int userId) {
        userDao.delete(userId);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public List<User> findAll() throws SearchAllUserException {
        return userDao.findAll();
    }

    @Override
    public User getUserByCredentials(String userName, String pass) {
        return userDao.getUserByCredentials(userName, pass);
    }

    @Override
    public void saveUsersData(List<User> users) throws SaveUsersDataException {
        userDao.saveUsersData(users);
    }

    @Override
    public List<User> findUsersByConsortiumIds(int userId) throws SearchAllUserException {
        Set<Consortium> consortiums = userDao.findById(userId).getConsortiums();
        List<Integer> consortiumsIds = new ArrayList<Integer>();
        for(Consortium currConsortium : consortiums){
            consortiumsIds.add(currConsortium.getId());
        }
        return userConsortiumDao.findUsersByConsortiumIds(new ArrayList<Integer>(consortiumsIds));
    }

    @Override
    public void saveUser(User user) throws SaveUsersDataException {
        userDao.saveUser(user);
    }
}
