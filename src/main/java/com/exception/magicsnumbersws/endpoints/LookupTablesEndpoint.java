package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.Status;
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
    public List<Consortium> findConsortiumByUserId(@PathParam("userId")  int userId) throws SearchAllConsortiumException;
    
    @GET
    @Path("/betBanking")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findAvailableBetBankings() throws SearchAllBetBankingException;
    
    @GET
    @Path("/betBanking/{consortiumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findBetBankingAsignedToConsortium(@PathParam("consortiumId") int consortiumId) throws SearchAllBetBankingException;  
    
    @GET
    @Path("/betBanking")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BetBanking> findAllBetBanking() throws SearchAllBetBankingException;  
    
    @POST
    @Path(value = "/consortium/save")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveConsortiumsData(List<Consortium> consortium) throws SaveConsortiumDataException;   
}
