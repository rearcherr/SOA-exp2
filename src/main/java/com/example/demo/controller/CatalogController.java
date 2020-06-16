package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    //查看所有category
    @GetMapping("/viewAllCategory")
    @ResponseBody
    public List<Category> viewCategoryList() {
        List<Category> category = catalogService.getCategoryList();
        return category;
    }


    //通过productId查看商品内容
    @GetMapping("/viewProduct/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable String id) {
        Product product = catalogService.getProduct(id);
        return product;
    }

    //通过CategoryId查看product
    @GetMapping("/viewProductByCategoryId/{id}")
    @ResponseBody
    public List<Product> getProductByCategoryId(@PathVariable String id) {
        List<Product> product = catalogService.getProductListByCategory(id);
        return product;
    }

    //查看所有Product
    @GetMapping("/viewAllProduct")
    @ResponseBody
    public List<Product> viewProductList() {
        List<Product> products = catalogService.getProdustList();
        return products;
    }

    //通过itemId查看Item
    @GetMapping("/viewItem/{id}")
    @ResponseBody
    public Item getItemById(@PathVariable String id) {
        Item item = catalogService.getItem(id);
        return item;
    }
    //通过ProductId查看Item
    @GetMapping("/viewItemByProductId/{id}")
    @ResponseBody
    public List<Item> getItemByProductId(@PathVariable String id) {
        List<Item> item = catalogService.getItemListByProduct(id);
        return item;
    }

    //查看所有Item
    @GetMapping("/viewAllItem")
    @ResponseBody
    public List<Item> viewItemList() {
        List<Item> items = catalogService.getItemList();
        return items;
    }

    //新增Category
    @PostMapping("newCategory")
    @ResponseBody
    public void Creat(@RequestParam("catid")String categoryId, @RequestParam("name")String name, @RequestParam("descn")String description){
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setName(name);
        category.setDescription(description);
        catalogService.insertCategory(category);
    }



    //新增Product
    @PostMapping("newProduct")
    @ResponseBody
    public void Creat(@RequestParam("productid")String productId,@RequestParam("category")String categoryId, @RequestParam("name")String name,
                      @RequestParam("descn")String description){
        Product product = new Product();
        product.setProductId(productId);
        product.setCategoryId(categoryId);
        product.setName(name);
        product.setDescription(description);
        catalogService.insertProduct(product);
    }

    //新增Item
    @PostMapping("newItem")
    @ResponseBody
    public void Creat(@RequestParam("itemid")String itemId, @RequestParam("productid")String productId, @RequestParam("listprice") BigDecimal listPrice
            , @RequestParam("unitcost")BigDecimal unitCost, @RequestParam("supplier")int supplierId, @RequestParam("status")String status, @RequestParam("attr1")String attribute1
            , @RequestParam("attr2")String attribute2, @RequestParam("attr3")String attribute3, @RequestParam("attr4")String attribute4,
                      @RequestParam("attr5")String attribute5, @RequestParam("qty")int quantity){
        Item item = new Item();
        item.setItemId(itemId);
        item.setProductId(productId);
        item.setListPrice(listPrice);
        item.setUnitCost(unitCost);
        item.setSupplierId(supplierId);
        item.setStatus(status);
        item.setAttribute1(attribute1);
        item.setAttribute2(attribute2);
        item.setAttribute3(attribute3);
        item.setAttribute4(attribute4);
        item.setAttribute5(attribute5);
        item.setQuantity(quantity);
        catalogService.insertItem(item);
    }

    //修改Category
    @PutMapping("/updateCategory/{id}")
    @ResponseBody
    public void Update(@PathVariable("id")String id, @RequestParam(value = "name", required = false)String name, @RequestParam(value = "descn",required = false)String description){
        Category category = catalogService.getCategory(id);
        if (name!=null){
            category.setName(name);
        }
        if (description!=null){
            category.setDescription(description);
        }

        catalogService.updateCategory(category);
    }

    //修改Product
    @PutMapping("/updateProduct/{id}")
    @ResponseBody
    public void Update(@PathVariable("id")String id, @RequestParam(value = "category", required = false)String categoryId, @RequestParam(value = "name", required = false)String name
            , @RequestParam(value = "descn",required = false)String description){
        Product product = catalogService.getProduct(id);
        if (categoryId!=null){
            product.setCategoryId(categoryId);
        }
        if (name!=null){
            product.setName(name);
        }
        if (description!=null){
            product.setDescription(description);
        }

        catalogService.updateProduct(product);
    }

    //修改Item
    @PutMapping("/updateItem/{id}")
    @ResponseBody
    public void Update(@PathVariable("id")String id,@RequestParam(value = "listprice",
            required = false)BigDecimal listPrice
            , @RequestParam(value = "unitcost",required = false)BigDecimal unitCost, @RequestParam(value = "supplier",required = false)Integer supplierId
            , @RequestParam(value = "status",required = false)String status, @RequestParam(value = "attr1",required = false)String attribute1
            , @RequestParam(value = "attr2",required = false)String attribute2, @RequestParam(value = "attr3",required = false)String attribute3
            , @RequestParam(value = "attr4",required = false)String attribute4, @RequestParam(value = "attr5",required = false)String attribute5
            , @RequestParam(value = "qty",required = false)Integer quantity){
        Item item = catalogService.getItem(id);

        if (listPrice!=null){
            item.setListPrice(listPrice);
        }
        if (unitCost!=null){
            item.setUnitCost(unitCost);
        }
        if (supplierId!=null){
            item.setSupplierId(supplierId);
        }if (status!=null){
            item.setStatus(status);
        }if (attribute1!=null){
            item.setAttribute1(attribute1);
        }if (attribute2!=null){
            item.setAttribute2(attribute2);
        }if (attribute3!=null){
            item.setAttribute3(attribute3);
        }if (attribute4!=null){
            item.setAttribute4(attribute4);
        }if (attribute5!=null){
            item.setAttribute5(attribute5);
        }
        if (quantity!=null){
            item.setQuantity(quantity);
        }

        catalogService.updateItem(item);
    }



    //删除Category(只有当product里没有相应的category才能删)
    @DeleteMapping("/deleteCategory/{id}")
    @ResponseBody
    public void deleteCategory(@PathVariable("id")String id){
        Category category = catalogService.getCategory(id);
        catalogService.deleteCategory(category);
    }
    //删除Product(只有当item里没有相应的product才能删)
    @DeleteMapping("/deleteProduct/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable("id")String id){
        Product product = catalogService.getProduct(id);
        catalogService.deleteProduct(product);
    }
    //删除Item
    @DeleteMapping("/deleteItem/{id}")
    @ResponseBody
    public void deleteItem(@PathVariable("id")String id){
        Item item = catalogService.getItem(id);
        catalogService.deleteItem(item);
    }







//    private void processProductDescription(Product product) {
//        String[] temp = product.getDescription().split("\"");
//        product.setDescriptionImage("/"+temp[1]);
//        product.setDescriptionText(temp[2].substring(1));
//    }
//
//    private void processProductDescription(List<Product> productList) {
//        for (Product product : productList) {
//            processProductDescription(product);
//        }
//    }
}

