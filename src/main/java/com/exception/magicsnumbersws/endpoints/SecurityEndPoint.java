package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;
import java.util.Set;
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
 */
@Component
@Path("security")
public interface SecurityEndPoint {

    @GET
    @Path(value = "/user")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<User> getAllUsers() throws SearchAllUserException;

    @GET
    @Path(value = "/systemoption")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<SystemOption> getAllSystemOptions() throws SearchAllSystemOptionException ;

    @GET
    @Path(value = "/profile")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<Profile> getAllProfiles() throws SearchAllProfileException ;
    
    @POST
    @Path(value = "/user/save")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveUsersData(List<User> users) throws SaveUsersDataException;
        
    @GET
    @Path("/user/{userName}/{pass}")    
    @Produces(MediaType.APPLICATION_JSON)
    User getUserByCredential(@PathParam("userName") String userName, @PathParam("pass") String pass);
}
