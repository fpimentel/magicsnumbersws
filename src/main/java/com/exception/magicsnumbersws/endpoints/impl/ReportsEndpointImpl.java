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
        //String fDate = new SimpleDateFormat("dd/MM/yyyy").format(fromDate);
        //String tDate = new SimpleDateFormat("dd/MM/yyyy").format(toDate);
        //try {
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            //Date fDate = formatter.parse(fromDate);
            //Date tDate = formatter.parse(toDate);
            return ticketService.findTicket(betBankingId, fromDate, toDate);
       // } catch (ParseException ex) {
         //   Logger.getLogger(ReportsEndpointImpl.class.getName()).log(Level.SEVERE, null, ex);
           // throw new FindTicketException();
        //}
    }
}
