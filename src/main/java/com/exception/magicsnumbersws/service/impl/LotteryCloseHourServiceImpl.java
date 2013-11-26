package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.LotteryCloseHourDao;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.CloseHourLotteryConfigNotFoundtException;
import com.exception.magicsnumbersws.exception.FindLotteryCloseHourException;
import com.exception.magicsnumbersws.service.LotteryCloseHourService;
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
public class LotteryCloseHourServiceImpl implements LotteryCloseHourService {

    @Autowired
    private LotteryCloseHourDao lotteryCloseHourDao;
    private static final Logger LOG = Logger.getLogger(LotteryCloseHourServiceImpl.class.getName());

    public LotteryCloseHourServiceImpl() {
    }

    public LotteryCloseHourServiceImpl(LotteryCloseHourDao lotteryCloseHourDao) {
        this.lotteryCloseHourDao = lotteryCloseHourDao;
    }

    public LotteryCloseHourDao getLotteryCloseHourDao() {
        return lotteryCloseHourDao;
    }

    public void setLotteryCloseHourDao(LotteryCloseHourDao lotteryCloseHourDao) {
        this.lotteryCloseHourDao = lotteryCloseHourDao;
    }

    @Override
    public void add(LotteryCloseHour lotteryCloseHour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LotteryCloseHour lotteryCloseHour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int lotteryCloseHourId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LotteryCloseHour findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LotteryCloseHour> findAll() throws FindLotteryCloseHourException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public List<Time> findAvailableTimesByLotteryId(int lotteryId) throws FindLotteryCloseHourException, CloseHourLotteryConfigNotFoundtException {
        return lotteryCloseHourDao.findAvailableTimesByLotteryId(lotteryId);
    }

    @Transactional
    @Override
    public List<LotteryCloseHour> findAvailableCloseHour(int lotteryId) throws FindLotteryCloseHourException {
        return lotteryCloseHourDao.findAvailableCloseHour(lotteryId);
    }
}
