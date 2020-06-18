package com.example.demo;

import com.example.demo.service.CatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        CatalogService catalogService = new CatalogService();
        List<Item> items = catalogService.getProductByALL();
        for(int i = 0; i < items.size(); i++) {
            System.out.println(items.toString());
        }
    }

}
