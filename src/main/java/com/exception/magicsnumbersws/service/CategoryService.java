package com.exception.magicsnumbersws.service;
import com.exception.magicsnumbersws.entities.Category;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Service
public interface CategoryService {
        
    public void add(Category category);   
    public void update(Category category);
    public void delete(int categoryId);
    public Category findById(int id);    
    public List<Category> findAll();  
}
