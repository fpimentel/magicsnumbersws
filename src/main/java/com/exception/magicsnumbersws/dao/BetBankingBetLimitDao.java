package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.exception.FindBetLimitException;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BetBankingBetLimitDao {

    public void add(BetBankingBetLimit betLimit);    
    public void update(BetBankingBetLimit betLimit);    
    public void delete(int betBankingBetLimitId);        
    public void deleteByBetBanking(int betBankingId) ;            
    public BetBankingBetLimit findById(int id);
    public String findBetBankingBetLimitAmount(int betBankingId,int lotteryId,int betId )throws FindBetLimitException;
}
