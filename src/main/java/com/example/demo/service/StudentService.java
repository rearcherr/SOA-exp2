package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.persistence.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public List<Student> findAll(){
        return studentMapper.findAll();
    }

    public Student getOne(int id){
        return studentMapper.getOne(id);
    }

    public void add(Student s){
        studentMapper.add(s);
    }

    public void update(Student s){
        studentMapper.update(s);
    }

    public void delete(int id){
        studentMapper.delete(id);
    }


}

