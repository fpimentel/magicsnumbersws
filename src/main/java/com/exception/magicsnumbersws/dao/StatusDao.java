package com.exception.magicsnumbersws.dao;

import com.exception.magicsnumbersws.entities.Status;

import com.exception.magicsnumbersws.exception.SearchAllUserException;
import java.util.List;

/**
 *
 * @author fpimentel
 */
public interface StatusDao {
    public void add(Status status);   
    public void update(Status status);
    public void delete(int statusId);
    public Status findById(int id);    
    public List<Status> findAll();      
}
