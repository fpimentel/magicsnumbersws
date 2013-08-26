package com.exception.magicsnumbersws.dao.impl;
import com.exception.magicsnumbersws.dao.StatusDao;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class StatusDaoImpl implements StatusDao{

    @Autowired
    private SessionFactory sessionFactory;

    public StatusDaoImpl() {
    }

    public StatusDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Status status) {
        sessionFactory.getCurrentSession().save(status);
    }

    @Override
    public void update(Status status) {
        sessionFactory.getCurrentSession().update(status);
    }

    @Override
    public void delete(int statusId) {
        sessionFactory.getCurrentSession().delete(findById(statusId));
    }

    @Override
    public Status findById(int id) {
        return (Status)sessionFactory.getCurrentSession().get(Status.class, id); 
    }

    @Override
    public List<Status> findAll(){
        return (List<Status>)sessionFactory.getCurrentSession().createCriteria(Status.class)                           
               .list();
    }

}
