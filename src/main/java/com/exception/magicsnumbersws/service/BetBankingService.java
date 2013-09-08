package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Service
public interface BetBankingService {
        
    public void add(BetBanking betBanking);   
    public void update(BetBanking betBanking);
    public void delete(int betBankingId);
    public BetBanking findById(int id);    
    public List<BetBanking> findAvailable() throws SearchAllBetBankingException;     
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException;
    public List<BetBanking> findAll(int consortiumId) throws SearchAllBetBankingException;  
}
