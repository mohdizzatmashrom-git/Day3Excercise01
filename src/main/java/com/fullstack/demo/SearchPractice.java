package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

import java.util.List;

public class SearchPractice {
    public static void main(String[] args) {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course c1 = new Course("C001", "Java Fundamentals", 14, "Beginner");
        Course c2 = new Course("C002", "React Frontend Development", 21, "Intermediate");
        Course c3 = new Course("C003", "MongoDB Basics", 10, "Beginner");
        Course c4 = new Course("C004", "Spring Boot API Development", 28, "Intermediate");

        courseService.createCourse(c1);
        courseService.createCourse(c2);
        courseService.createCourse(c3);
        courseService.createCourse(c4);

        List<Course> beginnerCourses = courseService.searchByLevelUsingLoop("Beginner");

        System.out.println("=== Beginner Courses ===");
        printCourses(beginnerCourses);
    }

    private static void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course course : courses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }
    }
}
