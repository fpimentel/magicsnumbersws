package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import com.exception.magicsnumbersws.exception.DeleteConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.exception.FindConsortiumGeneralLimitException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface ConsortiumGeneralLimitDao {

    public void add(ConsortiumGeneralLimit consLimit);    
    public void update(ConsortiumGeneralLimit consLimit);    
    public void delete(int consLimitId);        
    public void deleteByConsortiumId(int consortiumId) throws DeleteConsortiumGeneralLimitException;            
    public ConsortiumGeneralLimit findById(int id) throws FindConsortiumGeneralLimitException;
    public List<ConsortiumGeneralLimit> findByConsortiumId(int consortiumId) throws FindConsortiumGeneralLimitException;
}
