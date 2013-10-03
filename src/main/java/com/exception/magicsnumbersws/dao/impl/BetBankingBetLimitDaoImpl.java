package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingBetLimitDao;
import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
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
        sessionFactory.getCurrentSession().delete(findById(betBankingBetLimitId));
    }

    @Override
    public BetBankingBetLimit findById(int id) {
        return (BetBankingBetLimit) sessionFactory.getCurrentSession().get(BetBankingBetLimit.class, id);
    }   
   }
