package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.FindBetLimitException;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import com.exception.magicsnumbersws.exception.SaveWinningNumberDataException;
import com.exception.magicsnumbersws.exception.SearchWinningNumbersException;
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
 * @since 29-oct-2013
 */
@Component
@Path("business")
public interface BusinessEndpoint {

    @POST
    @Path(value = "/saveTicket")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveTicket(Ticket ticket) throws SaveTicketException;
    
    
    @GET
    @Path(value = "/isNumbersBlocks/{betBankingId}/{numbers}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public String isNumbersBlocks(@PathParam("betBankingId") int betBankingId, @PathParam("numbers") String numbers) throws FindBlockingNumberException;
    @GET
    @Path(value = "/findLimitAmount/{betBankingId}/{lotteryId}/{betId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public String findBetBankingBetLimitAmount(@PathParam("betBankingId") int betBankingId, @PathParam("lotteryId") int lotteryId,@PathParam("betId") int betId)  throws FindBetLimitException;
    
    @GET
    @Path(value = "/findWinningNumbers/{fromDate}/{ToDate}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<WinningNumber> findWinningNumbers(@PathParam("fromDate") String fromDate, @PathParam("ToDate") String ToDate)  throws SearchWinningNumbersException;
    
    @GET
    @Path(value = "/findTodayTicketByUserName/{userName}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Ticket> findTodayTicketByUserName(@PathParam("userName") String userName)throws FindTicketException;
        
    @POST
    @Path(value = "/saveWinningNumberInfo")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void saveWinningNumberInfo(WinningNumber winningNumber) throws SaveWinningNumberDataException;
    
    @GET
    @Path(value = "/findWinningNumbers/{lotteryId}/{timeId}/{drawingDate}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public WinningNumber findWinningNumbers(@PathParam("lotteryId") int lotteryId, @PathParam("timeId") int timeId, @PathParam("drawingDate") String drawingDate)  throws SearchWinningNumbersException;
}
