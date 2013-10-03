package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.BetBankingBetLimitDao;
import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.dao.BetDao;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.exception.DeleteBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.SaveBetBankingInfoException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import com.exception.magicsnumbersws.service.BetBankingService;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private BetBankingBetLimitDao betBankingBetLimitDao;
    @Autowired
    private BetDao betDao;
    
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
        LOG.info("init - BetBankingServiceImpl.findBetBankingsToConsortiumsAssignedToUser(" + userId);
        return betBankingDao.findBetBankingsToConsortiumsAssignedToUser(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BetBankingBetLimit> findBetLimitsByBetBankingId(int betBankingId) throws FindBetLimitException {
        return betBankingDao.findBetLimitsByBetBankingId(betBankingId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BlockingNumberBetBanking> findBlokingNumbersByBetBankingId(int betBankingId) throws FindBlockingNumberException {
        LOG.info("init - BetBankingServiceImpl.findBlokingNumbersByBetBankingId(" + betBankingId);
        return betBankingDao.findBlokingNumbersByBetBankingId(betBankingId);
    }

    @Override
    public void saveBetBankingInformation(BetBanking betBanking) throws SaveBetBankingInfoException {
        LOG.info("init - BetBankingServiceImpl.saveBetBankingInformation");
        if (betBanking != null) {
            if (betBanking.getId() == null) {//Id null is for adding
                betBanking.setCreationDate(new Date());
                betBankingDao.add(betBanking);
            } else {// Id with value is for editing
                BetBanking banking = betBankingDao.findById(betBanking.getId());
                BeanUtils.copyProperties(betBanking, banking);
                betBankingDao.update(banking);
            }
        }
        LOG.info("finish - BetBankingServiceImpl.saveBetBankingInformation");
    }

    @Override
    public void saveBetBankingBetLimits(List<BetBankingBetLimit> betLimits) throws SaveBetBankingBetLimitException, FindBetLimitException, DeleteBetBankingBetLimitException {
        LOG.info("init - BetBankingServiceImpl.saveBetBankingBetLimits");
        //Se eliminan todas las jugadas asociadas a la banca.
        deleteBetLimitsByBetBankingId(betLimits.get(0).getBetBanking().getId());
        //Se insertan las jugadas enviadas como parametro.
        //for (BetBankingBetLimit currBetLimit : betLimits) {
          //  currBetLimit.setBet(betDao.findById(currBetLimit.getBet().getId()));
            //betBankingBetLimitDao.add(currBetLimit);
        //}
        LOG.info("finish - BetBankingServiceImpl.saveBetBankingBetLimits");
    }

    @Override
    public void deleteBetLimitsByBetBankingId(int betBankingId) throws DeleteBetBankingBetLimitException, FindBetLimitException {
        List<BetBankingBetLimit> betLimits = betBankingDao.findBetLimitsByBetBankingId(betBankingId);
        for (BetBankingBetLimit currBetLimit : betLimits) {
            betBankingBetLimitDao.delete(currBetLimit.getId());
        }
    }
}
