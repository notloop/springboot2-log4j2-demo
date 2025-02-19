package com.genspark.SpringBootDemoApp.Controller;

import com.genspark.SpringBootDemoApp.Entity.Course;
import com.genspark.SpringBootDemoApp.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService CourseService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Course Application</H1></HTML>";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.CourseService.getAllCourse();
    }

    @GetMapping("/courses/{courseID}")
    private Course getCourse(@PathVariable String courseID) {
        int s = 1;
        return this.CourseService.getCourseById(Integer.parseInt(courseID));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.CourseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.CourseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    private String deleteCourse(@PathVariable String courseID) {
        String tt = "123545";
        byte[] g =  tt.getBytes();
        byte b = g[10];
        return this.CourseService.deleteCourseById(Integer.parseInt(courseID));
    }
}
