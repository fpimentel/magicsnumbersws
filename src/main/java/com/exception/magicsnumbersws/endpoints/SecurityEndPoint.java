package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
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
    List<SystemOption> getAllSystemOptions() throws SearchAllSystemOptionException;

    @GET
    @Path(value = "/profile")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<Profile> getAllProfiles() throws SearchAllProfileException;

    @GET
    @Path("/user/{userName}/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
    User getUserByCredential(@PathParam("userName") String userName, @PathParam("pass") String pass);

    @POST
    @Path(value = "/user/save")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveUsersData(List<User> users) throws SaveUsersDataException;

    @POST
    @Path(value = "/user/saveUser")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void saveUser(User user) throws SaveUsersDataException;
    
    @POST
    @Path(value = "/systemoption/save")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    void saveSystemOptionsData(List<SystemOption> systemOptions) throws SaveSystemOptionsDataException;

    @GET
    @Path("/findUsersByConsortiumIds/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findUsersByConsortiumIds(@PathParam("userId") int userId) throws SearchAllUserException;
    
    
    @GET
    @Path("/findUserByUserName/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public User findUserByUserName(@PathParam("userName") String userName) throws SearchAllUserException;
    
    @POST
    @Path("/updateUserPassword/{idUser}/{newPassword}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUserPassword(@PathParam("idUser") int idUser,@PathParam("newPassword") String newPassword) throws SaveUsersDataException;
}
