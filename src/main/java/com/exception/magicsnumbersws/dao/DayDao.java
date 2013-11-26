package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Day;
import com.exception.magicsnumbersws.exception.FindDayException;
import java.util.List;

/**
 *
 * @author fpimentel
 */
public interface DayDao {
    public List<Day> findAll()throws FindDayException;      
}