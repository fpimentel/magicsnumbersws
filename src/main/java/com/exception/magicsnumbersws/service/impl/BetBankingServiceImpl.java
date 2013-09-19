package com.exception.magicsnumbersws.service.impl;
import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import com.exception.magicsnumbersws.service.BetBankingService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Service
@Transactional
public class BetBankingServiceImpl implements BetBankingService {

    @Autowired
    private BetBankingDao betBankingDao;
    private static final Logger LOG = Logger.getLogger(BetBankingServiceImpl.class.getName());
    

    public BetBankingServiceImpl() {
    }

    public BetBankingServiceImpl(BetBankingDao betBankingDao) {
        this.betBankingDao = betBankingDao;
    }

    public BetBankingDao getBetBankingDao() {
        return betBankingDao;
    }

    public void setBetBankingDao(BetBankingDao betBankingDao) {
        this.betBankingDao = betBankingDao;
    }

    @Override
    public void add(BetBanking betBanking) {
        betBankingDao.add(betBanking);
    }

    @Override
    public void update(BetBanking betBanking) {
        betBankingDao.update(betBanking);
    }

    @Override
    public BetBanking findById(int id) {
       return betBankingDao.findById(id);
    }

    @Override
    public List<BetBanking> findAvailable() throws SearchAllBetBankingException {
        return betBankingDao.findAvailable();
    }

    @Override
    public void delete(int betBankingId) {
        betBankingDao.delete(betBankingId);
    }

    @Override
    public List<BetBanking> findAsigned(int consortiumId) throws SearchAllBetBankingException {
        return betBankingDao.findAsigned(consortiumId);
    }

    @Override
    public List<BetBanking> findAll(int consortiumId) throws SearchAllBetBankingException {
        return betBankingDao.findAll(consortiumId);
    }

    @Override
    public List<BetBanking> findAll() throws SearchAllBetBankingException {
        return betBankingDao.findAll();
    }

    
    @Override
    public List<BetBanking> findByUserId(int userId) throws SearchAllBetBankingException {
        return betBankingDao.findByUserId(userId);
    }

    @Override
    public List<BetBanking> findBetBankingsToConsortiumsAssignedToUser(int userId) throws SearchAllBetBankingException {
        LOG.info("init - BetBankingServiceImpl.findBetBankingsToConsortiumsAssignedToUser("+userId);  
        return betBankingDao.findBetBankingsToConsortiumsAssignedToUser(userId);        
    }
}
