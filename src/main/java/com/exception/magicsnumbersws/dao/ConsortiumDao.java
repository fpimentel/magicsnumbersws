package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 02-sept-2013
 */
public interface ConsortiumDao {
    public void add(Consortium consortium);   
    public void update(Consortium consortium);
    public void delete(int consortiumId);
    public SystemOption findById(int id);    
    public List<Consortium> findAll() throws SearchAllConsortiumException;      
    public List<Consortium> findByUserId(int userId) throws SearchAllConsortiumException;      
    public void saveConsortiumsData(List<Consortium> consortiums) throws SaveSystemOptionsDataException;
}
