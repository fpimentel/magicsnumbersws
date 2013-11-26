package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.CloseHourLotteryConfigNotFoundtException;
import com.exception.magicsnumbersws.exception.FindLotteryCloseHourException;
import java.util.List;

/**
 *
 * @author fpimentel
 */
public interface LotteryCloseHourDao {
    public void add(LotteryCloseHour lotteryCloseHour);
    public void update(LotteryCloseHour lotteryCloseHour);
    public void delete(int lotteryCloseHourId);
    public LotteryCloseHour findById(int id);
    public List<LotteryCloseHour> findAll() throws FindLotteryCloseHourException;
    public List<Time> findAvailableTimesByLotteryId(int lotteryId) throws FindLotteryCloseHourException,CloseHourLotteryConfigNotFoundtException;
    public List<LotteryCloseHour> findAvailableCloseHour(int lotteryId) throws FindLotteryCloseHourException;
    public void deleteAllByLotteryId(int lotteryId);
    
}
