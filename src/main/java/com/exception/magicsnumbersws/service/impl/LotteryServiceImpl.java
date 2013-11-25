package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.LotteryDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.exception.FindLotteryException;
import com.exception.magicsnumbersws.service.LotteryService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 12-agosto-2013
 */
@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private LotteryDao lotteryDao;
    
    private static final Logger LOG = Logger.getLogger(LotteryServiceImpl.class.getName());

    public LotteryServiceImpl() {
    }

    public LotteryServiceImpl(LotteryDao lotteryDao) {
        this.lotteryDao = lotteryDao;
    }

    @Override
    public void add(Lottery bet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Lottery bet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int lotteryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = true)
    @Override
    public Lottery findById(int id) throws FindLotteryException {
        return lotteryDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Lottery> findActiveLottery() throws FindLotteryException {
        return this.lotteryDao.findActiveLottery();
    }   

    @Transactional(readOnly = true)
    @Override
    public List<Bet> findBetsByLotteryId(int lotteryId) throws FindLotteryException {
        return this.lotteryDao.findBetsByLotteryId(lotteryId);
    }

    @Transactional
    @Override
    public List<Lottery> findLotteries() throws FindLotteryException {
        return this.lotteryDao.findLotteries();
    }
}
