package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.BetDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.service.BetService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Service
@Transactional
public class BetServiceImpl implements BetService {

    @Autowired
    private BetDao betDao;
    private static final Logger LOG = Logger.getLogger(BetServiceImpl.class.getName());

    public BetServiceImpl() {
    }

    public BetServiceImpl(BetDao betDao) {
        this.betDao = betDao;
    }

    public BetDao getBetDao() {
        return betDao;
    }

    public void setBetDao(BetDao betDao) {
        this.betDao = betDao;
    }

    @Override
    public void add(Bet bet) {
        betDao.add(bet);
    }

    @Override
    public void update(Bet bet) {
        betDao.update(bet);
    }

    @Override
    public void delete(int betId) {
        betDao.delete(betId);
    }

    @Override
    public Bet findById(int id) {
        return betDao.findById(id);
    }

    @Override
    public List<Bet> findActiveBets() throws FindBetException {
        LOG.info("init - findActiveBets");  
        return betDao.findActiveBets();
    }
}
