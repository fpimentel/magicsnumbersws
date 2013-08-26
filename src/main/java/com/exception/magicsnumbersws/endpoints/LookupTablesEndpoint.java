package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Status;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 */
@Component
@Path("lookuptables")
public interface LookupTablesEndpoint {

    @GET
    @Path(value = "/status")
    @Produces(value = MediaType.APPLICATION_JSON)            
    List<Status> getAllStatus();          
}
