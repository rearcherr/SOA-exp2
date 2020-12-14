package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.persistence.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public List<Course> findAll(){
        return courseMapper.findAll();
    }

    public Course getOne(int id){
        return courseMapper.getOne(id);
    }

    public void add(Course s){
        courseMapper.add(s);
    }

    public void update(Course s){
        courseMapper.update(s);
    }

    public void delete(int id){
        courseMapper.delete(id);
    }


}

