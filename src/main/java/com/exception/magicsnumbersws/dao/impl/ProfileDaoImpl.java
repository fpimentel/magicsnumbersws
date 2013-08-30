package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.ProfileDao;
import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class ProfileDaoImpl implements ProfileDao{

    @Autowired
    private SessionFactory sessionFactory;

    public ProfileDaoImpl() {
    }

    public ProfileDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Profile profile) {
        sessionFactory.getCurrentSession().save(profile);
    }

    @Override
    public void update(Profile profile) {
        sessionFactory.getCurrentSession().update(profile);
    }

    @Override
    public void delete(int profileId) {
        sessionFactory.getCurrentSession().delete(findById(profileId));
    }

    @Override
    public Profile findById(int id) {
        return (Profile)sessionFactory.getCurrentSession().get(Profile.class, id); 
    }

    @Override
    public List<Profile> findAll() throws SearchAllProfileException {
        List<Profile> profileResult = (List<Profile>)sessionFactory.getCurrentSession().createCriteria(Profile.class)
               .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
               .setFetchMode("options", FetchMode.JOIN)                  
               .list();
        return profileResult;
    }

}
