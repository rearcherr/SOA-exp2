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

import java.util.ArrayList;
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
        List<Category> categories = categoryMapper.getCategoryList();
        List<Product> products = new ArrayList<Product>();
        int a=categories.size();
        for(int i=0;i<a;i++){
            products=productMapper.getProductListByCategory(categories.get(i).getCategoryId());
            categories.get(i).setProducts(products);
        }
        return categories;
    }
    public List<Product> getProdustList() {
        return productMapper.getProductList();
    }
    public Category getCategory(String categoryId) {
        Category category = categoryMapper.getCategory(categoryId);
        List<Product> products = productMapper.getProductListByCategory(categoryId);
        category.setProducts(products);
        return category;

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

        List<Item> c = itemMapper.getItemListByProduct(productId);
        List<Item> items = new ArrayList<Item>();
        int a = c.size();
        int b;
        for(int i=0;i<a;i++){
            b=itemMapper.getInventoryQuantity(c.get(i).getItemId());
            c.get(i).setQuantity(b);
            items.add(c.get(i));
        }
        return items;
    }
    public List<Item> getItemList(){
        List<Item> c =itemMapper.getItemList();
        List<Item> items = new ArrayList<Item>();
        int a = c.size();
        int b;
        for(int i=0;i<a;i++){
            b=itemMapper.getInventoryQuantity(c.get(i).getItemId());
            c.get(i).setQuantity(b);
            items.add(c.get(i));
        }
        return items;
    }
    public Item getItem(String itemId){
        Item item = itemMapper.getItem(itemId);
        int b;
        b=itemMapper.getInventoryQuantity(itemId);
        item.setQuantity(b);
        return item;
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

    public List<Item> getProductByIdAndKeyword(String keyword){ return itemMapper.getProductByIdAndKeyword(keyword); }
    public List<Item> getProductByNameAndKeyword(String keyword){ return itemMapper.getProductByNameAndKeyword(keyword); }
    public List<Item> getProductByAttrAndKeyword(String keyword){ return itemMapper.getProductByAttrAndKeyword(keyword); }
    public List<Item> getProductByALL(String keyword){ return itemMapper.getProductByAllAndKeyword(); }
}
