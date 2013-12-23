package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.SearchWinningNumbersException;
import java.util.List;

/**
 *
 * @author cpimentel
 * @since 19-dic-2013
 */
public interface WinningNumberDao {

    public void add(WinningNumber winningNumber);
    
    public void update(WinningNumber winningNumber);

    public void delete(int winningNumberId);
    public List<WinningNumber> findWinningNumber(String fromDate,String ToDate) throws SearchWinningNumbersException;
}
