package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.ConsortiumDao;

import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 * @since 02-sept-2013
 */
@Repository
public class ConsortiumDaoImpl implements ConsortiumDao {

    private static int ACTIVO = 1;
    @Autowired
    private SessionFactory sessionFactory;

    public ConsortiumDaoImpl() {
    }

    public ConsortiumDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return @throws SearchAllSystemOptionException
     */
    @Override
    public List<Consortium> findAll() throws SearchAllConsortiumException {
        return (List<Consortium>) sessionFactory.getCurrentSession()
                .createCriteria(Consortium.class)
                .setFetchMode("status", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", ACTIVO))
                .list();
    }

    @Override
    public void add(Consortium consortium) {
        sessionFactory.getCurrentSession().save(consortium);
    }

    @Override
    public void update(Consortium consortium) {
        sessionFactory.getCurrentSession().update(consortium);
    }

    @Override
    public List<Consortium> findByUserId(int userId) throws SearchAllConsortiumException {
        if (userId <= 0) {
            return null;
        }
        User userResult = (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("consortiums", FetchMode.JOIN)
                .createAlias("consortiums", "consortium")
                .add(Restrictions.eq("consortium.status.id", ACTIVO))
                .add(Restrictions.eq("status.id", ACTIVO))
                .add(Restrictions.eq("id", userId))
                .uniqueResult();

        Consortium copiedConsortium;
        String[] ignoredProperties = {"users"};
        List<Consortium> finalConsortiums = new ArrayList<Consortium>();

        if (userResult != null) {
            for (Consortium currConsortium : userResult.getConsortiums()) {
                copiedConsortium = new Consortium();
                BeanUtils.copyProperties(currConsortium, copiedConsortium, ignoredProperties);
                finalConsortiums.add(copiedConsortium);
            }
        }
        return finalConsortiums;
    }

    @Override
    public void saveConsortiumsData(List<Consortium> consortiums) throws SaveSystemOptionsDataException {
        for (Consortium currConsortium : consortiums) {
            Consortium consortium = (Consortium) sessionFactory.getCurrentSession()
                    .get(currConsortium.getClass(), currConsortium.getId());
            if (consortium != null) {
                BeanUtils.copyProperties(currConsortium, consortium);
                update(consortium);
            } else {
                add(currConsortium);
            }
        }
    }

    @Override
    public void delete(int consortiumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemOption findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
