package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.containers.BetBankingContainer;
import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.exception.DeleteBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.FindBetException;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveBetBankingBetLimitException;
import com.exception.magicsnumbersws.exception.SaveBetBankingInfoException;
import com.exception.magicsnumbersws.exception.SaveBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
@Component
@Path("lookuptables")
public interface LookupTablesEndpoint {

    @GET
    @Path(value = "/status")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<Status> getAllStatus();

    @GET
    @Path(value = "/category")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<Category> getAllCategories();

    @GET
    @Path("/consortium/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consortium> findConsortiumByUserId(@PathParam("userId") int userId) throws SearchAllConsortiumException;

    @GET
    @Path("/consortium/active")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consortium> findActiveConsortium() throws SearchAllConsortiumException;

    @GET
    @Path("/betBanking")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findAvailableBetBankings() throws SearchAllBetBankingException;

    @GET
    @Path("/betBanking/{consortiumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findBetBankingAsignedToConsortium(@PathParam("consortiumId") int consortiumId) throws SearchAllBetBankingException;

    @GET
    @Path("/betBankingAll/{consortiumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findAllBetBanking(@PathParam("consortiumId") int consortiumId) throws SearchAllBetBankingException;

    @GET
    @Path("/betBankingAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findAllBetBanking() throws SearchAllBetBankingException;

    @GET
    @Path("/betBankingById/{betBankingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BetBanking findBetBankingById(@PathParam("betBankingId") int betBankingId) throws SearchAllBetBankingException;

    /**
     * Encargado de devolver las bancas asignadas al
     * usuario(BET_BANKINGS_USERS).
     *
     * @param userId
     * @return List<BetBanking>
     * @throws SearchAllBetBankingException
     */
    @GET
    @Path("/betBankingByUserId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findBetBankingByUserId(@PathParam("userId") int userId) throws SearchAllBetBankingException;

    /**
     * Encargado de devolver las bancas asignadas a los consorcios del usuario.
     *
     * @param userId
     * @return List<BetBanking>
     * @throws SearchAllBetBankingException
     */
    @GET
    @Path("/betBankingToConsortiumsAssignedUser/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findBetBankingsToConsortiumsAssignedToUser(@PathParam("userId") int userId) throws SearchAllBetBankingException;

    /**
     * Encargado de buscar las jugadas activa.
     *
     * @return List<Bet>
     * @throws FindBetException
     */
    @GET
    @Path("/bet/active/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bet> findActiveBets() throws FindBetException;

    /**
     * *
     * Obtiene las jugadas con sus limites
     *
     * @param betBankingId
     * @return List<BetBankingBetLimit>
     * @throws FindBetLimitException
     */
    @GET
    @Path("/betBanking/betLimitsByBetBankingId/{betBankingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBankingBetLimit> findBetLimitsByBetBankingId(@PathParam("betBankingId") int betBankingId) throws FindBetLimitException;

    @POST
    @Path(value = "/consortium/saveAll")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveConsortiumsData(List<Consortium> consortium) throws SaveConsortiumDataException;

    @POST
    @Path(value = "/consortium/saveData")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveConsortiumData(Consortium consortium) throws SaveConsortiumDataException;

    
    @GET
    @Path("/betBanking/blockingNumbers/{betBankingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BlockingNumberBetBanking> findBlokingNumbersByBetBankingId(@PathParam("betBankingId") int betBankingId) throws FindBlockingNumberException;   
    
    @POST
    @Path(value = "/betBanking/saveData")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void saveBetBankingInformation(BetBanking betBanking) throws SaveBetBankingInfoException;
    
    @POST
    @Path(value = "/betBanking/saveBetLimitInf")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void saveBetBankingBetLimitInformation(List<BetBankingBetLimit> betLimits) throws SaveBetBankingBetLimitException, FindBetLimitException, DeleteBetBankingBetLimitException;
    
    @POST
    @Path(value = "/betBanking/saveBlockingNumbers")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void saveBlockingNumberInformation(List<BlockingNumberBetBanking> blockingNumbers) throws SaveBlockingNumberException,DeleteBetBankingBetLimitException,FindBetLimitException,FindBlockingNumberException;
    
    @POST
    @Path(value = "/betBanking/saveBetBankingContainer")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void saveBetBankingInformation(BetBankingContainer betBankingContainer) throws FindBlockingNumberException, SaveBlockingNumberException, SaveBetBankingInfoException, FindBetLimitException, DeleteBetBankingBetLimitException, SaveBetBankingBetLimitException;
}
