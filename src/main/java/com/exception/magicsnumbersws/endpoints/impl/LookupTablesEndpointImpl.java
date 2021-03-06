package com.exception.magicsnumbersws.endpoints.impl;

import com.exception.magicsnumbersws.containers.BetBankingContainer;
import com.exception.magicsnumbersws.containers.ConsortiumContainer;
import com.exception.magicsnumbersws.containers.LotteryContainer;
import com.exception.magicsnumbersws.endpoints.LookupTablesEndpoint;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import com.exception.magicsnumbersws.entities.Day;
import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.CloseHourLotteryConfigNotFoundtException;
import com.exception.magicsnumbersws.exception.DeleteBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.FindConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.exception.FindDayException;
import com.exception.magicsnumbersws.exception.FindLotteryCloseHourException;
import com.exception.magicsnumbersws.exception.FindLotteryException;
import com.exception.magicsnumbersws.exception.FindTimeException;
import com.exception.magicsnumbersws.exception.SaveBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.SaveBetBankingInfoException;
import com.exception.magicsnumbersws.exception.SaveBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SaveLotteryException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import com.exception.magicsnumbersws.service.BetBankingService;
import com.exception.magicsnumbersws.service.BetService;
import com.exception.magicsnumbersws.service.CategoryService;
import com.exception.magicsnumbersws.service.ConsortiumGeneralLimitService;
import com.exception.magicsnumbersws.service.ConsortiumService;
import com.exception.magicsnumbersws.service.DayService;
import com.exception.magicsnumbersws.service.LotteryCloseHourService;
import com.exception.magicsnumbersws.service.LotteryService;
import com.exception.magicsnumbersws.service.StatusService;
import com.exception.magicsnumbersws.service.TimeService;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 26-august-13
 * @version 0.1
 */
@Component
@Path("lookuptables")
public class LookupTablesEndpointImpl implements LookupTablesEndpoint {

    private Logger logger = Logger.getLogger(LookupTablesEndpointImpl.class.getName());
    @Autowired
    private StatusService statusService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ConsortiumService consortiumService;
    @Autowired
    private BetBankingService betBankingService;
    @Autowired
    private BetService betService;
    @Autowired
    private LotteryService lotteryService;
    @Autowired
    private LotteryCloseHourService lotteryCloseHourService;
    @Autowired
    private DayService dayService;
    @Autowired
    private TimeService timeService;   
    @Autowired
    private ConsortiumGeneralLimitService consortiumGeneralLimitService;
    
    @Override
    public List<Status> getAllStatus() {
        logger.log(Level.INFO, "init - getAllStatus()");
        return statusService.findAll();
    }

    @Override
    public List<Category> getAllCategories() {
        logger.log(Level.INFO, "init - getAllCategories()");
        return categoryService.findAll();
    }

    @Override
    public List<Consortium> findConsortiumByUserId(int userId) throws SearchAllConsortiumException {
        return consortiumService.findByUserId(userId);
    }

    @Override
    public void saveConsortiumsData(List<Consortium> consortium) throws SaveConsortiumDataException {
        consortiumService.saveConsortiumsData(consortium);
    }

    @Override
    public List<BetBanking> findAvailableBetBankings() throws SearchAllBetBankingException {
        return betBankingService.findAvailable();
    }

    //Se encarga de buscar las bancas asignadas a un consorcio
    @Override
    public List<BetBanking> findBetBankingAsignedToConsortium(int consortiumId) throws SearchAllBetBankingException {
        return betBankingService.findAsigned(consortiumId);
    }

    @Override
    public List<BetBanking> findAllBetBanking(int consortiumId) throws SearchAllBetBankingException {
        return betBankingService.findAll(consortiumId);
    }

    @Override
    public void saveConsortiumData(ConsortiumContainer consortiumContainer) throws SaveConsortiumDataException {
        try {
            consortiumService.saveConsortiumData(consortiumContainer);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "saveConsortium()".concat(ex.getMessage()));
            throw new SaveConsortiumDataException(ex.getMessage(), ex);
        }
    }

    @Override
    public BetBanking findBetBankingById(int betBankingId) throws SearchAllBetBankingException {
        return betBankingService.findById(betBankingId);
    }

    @Override
    public List<BetBanking> findAllBetBanking() throws SearchAllBetBankingException {
        return betBankingService.findAll();
    }

    @Override
    public List<Consortium> findActiveConsortium() throws SearchAllConsortiumException {
        return consortiumService.findActiveConsortium();
    }

    @Override
    public List<BetBanking> findBetBankingByUserId(int userId) throws SearchAllBetBankingException {
        return betBankingService.findByUserId(userId);
    }

    @Override
    public List<BetBanking> findBetBankingsToConsortiumsAssignedToUser(int userId) throws SearchAllBetBankingException {
        logger.info("init - LookupTablesEndpointImpl.findBetBankingsToConsortiumsAssignedToUser(" + userId);
        return betBankingService.findBetBankingsToConsortiumsAssignedToUser(userId);
    }

    @Override
    public List<Bet> findActiveBets() throws FindBetException {
        logger.info("init - LookupTablesEndpointImpl.findActiveBets");
        return betService.findActiveBets();
    }

    @Override
    public List<BetBankingBetLimit> findBetLimitsByBetBankingId(int betBankingId) throws FindBetLimitException {
        return betBankingService.findBetLimitsByBetBankingId(betBankingId);
    }

    @Override
    public List<BlockingNumberBetBanking> findBlokingNumbersByBetBankingId(int betBankingId) throws FindBlockingNumberException {
        return betBankingService.findBlokingNumbersByBetBankingId(betBankingId);
    }

    @Override
    public void saveBetBankingInformation(BetBanking betBanking) throws SaveBetBankingInfoException {
        betBankingService.saveBetBankingInformation(betBanking);
    }

    @Override
    public void saveBetBankingBetLimitInformation(List<BetBankingBetLimit> betLimits) throws SaveBetBankingBetLimitException, FindBetLimitException, DeleteBetBankingBetLimitException {
        betBankingService.saveBetBankingBetLimits(betLimits);
    }

    @Override
    public void saveBlockingNumberInformation(List<BlockingNumberBetBanking> blockingNumbers) throws SaveBlockingNumberException, DeleteBetBankingBetLimitException, FindBetLimitException, FindBlockingNumberException {
        betBankingService.saveBlockingNumbers(blockingNumbers);

    }

    @Override
    public void saveBetBankingInformation(BetBankingContainer betBankingContainer) throws FindBlockingNumberException, SaveBlockingNumberException, SaveBetBankingInfoException, FindBetLimitException, DeleteBetBankingBetLimitException, SaveBetBankingBetLimitException {
        betBankingService.saveBetBankingInformation(betBankingContainer);
    }

    @Override
    public List<Lottery> findActiveLottery() throws FindLotteryException {
        logger.entering("LookupTablesEndpointImpl", "findActiveLottery");
        return this.lotteryService.findActiveLottery();
    }

    @Override
    public Lottery findLotteryById(int lotteryId) throws FindLotteryException {
        logger.entering("LookupTablesEndpointImpl", "findLotteryById");
        return this.lotteryService.findById(lotteryId);
    }

    @Override
    public List<Bet> findBetsByLotteryId(int lotteryId) throws FindLotteryException {
        logger.entering("LookupTablesEndpointImpl", "findBetsByLotteryId");
        return this.lotteryService.findBetsByLotteryId(lotteryId);
    }

    @Override
    public List<Time> findAvailableTimesByLotteryId(int lotteryId) throws FindLotteryCloseHourException, CloseHourLotteryConfigNotFoundtException {
        logger.entering("LookupTablesEndpointImpl", "findAvailableTimesByLotteryId");
        return this.lotteryCloseHourService.findAvailableTimesByLotteryId(lotteryId);
    }

    @Override
    public List<Bet> findBetsByLotteryAndBetBanking(int lotteryId, int betBankingId) throws FindBetException{
        logger.entering("LookupTablesEndpointImpl", "findBetsByLotteryAndBetBanking");
        return this.betBankingService.findBetsByLotteryAndBetBanking(lotteryId, betBankingId);
    }

    @Override
    public List<Lottery> findLotteries() throws FindLotteryException {
        logger.entering("LookupTablesEndpointImpl", "findLotteries");
        return this.lotteryService.findLotteries();
    }

    @Override
    public List<LotteryCloseHour> findAvailableCloseHour(int lotteryId) throws FindLotteryCloseHourException {
        logger.entering("LookupTablesEndpointImpl", "findAvailableCloseHour(" + lotteryId + ")");
        return this.lotteryCloseHourService.findAvailableCloseHour(lotteryId);
    }

    @Override
    public List<Day> findAllDays() throws FindDayException {
        logger.entering("LookupTablesEndpointImpl", "findAvailableCloseHour");
        return dayService.findAll();
    }

    @Override
    public List<Time> findAllTimes() throws FindTimeException {
        logger.entering("LookupTablesEndpointImpl", "findAllTimes");
        return timeService.findAll();
    }

    @Override
    public void saveLotteryInf(LotteryContainer lotteryContainer) throws SaveLotteryException {
        logger.entering("LookupTablesEndpointImpl", "saveLotteryInf");
        lotteryService.saveLotteryInfo(lotteryContainer);
    }

    @Override
    public Day findDayById(int dayId) throws FindDayException {
        logger.entering("LookupTablesEndpointImpl", "findDayById");
        return dayService.findById(dayId);
    }

    @Override
    public Time findTimeById(int timeId) throws FindTimeException {
        logger.entering("LookupTablesEndpointImpl", "findTimeById");
        return timeService.findById(timeId);
    }

    @Override
    public Set<Time> findTimesByLottery(int lotteryId) throws FindLotteryCloseHourException {
        logger.entering("LookupTablesEndpointImpl", "findTimeById");
        return lotteryCloseHourService.findTimesByLottery(lotteryId);
    }

    @Override
    public List<ConsortiumGeneralLimit> findConsortiumLimitByConsortiumId(int consortiumId) throws FindConsortiumGeneralLimitException {
        logger.entering("LookupTablesEndpointImpl", "findByConsortiumId");
        return consortiumGeneralLimitService.findByConsortiumId(consortiumId);
    }
}
