package com.example.demo.persistence;

import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    List<Student> findAll();
    Student getOne(int id);
    void add(Student s);
    void update(Student s);
    void delete(int id);
}
