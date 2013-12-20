package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.containers.TicketReportContainer;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Path(value = "/findTickets")
    @Produces(value = MediaType.APPLICATION_JSON) 
    @Consumes("application/json")
    public List<Ticket> findTicket(TicketReportContainer ticketReportContainer) throws FindTicketException;
}
