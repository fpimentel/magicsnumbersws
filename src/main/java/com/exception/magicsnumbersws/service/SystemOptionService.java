package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author cpimentel
 */
@Service
public interface SystemOptionService {
        
     public void add(SystemOption systemOption);   
    public void update(SystemOption systemOption);
    public void delete(int systemOptionId);
    public SystemOption findById(int id);    
    public List<SystemOption> findAll()throws SearchAllSystemOptionException;;      
}
