package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 */
@Service
public interface ProfileService {        
    public void add(Profile profile);   
    public void update(Profile profile);
    public void delete(int profileId);
    public Profile findById(int id);    
    public List<Profile> findAll() throws SearchAllProfileException; 
}
