package com.example.demo.service;


import com.example.demo.domain.Account;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Product;
import com.example.demo.persistence.CategoryMapper;
import com.example.demo.persistence.ItemMapper;
import com.example.demo.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CatalogService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ItemMapper itemMapper;

    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryMapper.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }

    public List<Product> searchProductList(String keyword) {
        return productMapper.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId){
        return itemMapper.getItemListByProduct(productId);
    }

    public Item getItem(String itemId){
        return itemMapper.getItem(itemId);
    }

    public boolean isItemInStock(String itemId){
        return itemMapper.getInventoryQuantity(itemId) > 0;
    }

    public void updateInventoryQuantity(Map<String, Object> param){
        itemMapper.updateInventoryQuantity(param);
    }

    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    public void insertItem(Item item){
        itemMapper.insertItem(item);
        itemMapper.insertInventory(item);
    }

    public void updateCategory(Category category){
        categoryMapper.updateCategory(category);
    }
    public void updateProduct(Product product){
        productMapper.updateProduct(product);
    }
    public void updateItem(Item item){
        itemMapper.updateItem(item);
        itemMapper.updateInventory(item);
    }
    public void deleteCategory(Category category){
        categoryMapper.deleteCategory(category);
    }
    public void deleteProduct(Product product){
        productMapper.deleteProduct(product);
    }
    public void deleteItem(Item item){
        itemMapper.deleteItem(item);
        itemMapper.deleteInventory(item);
    }
}
