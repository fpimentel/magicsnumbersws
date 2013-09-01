package com.exception.magicsnumbersws.endpoints.impl;

import com.exception.magicsnumbersws.endpoints.LookupTablesEndpoint;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.service.CategoryService;
import com.exception.magicsnumbersws.service.StatusService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author fpimentel
 * @since 26-august-13
 * @version 0.1
 */
@Component
@Path("lookuptables")
public class LookupTablesEndpointImpl implements LookupTablesEndpoint {
  
  @Autowired  
  private StatusService statusService;
  @Autowired
  private CategoryService categoryService;
    
  private Logger logger = Logger.getLogger(LookupTablesEndpointImpl.class.getName());

  @GET
  @Path(value = "/status")
  @Produces(value = MediaType.APPLICATION_JSON)    
  @Override
  public List<Status> getAllStatus() {
      logger.log(Level.INFO, "init - getAllStatus()");
      return statusService.findAll();
  }

    @Override
    public List<Category> getAllCategories() {
        logger.log(Level.INFO, "init - getAllCategories()");
        return categoryService.findAll();
    }
}
