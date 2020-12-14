package com.example.demo.persistence;

import com.example.demo.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseMapper {
    List<Course> findAll();
    Course getOne(int id);
    void add(Course s);
    void update(Course s);
    void delete(int id);
}
