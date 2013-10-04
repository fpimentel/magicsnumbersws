package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BlockingNumberBetBankingDao;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
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
public class BlockingNumberBetBankingDaoImpl implements BlockingNumberBetBankingDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(BlockingNumberBetBankingDaoImpl.class.getName());

    public BlockingNumberBetBankingDaoImpl() {
    }

    public BlockingNumberBetBankingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }   

    @Override
    public void add(BlockingNumberBetBanking blockingNumber) {
        sessionFactory.getCurrentSession().save(blockingNumber);
    }

    @Override
    public void update(BlockingNumberBetBanking blockinNumber) {
       sessionFactory.getCurrentSession().update(blockinNumber);
    }

    @Override
    public BlockingNumberBetBanking findById(int id) {
        return (BlockingNumberBetBanking) sessionFactory.getCurrentSession().get(BlockingNumberBetBanking.class, id);
    }

    @Override
    public void delete(int blockingNumberId) {
        BlockingNumberBetBanking entity = findById(blockingNumberId);
        sessionFactory.getCurrentSession().delete(entity);
        sessionFactory.getCurrentSession().flush();
    }
}
