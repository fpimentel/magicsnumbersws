package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.Status;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 */
@Service
public interface StatusService {
        
    public void add(Status status);   
    public void update(Status status);
    public void delete(int statusId);
    public Status findById(int id);    
    public List<Status> findAll();  
}
