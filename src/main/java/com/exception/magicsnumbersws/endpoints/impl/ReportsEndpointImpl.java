package com.exception.magicsnumbersws.endpoints.impl;

import com.exception.magicsnumbersws.endpoints.ReportsEndpoint;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.service.TicketService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fpimentel
 * @since 18-dic-2013
 */
@Component
public class ReportsEndpointImpl implements ReportsEndpoint{  
    private static final Logger logger = Logger.getLogger(ReportsEndpointImpl.class.getName());    
    @Autowired
    private TicketService ticketService;
    
    public List<Ticket> findTicket(int betBankingId, String fromDate, String toDate) throws FindTicketException{  
        return ticketService.findTicket(betBankingId, fromDate, toDate);               
    }
}
