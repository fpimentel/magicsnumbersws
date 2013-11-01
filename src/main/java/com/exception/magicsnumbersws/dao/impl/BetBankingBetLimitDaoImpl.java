package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingBetLimitDao;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
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
public class BetBankingBetLimitDaoImpl implements BetBankingBetLimitDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(BetBankingBetLimitDaoImpl.class.getName());

    public BetBankingBetLimitDaoImpl() {
    }

    public BetBankingBetLimitDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(BetBankingBetLimit betLimit) {
        sessionFactory.getCurrentSession().save(betLimit);
    }

    @Override
    public void update(BetBankingBetLimit betLimit) {
        sessionFactory.getCurrentSession().update(betLimit);
    }

    @Override
    public void delete(int betBankingBetLimitId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from BetBankingBetLimit bbl where bbl.id = :id");
        query.setParameter("id", betBankingBetLimitId);
        int rows = query.executeUpdate();
        LOG.log(Level.INFO, "{0} rows deleted.", rows);
    }

    public void deleteByBetBanking(int betBankingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from BetBankingBetLimit bbl where bbl.betBanking.id = :id");
        query.setParameter("id", betBankingId);
        int rows = query.executeUpdate();
        LOG.log(Level.INFO, "{0} rows deleted.", rows);
    }

    @Override
    public BetBankingBetLimit findById(int id) {
        return (BetBankingBetLimit) sessionFactory.getCurrentSession().get(BetBankingBetLimit.class, id);
    }

    @Override
    public String findBetBankingBetLimitAmount(int betBankingId, int lotteryId, int betId) throws FindBetLimitException {
        try {
            LOG.info("Init- BetBankingBetLimitDaoImpl.findBetBankingBetLimitAmount( " + betBankingId + ", " + lotteryId + ", " + betId + ")");
            BetBankingBetLimit betBanking = (BetBankingBetLimit) sessionFactory
                    .getCurrentSession().createCriteria(BetBankingBetLimit.class)
                    .setFetchMode("betBanking", FetchMode.JOIN)
                    .setFetchMode("lottery", FetchMode.JOIN)
                    .setFetchMode("bet", FetchMode.JOIN)
                    .add(Restrictions.eq("betBanking.id", betBankingId))
                    .add(Restrictions.eq("lottery.id", lotteryId))
                    .add(Restrictions.eq("bet.id", betId))
                    .uniqueResult();
            LOG.info("End- BetBankingBetLimitDaoImpl.findBetBankingBetLimitAmount( " + betBankingId + ", " + lotteryId + ", " + betId + ")");
            return String.valueOf(betBanking.getAmountLimit());
        } catch (Exception ex) {
            this.LOG.log(Level.SEVERE, null, ex);
            throw new FindBetLimitException(ex.getMessage());
        }
    }
}
