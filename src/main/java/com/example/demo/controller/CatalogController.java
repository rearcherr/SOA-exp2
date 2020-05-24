package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Product;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;



    //通过categoryId查看商品列表
    @GetMapping("/viewCategory/{id}")
    @ResponseBody
    public Category getCategoryById(@PathVariable String id) {
        Category category = catalogService.getCategory(id);
        return category;
    }

    //通过productId查看商品内容
    @GetMapping("/viewProduct/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable String id) {
        Product product = catalogService.getProduct(id);
        return product;
    }

    //通过itemId查看Item
    @GetMapping("/viewItem/{id}")
    @ResponseBody
    public Item getItemById(@PathVariable String id) {
        Item item = catalogService.getItem(id);
        return item;
    }

    //新增Category
    @PostMapping("newCategory")
    @ResponseBody
    public Category Creat(@RequestParam("catid")String categoryId, @RequestParam("name")String name, @RequestParam("descn")String description){
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setName(name);
        category.setDescription(description);
        catalogService.insertCategory(category);
        return category;
    }





    private void processProductDescription(Product product) {
        String[] temp = product.getDescription().split("\"");
        product.setDescriptionImage("/"+temp[1]);
        product.setDescriptionText(temp[2].substring(1));
    }

    private void processProductDescription(List<Product> productList) {
        for (Product product : productList) {
            processProductDescription(product);
        }
    }
}

