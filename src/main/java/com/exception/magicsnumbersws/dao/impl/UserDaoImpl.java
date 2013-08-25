package com.exception.magicsnumbersws.dao.impl;
import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class UserDaoImpl implements UserDao{

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
        return (User)sessionFactory.getCurrentSession().get(User.class, id);        
    }

    

    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByCredentials(String userName, String pass) {
        User user = (User)sessionFactory.getCurrentSession().createCriteria(User.class)
                       .add(Restrictions.eq("userName", userName))
                       .add(Restrictions.eq("password", pass)).list();         
        return user;
    } 

    @Override
    public List<User> findAll() throws SearchAllUserException {
     return (List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
               .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
               .setFetchMode("profiles", FetchMode.JOIN)               
               .list(); 
    } 

    @Override
    public void saveUsersData(Set<User> users) throws SaveUsersDataException{
        
        for(User currUser : users)
        {
          User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                        .add(Restrictions.eq("id", currUser.getId())).list();
          if(user != null){
              user= currUser;
              update(user);
          }
          else 
          {
              add(currUser);
          }          
        }
    }
}
