package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.exception.DeleteBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.SaveBetBankingInfoException;
import com.exception.magicsnumbersws.exception.SaveBlockingNumberException;
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
    
    
    /**
     * *
     * Obtiene los numeros bloqueados de una banca.
     *
     * @param betBankingId
     * @return List<BlockingNumberBetBanking>
     * @throws FindBlockingNumberException
     */
    @Transactional(readOnly = true)
    public List<BlockingNumberBetBanking> findBlokingNumbersByBetBankingId(int betBankingId) throws FindBlockingNumberException;
    
    /**
     * *
     * Guarda la informacion del objeto BetBanking.     
     * @param betBanking     
     * @throws SaveBetBankingInfoException
     */    
    public void saveBetBankingInformation(BetBanking betBanking) throws SaveBetBankingInfoException;
    
    /**
     * *
     * Guarda la informacion de las jugadas asocciada a la banca.     
     * @param betLimits     
     * @throws SaveBetBankingInfoException
     */    
    public void saveBetBankingBetLimits(List<BetBankingBetLimit> betLimits) throws SaveBetBankingBetLimitException, FindBetLimitException, DeleteBetBankingBetLimitException;
    
    
    /**
     * *
     * Elimina todas los betLimits asociados a una banca.
     * @param betBankingId     
     * @throws DeleteBetBankingBetLimitException,FindBetLimitException
     */ 
    public void deleteBetLimitsByBetBankingId(int betBankingId) throws DeleteBetBankingBetLimitException, FindBetLimitException;   
    
    /**
     * *
     * Guarda la informacion de los numeros que se van a bloquear a la banca.     
     * @param betLimits     
     * @throws SaveBetBankingInfoException
     */    
    public void saveBlockingNumbers(List<BlockingNumberBetBanking> blockNumbers) throws SaveBlockingNumberException,DeleteBetBankingBetLimitException,FindBetLimitException,FindBlockingNumberException;
    
    /**
     * *
     * Elimina todas los numeros bloqueados en una banca.
     * @param betBankingId     
     * @throws DeleteBetBankingBetLimitException,FindBlockingNumberException
     */ 
    public void deleteBlockinNumberByBetBankingId(int betBankingId) throws DeleteBetBankingBetLimitException, FindBetLimitException, FindBlockingNumberException;
    
}
