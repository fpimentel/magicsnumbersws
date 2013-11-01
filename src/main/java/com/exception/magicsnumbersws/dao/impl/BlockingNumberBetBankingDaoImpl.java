package com.exception.magicsnumbersws.dao.impl;
import com.exception.magicsnumbersws.dao.BlockingNumberBetBankingDao;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
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
        BlockingNumberBetBanking blockNumberEntity = (BlockingNumberBetBanking) sessionFactory.getCurrentSession()
                .createCriteria(BlockingNumberBetBanking.class)
                .setFetchMode("betBanking", FetchMode.JOIN)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return blockNumberEntity;
    }

    @Override
    public void delete(int blockingNumberId) {
        BlockingNumberBetBanking entity = findById(blockingNumberId);
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void deleteByBetBanking(int betBankingId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from BlockingNumberBetBanking bbl where bbl.betBanking.id = :id");
        query.setParameter("id", betBankingId);
        int rows = query.executeUpdate();
        LOG.log(Level.INFO, "{0} rows deleted.", rows);
    }

    @Override
    public boolean isNumberBlock(int betBankingId, int number) throws FindBlockingNumberException {
        LOG.log(Level.INFO, "Init - BlockingNumberBetBankingDaoImpl.isNumberBlock: " + betBankingId + ", " + number);
        boolean isBlock = false;
        try {
            BlockingNumberBetBanking blockNumberEntity = (BlockingNumberBetBanking) sessionFactory.getCurrentSession()
                    .createCriteria(BlockingNumberBetBanking.class)
                    .setFetchMode("betBanking", FetchMode.JOIN)
                    .createAlias("betBanking", "betBank")
                    .add(Restrictions.eq("betBank.id", betBankingId))
                    .add(Restrictions.eq("number", number))
                    .uniqueResult();
            if (blockNumberEntity != null) {
                isBlock = true;
            }
            LOG.log(Level.INFO, "End - BlockingNumberBetBankingDaoImpl.isNumberBlock: " + betBankingId + ", " + number);
            return isBlock;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error occur serch if a number is block");
            throw new FindBlockingNumberException(ex.getMessage() + ex.getCause());
        }
    }
}
