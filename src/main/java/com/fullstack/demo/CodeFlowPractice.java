package com.fullstack.demo;

import com.fullstack.demo.model.Course;
import com.fullstack.demo.repository.CourseRepository;
import com.fullstack.demo.repository.InMemoryCourseRepository;
import com.fullstack.demo.service.CourseService;

public class CodeFlowPractice {

    public static void main(String[] args) {
        System.out.println("=== Add and Find Course ===\n");

        // ---------------------------------------------------------------
        // Task A - Create the repository and service
        // ---------------------------------------------------------------
        // We create the repository first because CourseService depends on it.
        // CourseService needs a CourseRepository so it can delegate data
        // storage and retrieval operations to the repository layer instead
        // of managing data directly. This follows the separation-of-concerns
        // principle: service handles business logic, repository handles data.
        // ---------------------------------------------------------------

        // Step 1: Create the repository (data layer)
        CourseRepository courseRepository = new InMemoryCourseRepository();

        // Step 2: Create the service, passing the repository into it
        CourseService courseService = new CourseService(courseRepository);

        // ---------------------------------------------------------------
        // Task B - Create one new course
        // ---------------------------------------------------------------
        // Flow:
        //   1. Demo class creates a Course object.
        //   2. Demo class calls courseService.createCourse(...).
        //   3. CourseService validates the course fields (not null, not blank,
        //      duration > 0).
        //   4. CourseService checks if the course ID already exists via
        //      courseRepository.existsById().
        //   5. InMemoryCourseRepository stores the course in its LinkedHashMap.
        //   6. The saved Course is returned back to this demo class.
        // ---------------------------------------------------------------

        Course newCourse = new Course("C004", "Spring Boot API Development", 18, "Intermediate");
        courseService.createCourse(newCourse);

        // ---------------------------------------------------------------
        // Task C - Retrieve the course by ID
        // ---------------------------------------------------------------
        // Flow:
        //   1. Demo class calls courseService.getCourseById("C004").
        //   2. CourseService asks courseRepository.findById("C004").
        //   3. InMemoryCourseRepository looks up "C004" in its LinkedHashMap
        //      and returns an Optional<Course>.
        //   4. CourseService unwraps the Optional; if empty it throws
        //      CourseNotFoundException.
        //   5. The Course object is returned to this demo class.
        //   6. We call printSummary() to display the course details.
        // ---------------------------------------------------------------

        Course retrievedCourse = courseService.getCourseById("C004");
        retrievedCourse.printSummary();

        // ---------------------------------------------------------------
        // Task D - Overall code-flow summary
        // ---------------------------------------------------------------
        // The full request flow for both create and retrieve is:
        //
        //   1. Demo class (CodeFlowPractice) calls CourseService.
        //   2. CourseService validates the course data.
        //   3. CourseService asks CourseRepository to save or find the course.
        //   4. InMemoryCourseRepository stores/retrieves the course in memory
        //      using a LinkedHashMap.
        //   5. Course object is returned to the demo class.
        //
        // In short:
        //   CodeFlowPractice -> CourseService -> CourseRepository
        //       -> InMemoryCourseRepository -> LinkedHashMap
        // ---------------------------------------------------------------
    }
}
