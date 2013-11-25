package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.containers.BetBankingContainer;
import com.exception.magicsnumbersws.dao.BetBankingBetLimitDao;
import com.exception.magicsnumbersws.dao.BetBankingDao;
import com.exception.magicsnumbersws.dao.BetDao;
import com.exception.magicsnumbersws.dao.BlockingNumberBetBankingDao;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.exception.DeleteBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.SaveBetBankingInfoException;
import com.exception.magicsnumbersws.exception.SaveBlockingNumberException;
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
    private static final Logger LOG = Logger.getLogger(BetBankingServiceImpl.class.getName());
    @Autowired
    private BetBankingDao betBankingDao;
    @Autowired
    private BetBankingBetLimitDao betBankingBetLimitDao;
    @Autowired
    private BetDao betDao;
    @Autowired
    private BlockingNumberBetBankingDao blockingNumberBetBankingDao;    

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
                //BetBanking banking = betBankingDao.findById(betBanking.getId());
               //BeanUtils.copyProperties(betBanking, banking,new String[]{"lotteries"});                
                betBankingDao.update(betBanking);
            }
        }
        LOG.info("finish - BetBankingServiceImpl.saveBetBankingInformation");
    }

    @Override    
    public void saveBetBankingBetLimits(List<BetBankingBetLimit> betLimits) throws SaveBetBankingBetLimitException, FindBetLimitException, DeleteBetBankingBetLimitException {
        LOG.info("init - BetBankingServiceImpl.saveBetBankingBetLimits");
        //Se eliminan todas las jugadas asociadas a la banca.
        BetBanking betBanking = betLimits.get(0).getBetBanking();
        deleteBetLimitsByBetBankingId(betBanking.getId());
        //Se insertan las jugadas enviadas como parametro.
        if (betLimits.get(0).getBet() != null) {
            for (BetBankingBetLimit currBetLimit : betLimits) {
                currBetLimit.setCreationDate(new Date());
                currBetLimit.setBetBanking(betBanking);                
                betBankingBetLimitDao.add(currBetLimit);
            }
        }
        LOG.info("finish - BetBankingServiceImpl.saveBetBankingBetLimits");
    }

    @Override
    public void deleteBetLimitsByBetBankingId(int betBankingId) throws DeleteBetBankingBetLimitException, FindBetLimitException {
        betBankingBetLimitDao.deleteByBetBanking(betBankingId);
    }

    @Override
    //@Transactional
    public void saveBlockingNumbers(List<BlockingNumberBetBanking> blockNumbers) throws SaveBlockingNumberException, DeleteBetBankingBetLimitException, FindBetLimitException, FindBlockingNumberException {
        LOG.info("init - BetBankingServiceImpl.saveBlockingNumbers");
        //Se eliminan todos los numeros bloqueados de la banca.
        BetBanking betBanking = blockNumbers.get(0).getBetBanking();
        deleteBlockinNumberByBetBankingId(betBanking.getId());

        //Se insertan los numeros a bloquear enviados como parametro.
        if (blockNumbers.get(0).getCreationUser() != null) {
            for (BlockingNumberBetBanking currBlockingNumber : blockNumbers) {
                currBlockingNumber.setBetBanking(betBanking);
                blockingNumberBetBankingDao.add(currBlockingNumber);
            }
        }
        LOG.info("finish - BetBankingServiceImpl.saveBlockingNumbers");
    }

    @Override
    public void deleteBlockinNumberByBetBankingId(int betBankingId) throws DeleteBetBankingBetLimitException, FindBetLimitException, FindBlockingNumberException {
        LOG.info("init - BetBankingServiceImpl.deleteBlockinNumberByBetBankingId");
        blockingNumberBetBankingDao.deleteByBetBanking(betBankingId);
        LOG.info("finish - BetBankingServiceImpl.deleteBlockinNumberByBetBankingId");
    }

    @Override
    public void saveBetBankingInformation(BetBankingContainer betBankingContainer) throws FindBlockingNumberException, SaveBlockingNumberException, SaveBetBankingInfoException, FindBetLimitException, DeleteBetBankingBetLimitException, SaveBetBankingBetLimitException {
        BetBanking betBanking = betBankingContainer.getBetBanking();
        if (betBankingContainer.getBetBankingBetLimits() != null) {
            for (BetBankingBetLimit currBetLimit : betBankingContainer.getBetBankingBetLimits()) {
                Lottery lottery = currBetLimit.getLottery();
                boolean lotteryNotExistInList = !betBanking.getLotteries().contains(lottery);
                if (lotteryNotExistInList) {
                    betBanking.getLotteries().add(lottery);
                }
            }
        }

        saveBetBankingInformation(betBanking);
        if (betBankingContainer.getBetBankingBetLimits() != null && betBankingContainer.getBetBankingBetLimits().size() > 0) {
            betBankingContainer.getBetBankingBetLimits().get(0).setBetBanking(betBankingContainer.getBetBanking());
            saveBetBankingBetLimits(betBankingContainer.getBetBankingBetLimits());
        } else {//Se eliminan todas las jugadas y limites de la banca.
            deleteBetLimitsByBetBankingId(betBankingContainer.getBetBanking().getId());
        }

        if (betBankingContainer.getBlockingNumbers() != null && betBankingContainer.getBlockingNumbers().size() > 0) {
            betBankingContainer.getBlockingNumbers().get(0).setBetBanking(betBankingContainer.getBetBanking());
            saveBlockingNumbers(betBankingContainer.getBlockingNumbers());
        } else {//Se eliminan todos los numeros bloqueados en la banca.
            deleteBlockinNumberByBetBankingId(betBankingContainer.getBetBanking().getId());            
        }
    }

    @Transactional
    @Override
    public List<Bet> findBetsByLotteryAndBetBanking(int lotteryId, int betBankingId) throws FindBetException {
       return betBankingDao.findBetsByLotteryAndBetBanking(lotteryId, betBankingId);
    }
}
