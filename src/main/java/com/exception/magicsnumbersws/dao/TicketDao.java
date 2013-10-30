package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.SaveTicketException;

/**
 *
 * @author fpimentel
 * @since 29-oct-2013
 */
public interface TicketDao {
    public void add(Ticket ticket) throws SaveTicketException;
    public void update(Ticket ticket);
    public void delete(int ticket);       
}
