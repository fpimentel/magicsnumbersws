package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BetBankingBetLimitDao {

    public void add(BetBankingBetLimit betLimit);

    
    public void update(BetBankingBetLimit betLimit);

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(int betBankingBetLimitId);
        
    public void deleteByBetBanking(int betBankingId) ;
            
    public BetBankingBetLimit findById(int id);
}
