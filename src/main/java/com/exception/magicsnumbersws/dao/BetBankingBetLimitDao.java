package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BetBankingBetLimitDao {

    public void add(BetBankingBetLimit betLimit);

    public void update(BetBankingBetLimit betLimit);

    public void delete(int betBankingBetLimitId);
        
    public BetBankingBetLimit findById(int id);
}
