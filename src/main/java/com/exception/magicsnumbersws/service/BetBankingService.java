package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public BetBanking findById(int id);

    @Transactional(readOnly = true)
    public List<BetBanking> findAvailable() throws SearchAllBetBankingException;
    
    @Transactional(readOnly = true)
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException;
    
    @Transactional(readOnly = true)
    public List<BetBanking> findAll(int consortiumId) throws SearchAllBetBankingException;

    @Transactional(readOnly = true)
    public List<BetBanking> findAll() throws SearchAllBetBankingException;
    
    @Transactional(readOnly = true)
    public List<BetBanking> findByUserId(int userId) throws SearchAllBetBankingException;
}
