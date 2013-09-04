package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BetBankingDao {
    public void add(BetBanking betBanking);   
    public void update(BetBanking betBanking);
    public void delete(int betBankingId);
    public BetBanking findById(int id);    
    public List<BetBanking> findAvailable() throws SearchAllBetBankingException;  
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException;  
}
