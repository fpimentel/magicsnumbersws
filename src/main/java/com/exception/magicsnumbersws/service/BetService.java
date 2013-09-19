package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.Bet;
import com.exception.magicsnumbersws.exception.FindBetException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 18-Septiembre-2013
 */
@Service
public interface BetService {

    public void add(Bet bet);

    public void update(Bet bet);

    public void delete(int betId);

    @Transactional(readOnly = true)
    public Bet findById(int id);

    @Transactional(readOnly = true)
    public List<Bet> findActiveBets() throws FindBetException;
}
