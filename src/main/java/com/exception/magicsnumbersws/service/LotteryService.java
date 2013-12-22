package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.containers.LotteryContainer;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.exception.FindLotteryException;
import com.exception.magicsnumbersws.exception.SaveLotteryException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 12-Oct-2013
 */
public interface LotteryService {

    public void add(Lottery bet);

    public void update(Lottery bet);

    public void delete(int lotteryId);
    
    public Lottery findById(int id) throws FindLotteryException;
   
    public List<Lottery> findActiveLottery() throws FindLotteryException;
    
    public List<Bet> findBetsByLotteryId(int lotteryId) throws FindLotteryException;
    
    public List<Lottery> findLotteries() throws FindLotteryException;  
    
    public void saveLotteryInfo(LotteryContainer lotteryContainer) throws SaveLotteryException; 
}
