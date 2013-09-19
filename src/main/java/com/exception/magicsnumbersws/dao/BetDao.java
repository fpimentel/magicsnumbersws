package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.exception.FindBetException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 18-sept-2013
 */
public interface BetDao {

    public void add(Bet bet);

    public void update(Bet bet);

    public void delete(int betId);

    public Bet findById(int id);

    public List<Bet> findActiveBets() throws FindBetException;
}
