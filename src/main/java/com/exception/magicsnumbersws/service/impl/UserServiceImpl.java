package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.dao.BetBankingUserDao;
import com.exception.magicsnumbersws.dao.UserConsortiumDao;
import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingUser;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.entities.UserConsortium;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import com.exception.magicsnumbersws.service.UserService;
import com.exception.magicsnumbersws.utils.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private BetBankingUserDao betBankingUserDao;
    @Autowired
    private BetBankingDao betBankingDao;
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

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
        String encryptedPassword = Security.encryptToMD5(pass);
        return userDao.getUserByCredentials(userName, encryptedPassword);
    }

    @Override
    public void saveUsersData(List<User> users) throws SaveUsersDataException {
        userDao.saveUsersData(users);
    }

    @Override
    public List<User> findUsersByConsortiumIds(int userId) throws SearchAllUserException {
        Set<Consortium> consortiums = userDao.findById(userId).getConsortiums();
        List<Integer> consortiumsIds = new ArrayList<Integer>();
        for (Consortium currConsortium : consortiums) {
            consortiumsIds.add(currConsortium.getId());
        }
        return userConsortiumDao.findUsersByConsortiumIds(new ArrayList<Integer>(consortiumsIds));
    }
    
    @Override
    public void saveUser(User user) throws SaveUsersDataException {
        LOG.log(Level.INFO, "Init-UserServiceImpl.saveUser");
        String[] userIgnoreProperties = {"betBankings", "consortiums", "password"};
        try {
            if (user != null) {
                User userEntity;
                if (user.getId() != null && user.getId() > 0) {//Update
                    userEntity = (User) userDao.findById(user.getId());
                    BeanUtils.copyProperties(user, userEntity, userIgnoreProperties);
                    if (user.getPassword().length() > 0) {
                        userEntity.setPassword(Security.encryptToMD5(user.getPassword()));
                    } 
                    update(userEntity);
                    //Eliminamos la relaciones user-consorcio y user-bancas.
                    userConsortiumDao.deleteAllByUserId(user.getId());
                    userDao.deleteBetBankingsUserByUserId(user.getId());
                } else {
                    user.setCreationDate(new Date());
                    User newUser = new User();
                    BeanUtils.copyProperties(user, newUser, userIgnoreProperties);
                    newUser.setPassword(Security.encryptToMD5(user.getPassword()));
                    add(newUser);
                    user.setId(newUser.getId());
                    userEntity = newUser;
                }
                if (user.getBetBankings() == null || user.getBetBankings().size() < 1) {//Se graban consorcios si no se especifican bancas.
                    //Grabamos los usuarios y consorsios
                    if (user.getConsortiums() != null) {
                        for (Consortium currConsortium : user.getConsortiums()) {
                            UserConsortium userConsortiumObj = new UserConsortium();
                            userConsortiumObj.setUser(userEntity);
                            userConsortiumObj.setConsortium(currConsortium);
                            userConsortiumObj.setCreationDate(new Date());
                            userConsortiumDao.add(userConsortiumObj);
                        }
                    }
                }
                //Grabamos los usuarios y bancas 
                if (user.getBetBankings() != null) {
                    for (BetBanking currBetBanking : user.getBetBankings()) {
                        BetBankingUser betBankingUserObj = new BetBankingUser();
                        betBankingUserObj.setBetBanking(currBetBanking);
                        betBankingUserObj.setUser(user);
                        betBankingUserObj.setCreationDate(new Date());
                        betBankingUserObj.setCreationUser(user.getCreationUser());
                        betBankingUserDao.add(betBankingUserObj);

                        //Asignamos el consorcio de la banca al usuario.                        
                        Consortium consortium = betBankingDao.findConsortiumByBetBankingId(currBetBanking.getId());
                        UserConsortium userConsortiumObj = new UserConsortium();
                        userConsortiumObj.setUser(user);
                        userConsortiumObj.setConsortium(consortium);
                        userConsortiumObj.setCreationDate(new Date());
                        userConsortiumDao.add(userConsortiumObj);
                    }
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "error save user", ex);
            throw new SaveUsersDataException();
        }
        LOG.log(Level.INFO, "End-UserServiceImpl.saveUser");
    }

    @Override
    public User findUserByUserName(String userName) throws SearchAllUserException {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public void updateUserPassword(int idUser, String newPassword) throws SaveUsersDataException {
        User user = userDao.findById(idUser);
        if(user != null){
            user.setPassword(Security.encryptToMD5(newPassword));
            userDao.saveUser(user);
        }        
    }
}
