package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Consortium;
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

    public BetBanking findById(int id);

    public List<BetBanking> findAvailable() throws SearchAllBetBankingException;

    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
    public List<BetBanking> findByUserId(int userId) throws SearchAllBetBankingException;
    
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException;

    public List<BetBanking> findAll(int consortiumId) throws SearchAllBetBankingException;

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<BetBanking> findAll() throws SearchAllBetBankingException;

    public void deleteAssigned(int consortiumIdToDelete);

    public void assingConsortium(Consortium cons);
}
