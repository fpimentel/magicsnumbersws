package com.exception.magicsnumbersws.dao.impl;
import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.User;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
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
       // sessionFactory.getCurrentSession().save(user);
    }
    @Override
    public void update(User user) {
      //  sessionFactory.getCurrentSession().update(user);
    }
    @Override
    public void delete(int userId) {
        //sessionFactory.getCurrentSession().delete(findById(userId));
    }

    @Override
    public User findById(int id) {
        return (User)sessionFactory.getCurrentSession().get(User.class, id);        
    }

    @Override
    public List<User> findAll() {
       return (List<User>)sessionFactory.getCurrentSession().createQuery("Select firtName from User").list();         
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
}
