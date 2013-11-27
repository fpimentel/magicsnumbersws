package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.FindTimeException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 25-Sept-2013
 */
@Service
public interface TimeService {              
    public List<Time> findAll() throws FindTimeException;  
    public Time findById(int timeId) throws FindTimeException;
}
