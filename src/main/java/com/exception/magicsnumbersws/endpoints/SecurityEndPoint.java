/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.endpoints;

import com.exception.magicsnumbersws.entities.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fpimentel
 */
public interface SecurityEndPoint {

    @GET
    @Path(value = "/user")
    @Produces(value = MediaType.APPLICATION_JSON)
    List<User> getAllUsers();
    
}
