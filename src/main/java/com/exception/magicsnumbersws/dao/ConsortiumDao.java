package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Consortium> findActiveConsortium() throws SearchAllConsortiumException;    
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Consortium> findByUserId(int userId) throws SearchAllConsortiumException;      
    public void saveConsortiumsData(List<Consortium> consortiums) throws SaveConsortiumDataException;
    public void saveConsortiumData(Consortium consortium) throws SaveConsortiumDataException;    
}
