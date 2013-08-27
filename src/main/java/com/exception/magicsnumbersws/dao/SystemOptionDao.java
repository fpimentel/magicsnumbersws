package com.exception.magicsnumbersws.dao;


import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import java.util.List;

/**
 *
 * @author cpimentel
 */
public interface SystemOptionDao {
    public void add(SystemOption systemOption);   
    public void update(SystemOption systemOption);
    public void delete(int systemOptionId);
    public SystemOption findById(int id);    
    public List<SystemOption> findAll() throws SearchAllSystemOptionException;      
}
