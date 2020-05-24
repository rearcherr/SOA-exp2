package com.example.demo.persistence;


import com.example.demo.domain.Account;
import com.example.demo.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    List<Category> getCategoryList();
    Category getCategory(String categoryId);

    void insertCategory(Category category);
}
