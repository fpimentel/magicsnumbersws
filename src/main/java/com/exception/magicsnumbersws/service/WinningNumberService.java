package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.SearchWinningNumbersException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Service
public interface WinningNumberService {

 public void add(WinningNumber winningNumber);
    
    public void update(WinningNumber winningNumber);

    public void delete(int winningNumberId);
    public List<WinningNumber> findWinningNumber(String fromDate,String ToDate) throws SearchWinningNumbersException;  
}
