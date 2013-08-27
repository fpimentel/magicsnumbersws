package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import java.util.List;
/**
 *
 * @author fpimentel
 */
public interface ProfileDao {
    public void add(Profile profile);   
    public void update(Profile profile);
    public void delete(int profileId);
    public Profile findById(int id);    
    public List<Profile> findAll() throws SearchAllProfileException; 
}
