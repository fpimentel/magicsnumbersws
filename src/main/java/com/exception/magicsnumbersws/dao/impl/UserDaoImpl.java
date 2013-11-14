package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static int ACTIVO = 1;
    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int userId) {
        sessionFactory.getCurrentSession().delete(findById(userId));
    }

    @Override
    public User findById(int id) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .setFetchMode("consortiums", FetchMode.JOIN)
                .add(Restrictions.eq("id", id)).uniqueResult();
        return user;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByCredentials(String userName, String pass) {

        User userResult = (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .createAlias("status", "status")
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("profile", FetchMode.JOIN)
                .setFetchMode("profile.options", FetchMode.JOIN)
                .setFetchMode("betBankings", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", ACTIVO))
                .add(Restrictions.eq("userName", userName).ignoreCase())
                .add(Restrictions.eq("password", pass)).uniqueResult();

        User copyUser = new User();
        String[] userIgnoredProperties = {"consortiums", "betBankings"};
        final String[] BET_BANKING_IGNORED_PROPERTIES = {"lotteries", "consortium"};
        final String[] LOTTERY_IGNORED_PROPERTIES = {"bets",
            "status",
            "creationDate",
            "userCreation"
        };
        final String[] BET_IGNORED_PROPERTIES = {"status",
            "betType",
            "creationDate",
            "creationUser",
            "numberOfWayToWin",
            "numberQtyToPlay",
            "unitMultiplier",
            "minimumBetAmount",
            "lotteryNumberQty"
        };
        BeanUtils.copyProperties(userResult, copyUser, userIgnoredProperties);

        Set<BetBanking> copyBetBankings = new HashSet<BetBanking>();
        if (userResult != null) {
            for (BetBanking currBetBanking : userResult.getBetBankings()) {
                BetBanking copyBetBanking = new BetBanking();
                BeanUtils.copyProperties(currBetBanking, copyBetBanking, BET_BANKING_IGNORED_PROPERTIES);
                Set<Lottery> copyLotteries = new HashSet<Lottery>();
                copyBetBankings.add(copyBetBanking);
                for (Lottery currLottery : currBetBanking.getLotteries()) {
                    Lottery copyLottery = new Lottery();
                    BeanUtils.copyProperties(currLottery, copyLottery, LOTTERY_IGNORED_PROPERTIES);
                    Set<Bet> copyBets = new HashSet<Bet>();
                    for (Bet currBet : currLottery.getBets()) {
                        Bet copyBet = new Bet();
                        BeanUtils.copyProperties(currBet, copyBet, BET_IGNORED_PROPERTIES);
                        copyBets.add(copyBet);
                    }
                    copyLottery.setBets(copyBets);
                    copyLotteries.add(copyLottery);
                }
                copyBetBanking.setLotteries(copyLotteries);
            }
            copyUser.setBetBankings(copyBetBankings);
            copyUser.setConsortiums(null);
        }
        return copyUser;
    }

    @Override
    public List<User> findAll() throws SearchAllUserException {

        List<User> users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .setFetchMode("profile", FetchMode.JOIN)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("profile.options", FetchMode.JOIN)
                .setFetchMode("betBankings", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", ACTIVO))
                .list();
        String[] BET_BANKING_IGNORED_PROPERTIES = {"lotteries", "lotteries", "consortium", "status"};
        User copiedUser;
        List<User> finalUsers = new ArrayList<User>();

        for (User currUser : users) {
            copiedUser = new User();
            BeanUtils.copyProperties(currUser, copiedUser);
            copiedUser.setConsortiums(null);

            Set<BetBanking> betBankings = new HashSet<BetBanking>();
            for (BetBanking currBetBanking : currUser.getBetBankings()) {
                BetBanking copyBetBanking = new BetBanking();
                BeanUtils.copyProperties(currBetBanking, copyBetBanking, BET_BANKING_IGNORED_PROPERTIES);
                betBankings.add(copyBetBanking);
            }
            copiedUser.setBetBankings(betBankings);
            finalUsers.add(copiedUser);
        }
        return finalUsers;
    }

    @Override
    public void saveUsersData(List<User> users) throws SaveUsersDataException {
        for (User currUser : users) {
            User user = (User) sessionFactory.getCurrentSession().get(currUser.getClass(), currUser.getId());
            if (user != null) {
                BeanUtils.copyProperties(currUser, user);
                update(user);
            } else {
                add(currUser);
            }
        }
    }

    public void saveUser(User user) throws SaveUsersDataException {
        if (user != null) {
            if (user.getId() > 0) {//Update
                User userEntity = (User) sessionFactory.getCurrentSession().get(user.getClass(), user.getId());
                BeanUtils.copyProperties(user, userEntity);
                update(userEntity);
            } else {
                add(user);
            }
        }
    }

    @Override
    public User findByUserName(String userName) throws SearchAllUserException {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("userName", userName)).uniqueResult();
    }

    @Override
    public void deleteBetBankingsUserByUserId(int userId) {
        LOG.log(Level.INFO, "Init- deleteBetBankingsUserByUserId");
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("delete from BetBankingUser bbu where bbu.user.id = :userId");
            query.setParameter("userId", userId);
            int rows = query.executeUpdate();
            LOG.log(Level.INFO, "{0} rows deleted.", rows);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "error eliminando BetBanking_User by userId", ex);
        }

    }
}
