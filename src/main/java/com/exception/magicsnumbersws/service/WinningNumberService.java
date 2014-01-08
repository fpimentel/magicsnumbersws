package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.SaveWinningNumberDataException;
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

    public void saveWinningNumberInfo(WinningNumber winningNumber) throws SaveWinningNumberDataException;

    public void update(WinningNumber winningNumber);

    public void delete(int winningNumberId);

    public List<WinningNumber> findWinningNumber(String fromDate, String ToDate) throws SearchWinningNumbersException;
    public WinningNumber findWinningNumber(int lotteryId, int timeId,String drawingDate) throws SearchWinningNumbersException;
}
