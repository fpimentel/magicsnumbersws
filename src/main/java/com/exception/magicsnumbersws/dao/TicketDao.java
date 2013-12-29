package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Ticket;
import com.exception.magicsnumbersws.exception.FindTicketException;
import com.exception.magicsnumbersws.exception.SaveTicketException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 29-oct-2013
 */
public interface TicketDao {
    public void add(Ticket ticket) throws SaveTicketException;
    public void update(Ticket ticket);
    public void delete(int ticket);       
    public List<Ticket> findTicket(int betBankingId, String fromDate, String toDate) throws FindTicketException;
    public List<Ticket> findTodayTicketByUserName(String userName) throws FindTicketException;
}
