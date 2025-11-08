package com.student.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.model.Student;
import com.student.respository.StudentRepo;

/**
 * StudentController
 * ------------------
 * This REST controller handles all CRUD operations for Student entity.
 * It interacts with the StudentRepo interface to perform database operations.
 * 
 * @author Madhusudan Dande
 */
@RestController
@RequestMapping("/student") // Base URL for all student-related APIs
public class StudentController {

    // Injecting StudentRepo instance to interact with the database
    @Autowired
    StudentRepo repo;

    /**
     * Save a single student record into the database.
     * 
     * @RequestBody s Student object received in the request body
     * @return Success message after saving details
     */
    @PostMapping("/saveStudentDetails")
    public ResponseEntity<String> saveStudentDetails(@RequestBody Student s) {
        repo.save(s);
        return ResponseEntity.ok("Details Saved Successfully");
    }

    /**
     * Save multiple student records into the database at once.
     * 
     * @RequestBody s List of Student objects
     * @return Success message after saving all records
     */
    @PostMapping("/saveMultipleStudentDetails")
    public ResponseEntity<String> saveMultipleStudentDetails(@RequestBody List<Student> s) {
        repo.saveAll(s);
        return ResponseEntity.ok("All Student Details Saved Successfully");
    }

    /**
     * Retrieve all student records from the database.
     * 
     * @return List of all students
     */
    @GetMapping("/getAllStudentDetails")
    public List<Student> getAllStudentDetails() {
        return repo.findAll();
    }

    /**
     * Retrieve student records based on their city.
     * 
     * @PathVariable stdCity City name to filter students
     * @return List of students belonging to the specified city
     */
    @GetMapping("/getStudentByCity/{cityName}")
    public List<Student> getStudentByCity(@PathVariable("cityName") String stdCity) {
        return repo.findBystdCity(stdCity);
    }

    /**
     * Retrieve student records based on their class (standard).
     * 
     * @PathVariable stdClass Class number to filter students
     * @return List of students studying in the specified class
     */
    @GetMapping("/getStudentByClass/{stdClass}")
    public List<Student> getStudentByClass(@PathVariable("stdClass") Integer stdClass) {
        return repo.findBystdClass(stdClass);
    }

    /**
     * Retrieve a specific student record by their roll number (ID).
     * 
     * @PathVariable rollNo Student roll number (ID)
     * @return Student details if found, otherwise 404 Not Found
     */
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer rollNo) {
        return repo.findById(rollNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete a specific student record by ID.
     * 
     * @PathVariable rollNo Student roll number (ID)
     * @return Success message after deletion
     */
    @DeleteMapping("/deleteStudentDetailsById/{id}")
    public ResponseEntity<String> deleteDetailsById(@PathVariable("id") Integer rollNo) {
        repo.deleteById(rollNo);
        return ResponseEntity.ok("Details Has Been Deleted Successfully for Given Id");
    }

    /**
     * Delete student records belonging to a specific city.
     * 
     * @PathVariable stdCity City name
     * @return Success message after deleting all matching records
     */
    @DeleteMapping("/deleteStudentDetailsByCity/{city}")
    public ResponseEntity<String> deleteDetailsByCity(@PathVariable("city") String stdCity) {
        repo.deleteBystdCity(stdCity);
        return ResponseEntity.ok("Details Has Been Deleted Successfully for Given City");
    }

    /**
     * Delete student records belonging to a specific class.
     * 
     * @PathVariable stdClass Class number
     * @return Success message after deleting all matching records
     */
    @DeleteMapping("/deleteStudentDetailsByClass/{stdClass}")
    public ResponseEntity<String> deleteDetailsByClass(@PathVariable("stdClass") Integer stdClass) {
        repo.deleteBystdClass(stdClass);
        return ResponseEntity.ok("Details Has Been Deleted Successfully for Given Class");
    }
}
