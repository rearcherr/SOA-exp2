package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    //查看所有课程
    @GetMapping("/courses")
    @ResponseBody
    public List<Course> listCourses() {
        List<Course> courses = courseService.findAll();
        return courses;
    }

    //查看指定课程
    @GetMapping("/course/{id}")
    @ResponseBody
    public Course getCourseById(@PathVariable int id) {
        Course course = courseService.getOne(id);
        return course;
    }

    //增加一个课程
    @PostMapping("/course")
    @ResponseBody
    public List<Course> addCourse(Course s){
        courseService.add(s);
        return courseService.findAll();
    }

    //修改指定课程信息
    @PutMapping("/course/{id}")
    @ResponseBody
    public List<Course> updateCourse(@PathVariable("id")int id, @RequestParam(value = "name", required = false)String name, @RequestParam(value = "credit",required = false)Integer credit){
        Course course = courseService.getOne(id);
        if (name!=null){
            course.setName(name);
        }
        if (credit!=null){
            course.setCredit(credit);
        }
        courseService.update(course);
        return courseService.findAll();
    }

    //删除指定课程
    @DeleteMapping("/course/{id}")
    @ResponseBody
    public List<Course> deleteCourse (@PathVariable("id")int id){
        courseService.delete(id);
        return courseService.findAll();
    }


}
