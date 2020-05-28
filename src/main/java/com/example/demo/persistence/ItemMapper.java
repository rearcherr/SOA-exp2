package com.example.demo.persistence;

import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ItemMapper {

    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);

    void insertItem(Item item);

    void insertInventory(Item item);

    void updateItem(Item item);

    void updateInventory(Item item);

    void deleteItem(Item item);

    void deleteInventory(Item item);
}
