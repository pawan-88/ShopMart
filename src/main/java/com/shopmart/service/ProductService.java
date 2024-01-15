package com.shopmart.service;

import com.shopmart.entity.Category;
import com.shopmart.entity.Product;
import com.shopmart.repository.CategoryRepository;
import com.shopmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product createProduct(Product product) {
        if (product.getCategory() != null && product.getCategory().getId() == null) {
            Category savedCategory = categoryRepository.save(product.getCategory());
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            if (updatedProduct.getCategory() != null && updatedProduct.getCategory().getId() == null) {
                Category savedCategory = categoryRepository.save(updatedProduct.getCategory());
                existingProduct.setCategory(savedCategory);
            } else {
                existingProduct.setCategory(updatedProduct.getCategory());
            }
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepository.save(existingProduct);
        }

        return null;
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Long categoryId = product.getCategory().getId();
            productRepository.deleteById(id);
            if (!productRepository.existsByCategoryId(categoryId)) {
                categoryRepository.deleteById(categoryId);
            }
            return true;
        }
        return false;
    }
}
