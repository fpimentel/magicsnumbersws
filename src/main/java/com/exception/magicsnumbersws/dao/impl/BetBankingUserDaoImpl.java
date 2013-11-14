package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.BetBankingUserDao;
import com.exception.magicsnumbersws.entities.BetBankingUser;
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
public class BetBankingUserDaoImpl implements BetBankingUserDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(BetBankingUserDaoImpl.class.getName());

    public BetBankingUserDaoImpl() {
    }

    @Override
    public void add(BetBankingUser betBankingUser) {
        sessionFactory.getCurrentSession().save(betBankingUser);
    }

    @Override
    public void update(BetBankingUser betBankingUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int betBankingUserId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
