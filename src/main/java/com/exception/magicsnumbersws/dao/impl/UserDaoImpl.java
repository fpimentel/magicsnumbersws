package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static int ACTIVO = 1;
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int userId) {
        sessionFactory.getCurrentSession().delete(findById(userId));
    }

    @Override
    public User findById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByCredentials(String userName, String pass) {

        User userResult = (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .createAlias("status", "status")
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("profile", FetchMode.JOIN)
               // .setFetchMode("consortiums", FetchMode.JOIN)
               // .setFetchMode("consortiums.betBankings", FetchMode.JOIN)
                .setFetchMode("profile.options", FetchMode.JOIN)                
                .add(Restrictions.eq("status.id", ACTIVO))
                .add(Restrictions.eq("userName", userName).ignoreCase())
                .add(Restrictions.eq("password", pass)).uniqueResult();
       User copiedUser = new User();
       BeanUtils.copyProperties(userResult, copiedUser);
       copiedUser.setConsortiums(null);
        //User copiedUser = new User();
        //String[] ignoredProperties = {"profile"};        
        //BeanUtils.copyProperties(userSource, copiedUser, ignoredProperties);
        return copiedUser;
    }

    @Override
    public List<User> findAll() throws SearchAllUserException {
        List<User> users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .setFetchMode("profile", FetchMode.JOIN)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("profile.options", FetchMode.JOIN)
                //.setFetchMode("consortiums", FetchMode.JOIN)
                //.setFetchMode("consortiums.betBankings", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", ACTIVO))
                .list();
        User copiedUser;
        List<User> finalUsers = new ArrayList<User>();
        for(User currUser : users){
            copiedUser = new User();
            BeanUtils.copyProperties(currUser, copiedUser);
            copiedUser.setConsortiums(null);
            //if(copiedUser.getProfile()!= null){                
              //  copiedUser.getProfile().setOptions(null);
            //}  
            //Set<Consortium> consortiums = copiedUser.getConsortiums();
            //if(consortiums!= null){
            //    for(Consortium currConsortium : consortiums){
             //       currConsortium.setBetBankings(null);
              //  }
           // }
           // copiedUser.setProfile(null);
            finalUsers.add(copiedUser);
        }
        return finalUsers;
    }

    @Override
    public void saveUsersData(List<User> users) throws SaveUsersDataException {
        for (User currUser : users) {
            User user = (User) sessionFactory.getCurrentSession().get(currUser.getClass(), currUser.getId());
            if (user != null) {
                BeanUtils.copyProperties(currUser, user);
                update(user);
            } else {
                add(currUser);
            }
        }
    }

    @Override
    public User findByUserName(String userName) throws SearchAllUserException {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("userName", userName)).uniqueResult();
    }
}
