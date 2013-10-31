package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.TicketDetail;
import com.exception.magicsnumbersws.exception.SaveTicketException;

/**
 *
 * @author fpimentel
 * @since 30-oct-2013
 */
public interface TicketDetailDao {
    public void add(TicketDetail ticketDetail) throws SaveTicketException;
    public void update(TicketDetail ticketDetail);
    public void delete(int ticketDetailId);       
}
