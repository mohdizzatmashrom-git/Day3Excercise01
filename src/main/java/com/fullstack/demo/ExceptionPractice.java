package com.fullstack.demo;

import com.fullstack.demo.exception.CourseNotFoundException;
import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class ExceptionPractice {
    public static void main(String[] args) {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        // Add two courses
        Course c1 = new Course("C001", "Java Fundamentals", 14, "Beginner");
        Course c2 = new Course("C002", "React Frontend Development", 21, "Intermediate");

        courseService.createCourse(c1);
        courseService.createCourse(c2);

        // Task C - find existing course
        System.out.println("Finding existing course C001:");
        Course course = courseService.getCourseById("C001");
        course.printSummary();

        // Task D - find missing course C999 and catch exception
        System.out.println("\nSearching for C999:");
        try {
            Course missingCourse = courseService.getCourseById("C999");
            missingCourse.printSummary();
        } catch (CourseNotFoundException e) {
            System.out.println("Friendly message for user: " + e.getMessage());
        }

        // Task E - another missing course C888 with different friendly message
        System.out.println("\nSearching for C888:");
        try {
            courseService.getCourseById("C888");
        } catch (CourseNotFoundException e) {
            System.out.println("Cannot display course details because the course does not exist.");
        }
    }
}
