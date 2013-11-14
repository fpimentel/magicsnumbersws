package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.constants.Profile;
import com.exception.magicsnumbersws.dao.UserConsortiumDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.entities.UserConsortium;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 * @since 02-Sept-2013
 */
@Repository
public class UserConsortiumDaoImpl implements UserConsortiumDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(UserConsortiumDaoImpl.class.getName());

    public UserConsortiumDaoImpl() {
    }

    @Override
    public void add(UserConsortium userConsortium) {
        sessionFactory.getCurrentSession().save(userConsortium);
    }

    @Override
    public void update(UserConsortium userConsortium) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int userConsortiumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findUsersByConsortiumIds(List<Integer> consortiumIds) throws SearchAllUserException {
        LOG.info("Init- UserConsortiumDaoImpl.findUsersByConsortiumIds");
        final String[] userIgnoredProperties = {"consortiums"};
        final String[] profileIgnoredProperties = {"options", "systemOptionId"};
        final String[] statusIgnoredProperties = {"statusTypeId"};
        final String[] betBankingIgnoredProperties = {"lotteries","consortium","status"};
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from UserConsortium uc where uc.user.profile.id != :admProfileId and uc.consortium.id in(:consortiumsIds)");
            query.setParameter("admProfileId", Profile.ADMINISTRATOR.getId());
            query.setParameterList("consortiumsIds", consortiumIds);
            List<UserConsortium> userConsoritums = query.list();
            List<User> usersResult = new ArrayList<User>();
            for (UserConsortium currUserConsortium : userConsoritums) {
                
                if (!usersResult.contains(currUserConsortium.getUser())) {
                    Set<BetBanking> copyBetBankings = new HashSet<BetBanking>();
                    User userCopy = new User();
                    com.exception.magicsnumbersws.entities.Profile profileCopy = new com.exception.magicsnumbersws.entities.Profile();
                    Status statusCopy = new Status();

                    BeanUtils.copyProperties(currUserConsortium.getUser(), userCopy, userIgnoredProperties);
                    BeanUtils.copyProperties(userCopy.getProfile(), profileCopy, profileIgnoredProperties);
                    BeanUtils.copyProperties(userCopy.getStatus(), statusCopy, statusIgnoredProperties);
                    if (userCopy.getBetBankings() != null) {
                        for (BetBanking currBetBanking : userCopy.getBetBankings()) {
                            BetBanking copyBetBanking = new BetBanking();
                            BeanUtils.copyProperties(currBetBanking, copyBetBanking, betBankingIgnoredProperties);
                            copyBetBankings.add(copyBetBanking);
                        }
                    }
                    userCopy.setBetBankings(copyBetBankings);
                    userCopy.setProfile(profileCopy);
                    userCopy.setStatus(statusCopy);

                    usersResult.add(userCopy);
                }
            }
            LOG.info("End- UserConsortiumDaoImpl.findUsersByConsortiumIds");
            return usersResult;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new SearchAllUserException(ex.getMessage());
        }
    }

    @Override
    public void deleteAllByUserId(int userId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from UserConsortium uc where uc.user.id = :userId");
        query.setParameter("userId", userId);
        int rows = query.executeUpdate();
        LOG.log(Level.INFO, "{0} rows deleted.", rows);
    }
}
