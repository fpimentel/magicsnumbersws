package com.exception.magicsnumbersws.endpoints.security;


import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.service.impl.UserServiceImpl;
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

/**
 *
 * @author fpimentel
 * @since 06-august-13
 * @version 0.1
 */

@Path("security")
public class SecurityEndPoint {
  
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
      return new ArrayList<User>(users.values());
  }
  
  @GET
  @Path("/getUsersJSON")
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> getUsersJSON(){
     // return new ArrayList<User>(users.values());
      UserServiceImpl user = new UserServiceImpl();
      return user.findAll();
  }  
}
