package com.exception.magicsnumbersws.dao.impl;

import java.util.List;
import java.util.logging.Logger;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exception.magicsnumbersws.constants.Status;
import com.exception.magicsnumbersws.dao.LotteryDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.exception.FindLotteryException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import org.hibernate.Criteria;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author fpimentel
 * @since 12-Oct-2013
 */
@Repository
public class LotteryDaoImpl implements LotteryDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(LotteryDaoImpl.class.getName());

    public LotteryDaoImpl() {
    }

    public LotteryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Lottery lottery) {
        sessionFactory.getCurrentSession().save(lottery);
    }

    @Override
    public void update(Lottery lottery) {
        sessionFactory.getCurrentSession().update(lottery);
    }

    @Override
    public void delete(int lotteryId) {
        sessionFactory.getCurrentSession().delete(findById(lotteryId));
    }

    @Override
    public Lottery findById(int id) {
        LOG.entering("Lottery", "findById");
        Lottery lottery = (Lottery) sessionFactory.getCurrentSession()
                .createCriteria(Lottery.class)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("bets", FetchMode.JOIN)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("status.id", Status.ACTIVE.getId()))
                .uniqueResult();

        Lottery copyLottery = new Lottery();
        String[] lotteryIgnoredProperties = {"bets"};
        String[] betIgnoreProperties = {"status", "betType"};

        BeanUtils.copyProperties(lottery, copyLottery, lotteryIgnoredProperties);

        for (Bet currBet : lottery.getBets()) {
            Bet copyBet = new Bet();
            BeanUtils.copyProperties(currBet, copyBet, betIgnoreProperties);
            copyLottery.getBets().add(copyBet);
        }
        return copyLottery;
    }

    @Override
    public List<Lottery> findActiveLottery() throws FindLotteryException {
        LOG.entering("LotteryDaoImpl", "findActiveLottery");

        List<Lottery> lotteries = (List<Lottery>) sessionFactory.getCurrentSession()
                .createCriteria(Lottery.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("bets", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", Status.ACTIVE.getId()))
                .list();

        String[] lotteryIgnoredProperties = {"bets"};
        String[] betIgnoredProperties = {"status", "betType"};
        List<Lottery> lotteriesCopy = new ArrayList<Lottery>();

        for (Lottery currLottery : lotteries) {
            Lottery lotteryCopy = new Lottery();
            BeanUtils.copyProperties(currLottery, lotteryCopy, lotteryIgnoredProperties);
            for (Bet currBet : currLottery.getBets()) {
                Bet betCopy = new Bet();
                BeanUtils.copyProperties(currBet, betCopy, betIgnoredProperties);
                lotteryCopy.getBets().add(betCopy);
            }
            lotteriesCopy.add(lotteryCopy);
        }
        return lotteriesCopy;
    }

    @Override
    public List<Bet> findBetsByLotteryId(int lotteryId) throws FindLotteryException {
        LOG.entering("LotteryDaoImpl", "findBetsByLotteryId");
        Lottery lottery = findById(lotteryId);
        return new ArrayList(lottery.getBets());
    }

    @Override
    public List<Lottery> findLotteries() throws FindLotteryException {
        LOG.entering("LotteryDaoImpl", "findActiveLottery");
        try {
            String[] LOTTERY_IGNORED_PROPERTIES = {"bets","status"};
            String[] STATUS_IGNORED_PROPERTIES = {"bets"};
            String[] BET_IGNORED_PROPERTIES = {"status","betType"};
            List<Lottery> copylotteries = new ArrayList<Lottery>();
            List<Lottery> lotteries = (List<Lottery>) sessionFactory.getCurrentSession()
                    .createCriteria(Lottery.class)
                    .setFetchMode("bets", FetchMode.JOIN)
                    .list();
            for(Lottery currLottery : lotteries){
                Lottery copyLottery = new Lottery();
                com.exception.magicsnumbersws.entities.Status statusCopy = new com.exception.magicsnumbersws.entities.Status();
                BeanUtils.copyProperties(currLottery, copyLottery, LOTTERY_IGNORED_PROPERTIES);
                Set<Bet> copyBets = new HashSet<Bet>();
                for(Bet currBet : currLottery.getBets()){
                    Bet copyBet = new Bet();
                    BeanUtils.copyProperties(currBet, copyBet, BET_IGNORED_PROPERTIES);
                    copyBets.add(copyBet);
                }
                copyLottery.setBets(copyBets);
                BeanUtils.copyProperties(currLottery.getStatus(),statusCopy, STATUS_IGNORED_PROPERTIES);
                copyLottery.setStatus(statusCopy);
                copylotteries.add(copyLottery);
            }
            
            LOG.log(Level.INFO, "End-findLotteries");
            return copylotteries;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new FindLotteryException();
        }
    }
}
