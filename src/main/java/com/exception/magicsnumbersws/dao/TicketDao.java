package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Ticket;

/**
 *
 * @author fpimentel
 * @since 29-oct-2013
 */
public interface TicketDao {
    public void add(Ticket ticket);
    public void update(Ticket ticket);
    public void delete(int ticket);       
}
