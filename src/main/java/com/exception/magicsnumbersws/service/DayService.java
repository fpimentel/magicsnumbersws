package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.Day;
import com.exception.magicsnumbersws.exception.FindDayException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 25-Sept-2013
 */
@Service
public interface DayService {              
    public List<Day> findAll() throws FindDayException;  
    public Day findById(int dayId)throws FindDayException;
}
