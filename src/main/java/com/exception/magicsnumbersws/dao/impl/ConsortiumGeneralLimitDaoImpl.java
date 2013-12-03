package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.ConsortiumGeneralLimitDao;
import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.exception.DeleteConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.exception.FindConsortiumGeneralLimitException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 * @since 02-Sept-2013
 */
@Repository
public class ConsortiumGeneralLimitDaoImpl implements ConsortiumGeneralLimitDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(ConsortiumGeneralLimitDaoImpl.class.getName());

    public ConsortiumGeneralLimitDaoImpl() {
    }

    public ConsortiumGeneralLimitDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(ConsortiumGeneralLimit consLimit) {
        sessionFactory.getCurrentSession().save(consLimit);
    }

    @Override
    public void update(ConsortiumGeneralLimit consLimit) {
        sessionFactory.getCurrentSession().update(consLimit);
    }

    @Override
    public void delete(int consLimitId) {
        ConsortiumGeneralLimit consLimit = new ConsortiumGeneralLimit();
        consLimit.setId(consLimitId);
        sessionFactory.getCurrentSession().delete(consLimit);
    }

    @Override
    public void deleteByConsortiumId(int consortiumId) throws DeleteConsortiumGeneralLimitException {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("delete from ConsortiumGeneralLimit cgl where cgl.consortium.id = :consortiumId");
            query.setParameter("consortiumId", consortiumId);
            int rows = query.executeUpdate();
            LOG.log(Level.INFO, "{0} rows deleted.", rows);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new DeleteConsortiumGeneralLimitException();
        }
    }

    @Override
    public ConsortiumGeneralLimit findById(int id) throws FindConsortiumGeneralLimitException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConsortiumGeneralLimit> findByConsortiumId(int consortiumId) throws FindConsortiumGeneralLimitException {
        List<ConsortiumGeneralLimit> consLimits = sessionFactory.getCurrentSession()
                .createCriteria(ConsortiumGeneralLimit.class)
                .setFetchMode("lottery", FetchMode.JOIN)
                .add(Restrictions.eq("consortium.id", consortiumId))
                .list();
        return consLimits;
    }
}
