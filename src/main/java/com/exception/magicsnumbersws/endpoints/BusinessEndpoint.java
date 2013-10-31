package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
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
}
