package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.FindTimeException;
import java.util.List;

/**
 *
 * @author fpimentel
 */
public interface TimeDao {
    public List<Time> findAll() throws FindTimeException;
    public Time findById(int timeId) throws FindTimeException;
}