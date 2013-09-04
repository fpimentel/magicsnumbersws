package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.dao.CategoryDao;
import com.exception.magicsnumbersws.dao.StatusDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.ArrayList;
import java.util.List;
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
       List<BetBanking> result =  (List<BetBanking>) sessionFactory.getCurrentSession().createCriteria(BetBanking.class)                 
                 .add(Restrictions.eq("consortium.id", consortiumId)).list();
       BetBanking copiedBetBanking;       
       List<BetBanking> finalBetBankings = new ArrayList<BetBanking>();
       for(BetBanking currBetBanking :result){
           copiedBetBanking = new BetBanking();
           BeanUtils.copyProperties(currBetBanking, copiedBetBanking);
           copiedBetBanking.setConsortium(null);
           finalBetBankings.add(copiedBetBanking);
       }
       return finalBetBankings;       
    }
}
