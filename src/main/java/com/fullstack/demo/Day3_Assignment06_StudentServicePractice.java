package com.fullstack.demo;

import com.fullstack.demo.exception.StudentNotFoundException;
import com.fullstack.demo.model.Student;
import com.fullstack.demo.repository.StudentRepository;
import com.fullstack.demo.repository.InMemoryStudentRepository;
import com.fullstack.demo.service.StudentService;

import java.util.List;

public class Day3_Assignment06_StudentServicePractice {
    public static void main(String[] args) {
        System.out.println("=== StudentService Demo ===\n");

        // Part 1: Create repository and service
        StudentRepository studentRepository = new InMemoryStudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        // Part 2: Register at least 3 students
        System.out.println("=== Register Students ===");
        Student student1 = new Student("S001", "Roberto Chan", "roberto@example.com");
        Student student2 = new Student("S002", "Priya Nair", "priya@example.com");
        Student student3 = new Student("S003", "Lee Salazae", "lee@example.com");

        studentService.registerStudent(student1);
        studentService.registerStudent(student2);
        studentService.registerStudent(student3);
        System.out.println("Registered 3 students successfully.\n");

        // Part 3: Print all students
        System.out.println("=== All Students ===");
        List<Student> allStudents = studentService.getAllStudents();
        for (Student student : allStudents) {
            student.printProfile();
        }

        // Part 4: Find one student by ID
        System.out.println("=== Find Student By ID (S002) ===");
        Student foundStudent = studentService.getStudentById("S002");
        foundStudent.printProfile();

        // Part 5: Search students by name
        System.out.println("=== Search Student By Name (\"Lee\") ===");
        List<Student> searchResults = studentService.searchByNameUsingLoop("Lee");
        for (Student student : searchResults) {
            System.out.println("Found: " + student.getStudentName() + " (" + student.getStudentId() + ")");
        }
        System.out.println();

        // Part 6: Try to find a missing student ID
        System.out.println("=== Missing Student Test ===");
        try {
            Student missingStudent = studentService.getStudentById("S999");
            missingStudent.printProfile();
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Part 7: Bonus - Test stream search
        System.out.println("\n=== Stream Search (\"Priya\") ===");
        List<Student> streamResults = studentService.searchByNameUsingStream("Priya");
        for (Student student : streamResults) {
            System.out.println("Found: " + student.getStudentName() + " (" + student.getStudentId() + ")");
        }
    }
}
