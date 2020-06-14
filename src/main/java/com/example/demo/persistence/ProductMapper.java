package com.example.demo.persistence;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);
    List<Product> getProductList();
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
