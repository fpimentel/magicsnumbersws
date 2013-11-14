package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.User;
import com.exception.magicsnumbersws.entities.UserConsortium;
import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 06-Nov-2013
 */
public interface UserConsortiumDao {

    public void add(UserConsortium userConsortium);    
    public void update(UserConsortium userConsortium);    
    public void delete(int userConsortiumId);                        
    public void deleteAllByUserId(int userId);
    public List<User> findUsersByConsortiumIds(List<Integer> consortiumIds) throws SearchAllUserException;    
}
