package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.dao.BetDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exception.magicsnumbersws.constants.Status;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author fpimentel
 * @since 18-Septiembre-2013
 */
@Repository
public class BetDaoImpl implements BetDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(BetDaoImpl.class.getName());

    public BetDaoImpl() {
    }

    public BetDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Bet bet) {
        sessionFactory.getCurrentSession().save(bet);
    }

    @Override
    public void update(Bet bet) {
        sessionFactory.getCurrentSession().update(bet);
    }

    @Override
    public void delete(int betId) {
        sessionFactory.getCurrentSession().delete(findById(betId));
    }

    @Override
    public Bet findById(int id) {                  
         Bet bet = (Bet) sessionFactory.getCurrentSession()
                 .createCriteria(Bet.class)
                 .setFetchMode("betType", FetchMode.JOIN)
                 .setFetchMode("status", FetchMode.JOIN)
                 .add(Restrictions.eq("id", id))
                 .uniqueResult();
         
         return bet;        
    }    

  

    @Override
    public List<Bet> findActiveBets() throws FindBetException {
        LOG.info("init - findActiveBets");  
        return (List<Bet>) sessionFactory.getCurrentSession()
                .createCriteria(Bet.class)
                .setFetchMode("betType", FetchMode.JOIN)
                .setFetchMode("status", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", Status.ACTIVE.getId()))
                .list();
    }

}
