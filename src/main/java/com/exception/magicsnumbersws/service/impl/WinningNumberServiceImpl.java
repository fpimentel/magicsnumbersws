package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.WinningNumberDao;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.SaveWinningNumberDataException;
import com.exception.magicsnumbersws.exception.SearchWinningNumbersException;
import com.exception.magicsnumbersws.service.WinningNumberService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cpimentel
 * @since 21-dic-2013
 */
@Service
@Transactional
public class WinningNumberServiceImpl implements WinningNumberService {

    private static final Logger LOG = Logger.getLogger(WinningNumberServiceImpl.class.getName());
    @Autowired
    private WinningNumberDao winningNumberDao;

    public WinningNumberServiceImpl() {
    }

    public WinningNumberServiceImpl(WinningNumberDao betBankingDao) {
        this.winningNumberDao = betBankingDao;
    }

    public WinningNumberDao getWinningNumberDao() {
        return winningNumberDao;
    }

    public void setWinningNumberDao(WinningNumberDao winningNumberDao) {
        this.winningNumberDao = winningNumberDao;
    }

    @Override
    public void saveWinningNumberInfo(WinningNumber winningNumber) throws SaveWinningNumberDataException {
        if (winningNumber.getId() == null) {
            this.winningNumberDao.add(winningNumber);
        } else {
            this.winningNumberDao.update(winningNumber);
        }
    }

    @Override
    public void update(WinningNumber winningNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int winningNumberId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WinningNumber> findWinningNumber(String fromDate, String ToDate) throws SearchWinningNumbersException {
        final String[] WINNING_IGNORED_PROPERTIES = {"time", "Lottery"};
        final String[] LOTTERY_IGNORED_PROPERTIES = {"bets", "status"};
        List<WinningNumber> winningNumbersFromDB = this.winningNumberDao.findWinningNumber(fromDate, ToDate);
        List<WinningNumber> winningNumbersResult = new ArrayList<WinningNumber>();
        for (WinningNumber currWinningNumber : winningNumbersFromDB) {
            WinningNumber winningNumberCopy = new WinningNumber();
            Time timeCopy = new Time();
            Lottery lotteryCopy = new Lottery();
            BeanUtils.copyProperties(currWinningNumber, winningNumberCopy, WINNING_IGNORED_PROPERTIES);
            BeanUtils.copyProperties(currWinningNumber.getLottery(), lotteryCopy, LOTTERY_IGNORED_PROPERTIES);
            BeanUtils.copyProperties(currWinningNumber.getTime(), timeCopy);
            winningNumberCopy.setLottery(lotteryCopy);
            winningNumberCopy.setTime(timeCopy);
            winningNumbersResult.add(winningNumberCopy);
        }
        return winningNumbersResult;
    }

    @Override
    public WinningNumber findWinningNumber(int lotteryId, int timeId, String drawingDate) throws SearchWinningNumbersException {
        final String[] WINNING_IGNORED_PROPERTIES = {"time", "Lottery"};
        final String[] LOTTERY_IGNORED_PROPERTIES = {"bets", "status"};
        WinningNumber winningNumberFromDB = this.winningNumberDao.findWinningNumber(lotteryId, timeId, drawingDate);

        WinningNumber winningNumberCopy = new WinningNumber();
        Time timeCopy = new Time();
        Lottery lotteryCopy = new Lottery();
        BeanUtils.copyProperties(winningNumberFromDB, winningNumberCopy, WINNING_IGNORED_PROPERTIES);
        BeanUtils.copyProperties(winningNumberFromDB.getLottery(), lotteryCopy, LOTTERY_IGNORED_PROPERTIES);
        BeanUtils.copyProperties(winningNumberFromDB.getTime(), timeCopy);
        winningNumberCopy.setLottery(lotteryCopy);
        winningNumberCopy.setTime(timeCopy);       

        return winningNumberCopy;
    }
}
