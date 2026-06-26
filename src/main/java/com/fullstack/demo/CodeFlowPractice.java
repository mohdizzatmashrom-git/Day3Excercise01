package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class CodeFlowPractice {

    public static void main(String[] args) {
        System.out.println("=== Add and Find Course ===\n");

        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course newCourse = new Course("C004", "Spring Boot API Development", 18, "Intermediate");
        courseService.createCourse(newCourse);

        Course retrievedCourse = courseService.getCourseById("C004");
        retrievedCourse.printSummary();
    }
}
