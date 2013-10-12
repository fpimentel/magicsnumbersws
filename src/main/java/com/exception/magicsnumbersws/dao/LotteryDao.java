package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.exception.FindLotteryException;
import java.util.List;


/**
 *
 * @author fpimentel
 * @since 12-Oct-2013
 */
public interface LotteryDao {

    public void add(Lottery lottery);

    public void update(Lottery lottery);

    public void delete(int lotteryId);
    
    public Lottery findById(int id);

    public List<Lottery> findActiveLottery() throws FindLotteryException;
    
    public List<Bet> findBetsByLotteryId(int lotteryId) throws FindLotteryException;
}
