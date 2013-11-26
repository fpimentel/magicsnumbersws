package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Day;
import com.exception.magicsnumbersws.exception.FindTimeException;
import java.util.List;

/**
 *
 * @author fpimentel
 */
public interface TimeDao {
    public List<Day> findAll()throws FindTimeException;      
}