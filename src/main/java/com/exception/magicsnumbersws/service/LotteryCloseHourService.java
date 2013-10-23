package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.CloseHourLotteryConfigNotFoundtException;
import com.exception.magicsnumbersws.exception.FindLotteryCloseHourException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 21-Octubre-2013
 */
@Service
public interface LotteryCloseHourService {

   public void add(LotteryCloseHour lotteryCloseHour);
    public void update(LotteryCloseHour lotteryCloseHour);
    public void delete(int lotteryCloseHourId);
    public LotteryCloseHour findById(int id);
    public List<LotteryCloseHour> findAll() throws FindLotteryCloseHourException;
    public List<Time> findAvailableTimesByLotteryId(int lotteryId) throws FindLotteryCloseHourException,CloseHourLotteryConfigNotFoundtException;     
}
