package com.exception.magicsnumbersws.endpoints.security;


import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.entities.User2;
import com.exception.magicsnumbersws.service.UserService;
import com.exception.magicsnumbersws.service.impl.UserServiceImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 06-august-13
 * @version 0.1
 */


@Component
@Path("security")
public class SecurityEndPoint {
  
  @Autowired  
  private UserService userService;  
    
  private static Map<Integer,User> users = new HashMap<Integer,User>();  
  private Logger logger = Logger.getLogger(SecurityEndPoint.class.getName());
  
  static{
      for( int i = 0 ; i < 20 ; i++){
          User user = new User();
          user.setId(i +1 );
          user.setFirtName("Fausto No. " + (i+1));
          users.put(i+1, user);
      }
  }
  
  @GET
  @Path("/getUserByIdXML/{id}")
  @Produces(MediaType.APPLICATION_XML)
  public User getUserByIdXML(@PathParam("id") int id){
      return users.get(id);
  }
  
  @GET
  @Path("/getUserByIdJSON/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUserByIdJSON(@PathParam("id") int id){
      return users.get(id);
  }
  
  @GET
  @Path("/getAllUsersXML")
  @Produces(MediaType.APPLICATION_XML)
  public List<User> getAllUsersXML(){
      return userService.findAll();
  }
  
  @GET
  @Path("/getUsersJSON")
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> getUsersJSON() {            
      return userService.findAll();
  }  

  @GET
  @Path("/test")
  @Produces(MediaType.APPLICATION_JSON)
  public User2 getTestJSON() {            
      User2 user= new User2();
      user.setFirtName("Fausto");
      return user;
  }
  
  public UserService getUserService() {
      return userService;
  }
    
  public void setUserService(UserService userService) {
      this.userService = userService;
  }
}
