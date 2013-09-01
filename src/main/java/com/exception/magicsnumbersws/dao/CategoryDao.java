package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.Category;
import java.util.List;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
public interface CategoryDao {
    public void add(Category category);   
    public void update(Category category);
    public void delete(int categoryId);
    public Category findById(int id);    
    public List<Category> findAll();      
}
