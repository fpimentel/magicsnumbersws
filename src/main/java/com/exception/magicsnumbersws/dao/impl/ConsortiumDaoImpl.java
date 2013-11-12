package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.dao.ConsortiumDao;
import com.exception.magicsnumbersws.dao.UserDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 * @since 02-sept-2013
 */
@Repository
public class ConsortiumDaoImpl implements ConsortiumDao {

    private static int ACTIVO = 1;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private BetBankingDao betBankingDao;
    @Autowired
    private UserDao userDao;

    public ConsortiumDaoImpl() {
    }

    public ConsortiumDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return @throws SearchAllSystemOptionException
     */
    @Override
    public List<Consortium> findActiveConsortium() throws SearchAllConsortiumException {
        List<Consortium> consortiums = sessionFactory.getCurrentSession()
                .createCriteria(Consortium.class)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("users", FetchMode.JOIN)
                .setFetchMode("betBankings", FetchMode.JOIN)
                .add(Restrictions.eq("status.id", ACTIVO))
                .list();
        String[] userIgnoredProperties = {"profile", "status", "consortiums"};
        String[] betBankingIgnoredProperties = {"lotteries", "consortium", "status"};
        Set<User> users;
        Set<BetBanking> betBankings;
        for (Consortium consortium : consortiums) {
           // consortium.setBetBankings(null);
            users = new HashSet<User>();
            betBankings = new HashSet<BetBanking>();

            if (consortium.getUsers() != null) {
                for (User currUser : consortium.getUsers()) {
                    currUser.setBetBankings(null);
                    User copyUser = new User();
                    BeanUtils.copyProperties(currUser, copyUser, userIgnoredProperties);
                    users.add(copyUser);
                }
            }

            if (consortium.getBetBankings() != null) {
                for (BetBanking currBetBanking : consortium.getBetBankings()) {
                    BetBanking copyBetBanking = new BetBanking();
                    BeanUtils.copyProperties(currBetBanking, copyBetBanking, betBankingIgnoredProperties);
                    betBankings.add(copyBetBanking);
                }
            }

            consortium.setUsers(users);
            consortium.setBetBankings(betBankings);
        }
        return consortiums;
    }

    @Override
    public void add(Consortium consortium) {
        sessionFactory.getCurrentSession().save(consortium);
    }

    @Override
    public void update(Consortium consortium) {
        sessionFactory.getCurrentSession().update(consortium);
    }

    @Override
    public List<Consortium> findByUserId(int userId) throws SearchAllConsortiumException {
        if (userId <= 0) {
            return null;
        }
        String[] userIgnoredProperties = {"betBankings", "profile", "status", "consortiums"};
        String[] betBankingIgnoredProperties = {"lotteries", "consortium", "status"};
        User userResult = (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("consortiums", FetchMode.JOIN)
                .setFetchMode("consortiums.betBankings", FetchMode.JOIN)
                .setFetchMode("consortiums.status", FetchMode.JOIN)
                .setFetchMode("consortiums.users", FetchMode.JOIN)
                .createAlias("consortiums", "consortium")
                .add(Restrictions.eq("status.id", ACTIVO))
                .add(Restrictions.eq("id", userId))
                .uniqueResult();

        Consortium copiedConsortium;
        List<Consortium> finalConsortiums = new ArrayList<Consortium>();
        Set<User> users;
        Set<BetBanking> betBankings;
        if (userResult != null) {
            if (userResult.getConsortiums() != null) {
                for (Consortium currConsortium : userResult.getConsortiums()) {
                    betBankings = new HashSet<BetBanking>();
                    copiedConsortium = new Consortium();
                    users = new HashSet<User>();
                    BeanUtils.copyProperties(currConsortium, copiedConsortium);
                    
                    for (User currUser : copiedConsortium.getUsers()) {
                        currUser.setBetBankings(null);
                        User copyUser = new User();
                        BeanUtils.copyProperties(currUser, copyUser, userIgnoredProperties);
                        users.add(copyUser);
                    }
                    for (BetBanking currBetBanking : currConsortium.getBetBankings()) {
                        BetBanking copyBetBanking = new BetBanking();
                        BeanUtils.copyProperties(currBetBanking, copyBetBanking, betBankingIgnoredProperties);
                        betBankings.add(copyBetBanking);
                    }
                    copiedConsortium.setUsers(users);
                    copiedConsortium.setBetBankings(betBankings);
                    finalConsortiums.add(copiedConsortium);
                }
            }
        }
        return finalConsortiums;
    }

    @Override
    public void saveConsortiumsData(List<Consortium> consortiums) throws SaveConsortiumDataException {
        try {
            for (Consortium currConsortium : consortiums) {
                Consortium consortium = (Consortium) sessionFactory.getCurrentSession()
                        .get(currConsortium.getClass(), currConsortium.getId());
                if (consortium != null) {
                    BeanUtils.copyProperties(currConsortium, consortium);
                    update(consortium);
                } else {
                    add(currConsortium);
                }
            }
        } catch (Exception ex) {
            throw new SaveConsortiumDataException();
        }
    }

    @Override
    public void delete(int consortiumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemOption findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveConsortiumData(Consortium consortium) throws SaveConsortiumDataException {
        if (consortium == null) {
            throw new SaveConsortiumDataException();//Reemplazar por la exception EMPTYCOMSORTIUMEXCEPTION
        }
        try {
            if (consortium.getId() != null) {//Editar consorcio
                Consortium cons = (Consortium) sessionFactory.getCurrentSession()
                        .get(consortium.getClass(), consortium.getId());
                //Primero ponemos a null el consorcio asociado a las bancas (para resetear data))
                betBankingDao.deleteAssigned(cons.getId());
                if (cons != null) {
                    BeanUtils.copyProperties(consortium, cons, new String[]{"users"});
                    update(cons);
                    //Segundo asociamos el consorcio a las bancas
                    betBankingDao.assingConsortium(cons);
                }
            } else {//Agregar nuevo consorcio   
                //Por defecto, se asocia el nuevo consorcio al usuario que lo creo.
                User user = userDao.findByUserName(consortium.getCreationUser());
                consortium.getUsers().add(user);
                consortium.setCreationDate(new Date());
                add(consortium);
                //Se asocian las bancas al consorcio creado.
                betBankingDao.assingConsortium(consortium);
            }
        } catch (Exception ex) {
            throw new SaveConsortiumDataException();
        }
    }
}
