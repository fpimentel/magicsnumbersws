package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BetBankingDao {

    public void add(BetBanking betBanking);
    
    public void update(BetBanking betBanking);

    public void delete(int betBankingId);

    //@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BetBankingBetLimit> findBetLimitsByBetBankingId(int betBankingId) throws FindBetLimitException;
        
    public BetBanking findById(int id);

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BetBanking> findAvailable() throws SearchAllBetBankingException;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BetBanking> findByUserId(int userId) throws SearchAllBetBankingException;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BetBanking> findAll(int consortiumId) throws SearchAllBetBankingException;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<BetBanking> findAll() throws SearchAllBetBankingException;

    /**
     * *
     * Metodo encargado de devolver las bancas asignadas a los consorcios del
     * usuario.
     *
     * @param userId
     * @return List<BetBanking>
     * @throws SearchAllBetBankingException
     */
    public List<BetBanking> findBetBankingsToConsortiumsAssignedToUser(int userId) throws SearchAllBetBankingException;
    
    
    public void deleteAssigned(int consortiumIdToDelete);

    public void assingConsortium(Consortium cons);
    
    /**
     * *
     * Obtiene los numeros bloqueados de una banca.
     *
     * @param betBankingId
     * @return List<BlockingNumberBetBanking>
     * @throws FindBlockingNumberException
     */
    public List<BlockingNumberBetBanking> findBlokingNumbersByBetBankingId(int betBankingId) throws FindBlockingNumberException;
    
    public List<Bet> findBetsByLotteryAndBetBanking(int lotteryId, int betBankingId) throws FindBetException;
    
    public Consortium findConsortiumByBetBankingId(int betBankingId);    
    public BetBanking findBetBankingWithLottery(int id);
}
