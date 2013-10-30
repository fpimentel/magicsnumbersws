package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

    @GET
    @Path(value = "/saveTicket")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveTicket(Ticket ticket) throws SaveTicketException;
}
