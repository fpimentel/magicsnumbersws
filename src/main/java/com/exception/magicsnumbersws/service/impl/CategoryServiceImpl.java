package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.CategoryDao;
import com.exception.magicsnumbersws.dao.StatusDao;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 31-agosto-2013
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
    }

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void delete(int categoryId) {
        categoryDao.delete(categoryId);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
