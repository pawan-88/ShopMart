package com.shopmart.service;

import com.shopmart.entity.Category;
import com.shopmart.repository.CategoryRepository;
import com.shopmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Long categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = repository.findById(id).orElse(null);

        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());

            return repository.save(existingCategory);
        }
        return null;
    }

    public boolean deleteCategory(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
