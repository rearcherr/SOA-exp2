package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    //查看所有学生
    @GetMapping("/students")
    @ResponseBody
    public List<Student> listStudents() {
        List<Student> students = studentService.findAll();
        return students;
    }

    //查看指定学生
    @GetMapping("/student/{id}")
    @ResponseBody
    public Student getCategoryById(@PathVariable int id) {
        Student student = studentService.getOne(id);
        return student;
    }

    //增加一个学生
    @PostMapping("/student")
    @ResponseBody
    public List<Student> addStudent(Student s){
        studentService.add(s);
        return studentService.findAll();
    }

    //修改指定学生信息
    @PutMapping("/student/{id}")
    @ResponseBody
    public List<Student> updateStudent(@PathVariable("id")int id, @RequestParam(value = "name", required = false)String name, @RequestParam(value = "age",required = false)Integer age){
        Student student = studentService.getOne(id);
        if (name!=null){
            student.setName(name);
        }
        if (age!=null){
            student.setAge(age);
        }
        studentService.update(student);
        return studentService.findAll();
    }

    //删除指定学生
    @DeleteMapping("/student/{id}")
    @ResponseBody
    public List<Student> deleteStudent (@PathVariable("id")int id){
        studentService.delete(id);
        return studentService.findAll();
    }


}
