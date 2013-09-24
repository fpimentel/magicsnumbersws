package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
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

    /**
     * *
     * Encargado de devolver las bancas asignadas a los consorcios del
     * usuario.     
     * @param userId
     * @return List<BetBanking>
     * @throws SearchAllBetBankingException
     */
    @Transactional(readOnly = true)
    public List<BetBanking> findBetBankingsToConsortiumsAssignedToUser(int userId) throws SearchAllBetBankingException;
    
    
    /**
     * *
     * Obtiene las jugadas con sus limites    
     * @param betBankingId
     * @return List<BetBankingBetLimit>
     * @throws FindBetLimitException
     */
    @Transactional(readOnly = true)
    public List<BetBankingBetLimit> findBetLimitsByBetBankingId(int betBankingId) throws FindBetLimitException;        
}
