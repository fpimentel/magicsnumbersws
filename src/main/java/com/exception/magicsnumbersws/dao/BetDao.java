package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.exception.FindBetException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 18-sept-2013
 */
public interface BetDao {

    public void add(Bet bet);

    public void update(Bet bet);

    public void delete(int betId);

    //@Transactional(propagation = Propagation.SUPPORTS)
    public Bet findById(int id);

    public List<Bet> findActiveBets() throws FindBetException;
}
