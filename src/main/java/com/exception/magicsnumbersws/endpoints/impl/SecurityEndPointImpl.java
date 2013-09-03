package com.exception.magicsnumbersws.endpoints.impl;

import com.exception.magicsnumbersws.endpoints.SecurityEndPoint;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import com.exception.magicsnumbersws.service.ConsortiumService;
import com.exception.magicsnumbersws.service.ProfileService;
import com.exception.magicsnumbersws.service.SystemOptionService;
import com.exception.magicsnumbersws.service.UserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 06-august-13
 * @version 0.1
 */
@Component
@Path("security")
public class SecurityEndPointImpl implements SecurityEndPoint {

    @Autowired
    private UserService userService;
    @Autowired
    private SystemOptionService systemOptionService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ConsortiumService consortiumService;
    
    private Logger logger = Logger.getLogger(SecurityEndPointImpl.class.getName());

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<User> getAllUsers() throws SearchAllUserException {
        logger.log(Level.INFO, "init- getAllUsers");
        return userService.findAll();
    }
    @Override
    public User getUserByCredential(@PathParam("userName") String userName, @PathParam("userName") String pass) {
        return userService.getUserByCredentials(userName, pass);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
   

    @GET
    @Path(value = "/systemoption")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Override
    public List<SystemOption> getAllSystemOptions() throws SearchAllSystemOptionException {
        return systemOptionService.findAll();
    }
    
    @GET
    @Path(value = "/profile")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Override
    public List<Profile> getAllProfiles() throws SearchAllProfileException {
        return profileService.findAll();
    }
    
    @POST
    @Path(value = "/user/save")
    @Consumes("application/json")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Override
    public void saveUsersData(List<User> users) throws SaveUsersDataException {
        userService.saveUsersData(users);
    }

    @Override
    public void saveSystemOptionsData(List<SystemOption> systemOptions) throws SaveSystemOptionsDataException {
        systemOptionService.saveSystemOptionsData(systemOptions);
    }

    @Override
    public List<Consortium> findConsortiumByUserId(int userId) throws SearchAllConsortiumException{
        return consortiumService.findByUserId(userId);
    }
}
