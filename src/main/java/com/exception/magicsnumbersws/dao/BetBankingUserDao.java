package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BetBankingUser;

/**
 *
 * @author fpimentel
 * @since 13-Nov-2013
 */
public interface BetBankingUserDao {

    public void add(BetBankingUser betBankingUser);    
    public void update(BetBankingUser betBankingUser);    
    public void delete(int betBankingUserId);                                
}
