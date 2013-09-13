package com.exception.magicsnumbersws.endpoints.impl;
import com.exception.magicsnumbersws.endpoints.SecurityEndPoint;
import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SaveUsersDataException;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import com.exception.magicsnumbersws.service.ProfileService;
import com.exception.magicsnumbersws.service.SystemOptionService;
import com.exception.magicsnumbersws.service.UserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
   
    
    private Logger logger = Logger.getLogger(SecurityEndPointImpl.class.getName());

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
   
    @Override
    public List<SystemOption> getAllSystemOptions() throws SearchAllSystemOptionException {
        return systemOptionService.findAll();
    }
    
    @Override
    public List<Profile> getAllProfiles() throws SearchAllProfileException {
        return profileService.findAll();
    }
    
    @Override
    public void saveUsersData(List<User> users) throws SaveUsersDataException {
        userService.saveUsersData(users);
    }

    @Override
    public void saveSystemOptionsData(List<SystemOption> systemOptions) throws SaveSystemOptionsDataException {
        systemOptionService.saveSystemOptionsData(systemOptions);
    }

}
