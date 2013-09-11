package com.exception.magicsnumbersws.endpoints.impl;

import com.exception.magicsnumbersws.endpoints.LookupTablesEndpoint;
import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.Status;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllBetBankingException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import com.exception.magicsnumbersws.service.BetBankingService;
import com.exception.magicsnumbersws.service.CategoryService;
import com.exception.magicsnumbersws.service.ConsortiumService;
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
    @Autowired
    private ConsortiumService consortiumService;
    @Autowired
    private BetBankingService betBankingService;
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

    @Override
    public List<Consortium> findConsortiumByUserId(int userId) throws SearchAllConsortiumException {
        return consortiumService.findByUserId(userId);
    }

    @Override
    public void saveConsortiumsData(List<Consortium> consortium) throws SaveConsortiumDataException {
        consortiumService.saveConsortiumsData(consortium);
    }

    @Override
    public List<BetBanking> findAvailableBetBankings() throws SearchAllBetBankingException {
        return betBankingService.findAvailable();
    }

    //Se encarga de buscar las bancas asignadas a un consorcio
    @Override
    public List<BetBanking> findBetBankingAsignedToConsortium(int consortiumId) throws SearchAllBetBankingException {
        return betBankingService.findAsigned(consortiumId);
    }

    @Override
    public List<BetBanking> findAllBetBanking(int consortiumId) throws SearchAllBetBankingException {
        return betBankingService.findAll(consortiumId);
    }

    @Override
    public void saveConsortiumData(Consortium consortium) throws SaveConsortiumDataException {
        try {
            consortiumService.saveConsortiumData(consortium);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "saveConsortium()".concat(ex.getMessage()));
            throw new SaveConsortiumDataException(ex.getMessage(), ex);
        }
    }

    @Override
    public BetBanking findBetBankingById(int betBankingId) throws SearchAllBetBankingException {
        return betBankingService.findById(betBankingId);
    }

    @Override
    public List<BetBanking> findAllBetBanking() throws SearchAllBetBankingException {
        return betBankingService.findAll();
    }
}
