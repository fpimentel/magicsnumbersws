package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Repository
public class BetBankingDaoImpl implements BetBankingDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(BetBankingDaoImpl.class.getName());

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
        List<BetBanking> betBankings = (List<BetBanking>) sessionFactory                                
                .getCurrentSession().createCriteria(BetBanking.class)
                .add(Restrictions.isNull("consortium")).list();
        
        String [] betBankingIgnoredProperties = {"lotteries"};
        List<BetBanking> copyBetBakings = new ArrayList<BetBanking>();
        for(BetBanking currBetBanking : betBankings){
            BetBanking copyBetBanking = new BetBanking();
            BeanUtils.copyProperties(currBetBanking, copyBetBanking,betBankingIgnoredProperties);
            copyBetBakings.add(copyBetBanking);
        }
        return copyBetBakings;
    }
    
    @Override    
    public BetBanking findById(int id) {       
        final String[] betBankingIgnoredProperties = {"lotteries","consortium","status"};
        BetBanking copyBetBanking = new BetBanking();
        
        BetBanking betBanking = (BetBanking) sessionFactory.getCurrentSession()
                 .createCriteria(BetBanking.class)                 
                 .add(Restrictions.eq("id", id))
                 .uniqueResult();
        
        BeanUtils.copyProperties(betBanking, copyBetBanking,betBankingIgnoredProperties);
        return copyBetBanking;
    }

    public Consortium findConsortiumByBetBankingId(int betBankingId) {                               
        BetBanking betBanking = (BetBanking) sessionFactory.getCurrentSession()
                 .createCriteria(BetBanking.class)                 
                 .add(Restrictions.eq("id", betBankingId))
                 .uniqueResult();                
        return betBanking.getConsortium();
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
            copiedBetBanking.setLotteries(null);
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
        for (BetBanking currBetBanking : result) {
            currBetBanking.setConsortium(null);
        }
    }

    @Override
    public void assingConsortium(Consortium cons) {
        for (BetBanking currBanking : cons.getBetBankings()) {
            BetBanking betBanking = findById(currBanking.getId());
            BetBanking betBankingToUpdate = new BetBanking();
            BeanUtils.copyProperties(betBanking, betBankingToUpdate, new String[]{"lotteries"});
            currBanking.setConsortium(cons);
            update(betBankingToUpdate);
        }
    }

    @Override
    public List<BetBanking> findAll() throws SearchAllBetBankingException {
        List<BetBanking> result = (List<BetBanking>) sessionFactory
                .getCurrentSession()
                .createCriteria(BetBanking.class)
                .setFetchMode("consortium", FetchMode.JOIN)
                .list();
        //Null en la data no requerida en el json.        
        for (BetBanking currBetBanking : result) {
            if (currBetBanking.getConsortium() != null) {
                currBetBanking.getConsortium().setBetBankings(null);
                if (currBetBanking.getConsortium().getUsers() != null) {
                    currBetBanking.getConsortium().setUsers(null);
                }
                if (currBetBanking.getConsortium().getStatus() != null) {
                    currBetBanking.getConsortium().setStatus(null);
                }
            }
            currBetBanking.setLotteries(null);
        }
        return result;
    }

    @Override
    public List<BetBanking> findByUserId(int userId) throws SearchAllBetBankingException {
        User user = (User) sessionFactory
                .getCurrentSession()
                .createCriteria(User.class)
                .setFetchMode("betBankings", FetchMode.JOIN)
                .add(Restrictions.eq("id", userId)).uniqueResult();
        Set<BetBanking> bankings = new HashSet<BetBanking>(0);
        if (user != null) {
            bankings = user.getBetBankings();
            if (bankings != null) {
                for (BetBanking betBanking : bankings) {
                    betBanking.setConsortium(null);
                }
            }
        }
        return new ArrayList(bankings);
    }

    @Override
    public List<BetBanking> findBetBankingsToConsortiumsAssignedToUser(int userId) throws SearchAllBetBankingException {
        LOG.info("init - BetBankingDaoImpl.findBetBankingsToConsortiumsAssignedToUser(" + userId);
        List<BetBanking> betBankings = new ArrayList();
        User user = (User) sessionFactory
                .getCurrentSession()
                .createCriteria(User.class)
                .setFetchMode("consortiums", FetchMode.JOIN)
                .add(Restrictions.eq("id", userId)).uniqueResult();

        final String [] BET_BANKING_INGORED_PROPERTIES = {"lotteries"};
        final String [] CONSORTIUM_INGORED_PROPERTIES = {"betBankings","users","status"};        
        
        Set<Consortium> consortiums = user.getConsortiums();

        for (Consortium consortium : consortiums) {            
            for(BetBanking currBetBanking : consortium.getBetBankings()){
                BetBanking copyBetBanking = new BetBanking();
                Consortium copyConsortium = new Consortium();
                BeanUtils.copyProperties(currBetBanking, copyBetBanking, BET_BANKING_INGORED_PROPERTIES);
                BeanUtils.copyProperties(currBetBanking.getConsortium(), copyConsortium, CONSORTIUM_INGORED_PROPERTIES);
                copyBetBanking.setConsortium(copyConsortium);
                betBankings.add(copyBetBanking);
            }            
        }
        LOG.info("finish - BetBankingDaoImpl.findBetBankingsToConsortiumsAssignedToUser(" + userId);
        return betBankings;
    }

    
    @Override    
    public List<BetBankingBetLimit> findBetLimitsByBetBankingId(int betBankingId) throws FindBetLimitException {
        LOG.info("init - BetBankingDaoImpl.findBetLimitsByBetBankingId(" + betBankingId);
        List<BetBankingBetLimit> betLimits = sessionFactory                
                .getCurrentSession()                
                .createCriteria(BetBankingBetLimit.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .setFetchMode("bet", FetchMode.JOIN)
                .setFetchMode("lottery", FetchMode.JOIN)
                .setFetchMode("lottery.bets", FetchMode.JOIN)
                .add(Restrictions.eq("betBanking.id", betBankingId)).list();
        
        String[] betBankingBetLimitIgnoredProperties = {"creationDate","betBanking","bet"};
        String[] betIgnoredProperties = {"creationDate","betType"};
        String[] lotteryIgnoredProperties = {"bets"};
        List<BetBankingBetLimit> copiedBetLimits = new ArrayList<BetBankingBetLimit>();
        
        //Quitamos del json los datos innecesarios
        for (BetBankingBetLimit betLimit : betLimits) {
            BetBankingBetLimit copiedBetLimit = new BetBankingBetLimit();
            BeanUtils.copyProperties(betLimit, copiedBetLimit, betBankingBetLimitIgnoredProperties);
            Bet copiedBet = new Bet();            
            BeanUtils.copyProperties(betLimit.getBet(), copiedBet,betIgnoredProperties);
            copiedBetLimit.setBet(copiedBet);
                        
            Lottery copyLottery = new Lottery();
            BeanUtils.copyProperties(betLimit.getLottery(), copyLottery);
            //Detaching bets collections
            Set<Bet> copiedBets = new HashSet<Bet>();
            for(Bet currBet : copyLottery.getBets()){
                Bet betCopy = new Bet();
                BeanUtils.copyProperties(currBet, betCopy,betIgnoredProperties);
                
                copiedBets.add(betCopy);
            }   
            copyLottery.setBets(copiedBets);
            copiedBetLimit.setLottery(copyLottery);            
            copiedBetLimits.add(copiedBetLimit);
        }
        return copiedBetLimits;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BlockingNumberBetBanking> findBlokingNumbersByBetBankingId(int betBankingId) throws FindBlockingNumberException {
        LOG.info("init - BetBankingDaoImpl.findBlokingNumbersByBetBankingId: " + betBankingId);
        List<BlockingNumberBetBanking> blockingNumbers = sessionFactory
                .getCurrentSession()
                .createCriteria(BlockingNumberBetBanking.class)
                .setFetchMode("betBanking", FetchMode.JOIN)
                .add(Restrictions.eq("betBanking.id", betBankingId)).list();

        for(BlockingNumberBetBanking blockNumber : blockingNumbers){
            blockNumber.getBetBanking().setConsortium(null);
            blockNumber.getBetBanking().setLotteries(null);
        }
        return blockingNumbers;
    }

    @Override
    public List<Bet> findBetsByLotteryAndBetBanking(int lotteryId, int betBankingId) throws FindBetException {
        LOG.info("init - BetBankingDaoImpl.findBetsByLotteryAndBetBanking(: "+ lotteryId +" " + betBankingId);
        List<BetBankingBetLimit> betLimits = sessionFactory                
                .getCurrentSession()                
                .createCriteria(BetBankingBetLimit.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .setFetchMode("bet", FetchMode.JOIN)
                .setFetchMode("lottery", FetchMode.JOIN)     
                .setFetchMode("betBanking", FetchMode.JOIN)                     
                .add(Restrictions.eq("betBanking.id", betBankingId))
                .add(Restrictions.eq("lottery.id", lotteryId))
                .list();            
        List<Bet> bets = new ArrayList<Bet>();
        String[] betIgnoredProperties = {"status","betType","creationDate","creationUser"};
        for(BetBankingBetLimit currBetLimit : betLimits){
            Bet betObj = new Bet();
            BeanUtils.copyProperties(currBetLimit.getBet(), betObj,betIgnoredProperties);            
            bets.add(betObj);
        }
        LOG.info("finish - BetBankingDaoImpl.findBetsByLotteryAndBetBanking(: "+ lotteryId +" " + betBankingId);
        return bets;    
    }
}
