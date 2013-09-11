package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
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
 * @since 31-agosto-2013
 */
@Repository
public class BetBankingDaoImpl implements BetBankingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public BetBankingDaoImpl() {
    }

    public BetBankingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(int categoryId) {
        sessionFactory.getCurrentSession().delete(findById(categoryId));
    }

    @Override
    public void add(BetBanking betBanking) {
        sessionFactory.getCurrentSession().save(betBanking);
    }

    @Override
    public void update(BetBanking betBanking) {
        sessionFactory.getCurrentSession().update(betBanking);
    }

    @Override
    public List<BetBanking> findAvailable() throws SearchAllBetBankingException {
        return (List<BetBanking>) sessionFactory.getCurrentSession().createCriteria(BetBanking.class)
                .add(Restrictions.isNull("consortium")).list();
    }

    @Override
    public BetBanking findById(int id) {
        return (BetBanking) sessionFactory.getCurrentSession().get(BetBanking.class, id);
    }

    @Override
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException {
        List<BetBanking> result = (List<BetBanking>) sessionFactory.getCurrentSession().createCriteria(BetBanking.class)
                .add(Restrictions.eq("consortium.id", consortiumId)).list();
        BetBanking copiedBetBanking;
        List<BetBanking> finalBetBankings = new ArrayList<BetBanking>();
        for (BetBanking currBetBanking : result) {
            copiedBetBanking = new BetBanking();
            BeanUtils.copyProperties(currBetBanking, copiedBetBanking);
            copiedBetBanking.setConsortium(null);
            finalBetBankings.add(copiedBetBanking);
        }
        return finalBetBankings;
    }

    //Encargado de obtener las bancas disponibles y asignadas a un consorcio(Para el betBankingConverter)
    @Override
    public List<BetBanking> findAll(int consortiumId) throws SearchAllBetBankingException {
        List<BetBanking> assigned = findAsigned(consortiumId);
        List<BetBanking> availables = findAvailable();
        List<BetBanking> results = new ArrayList<BetBanking>(availables);
        results.addAll(assigned);
        return results;
    }
    
    
    @Override
    public void deleteAssigned(int consortiumIdToDelete) {
        List<BetBanking> result = (List<BetBanking>) sessionFactory.getCurrentSession().createCriteria(BetBanking.class)
                .add(Restrictions.eq("consortium.id", consortiumIdToDelete)).list();
        BetBanking copiedBetBanking;
        // List<BetBanking> finalBetBankings = new ArrayList<BetBanking>();
        for (BetBanking currBetBanking : result) {
            currBetBanking.setConsortium(null);
            //copiedBetBanking = new BetBanking();
            // BeanUtils.copyProperties(currBetBanking, copiedBetBanking);
            //copiedBetBanking.setConsortium(null);
            // finalBetBankings.add(copiedBetBanking);
        }
    }

    @Override
    public void assingConsortium(Consortium cons) {
        for (BetBanking currBanking : cons.getBetBankings()) {
            BetBanking betBanking = findById(currBanking.getId());
            betBanking.setConsortium(cons);
            update(betBanking);
        }
    }

    @Override
    public List<BetBanking> findAll() throws SearchAllBetBankingException {
        List<BetBanking> result = (List<BetBanking>) sessionFactory
                                    .getCurrentSession()
                                    .createCriteria(BetBanking.class)
                                    .setFetchMode("consortium", FetchMode.JOIN)
                                    .list();
        BetBanking copiedBetBanking;
        List<BetBanking> finalBetBankings = new ArrayList<BetBanking>();
        for (BetBanking currBetBanking : result) {
            copiedBetBanking = new BetBanking();
            BeanUtils.copyProperties(currBetBanking, copiedBetBanking);
            //copiedBetBanking.setConsortium(null);
            finalBetBankings.add(copiedBetBanking);
        }
        return finalBetBankings;
    }
}
