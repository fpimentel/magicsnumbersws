package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 18-dic-2013
 */
@Component
@Path("report")
public interface ReportsEndpoint {    
    
    @GET 
    @Path("/consortium/{betBankingId}/{fromDate}/{toDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> findTicket(@PathParam("betBankingId") int betBankingId, @PathParam("fromDate") String fromDate, @PathParam("toDate") String toDate) throws FindTicketException;
}
