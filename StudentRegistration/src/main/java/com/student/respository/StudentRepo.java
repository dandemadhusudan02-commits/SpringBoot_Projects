package com.student.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

import jakarta.transaction.Transactional;

/**
 * StudentRepo Interface
 * ---------------------
 * This interface extends JpaRepository to perform CRUD operations 
 * on the Student entity.
 * 
 * It also includes custom query methods based on Spring Data JPA 
 * naming conventions.
 * 
 * Examples:
 * - findBystdCity → Find all students from a given city
 * - deleteBystdClass → Delete all students of a given class
 * 
 * JpaRepository already provides methods like save(), findById(), 
 * findAll(), deleteById(), etc.
 * 
 * Author:Madhusudan Dande
 */

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    // Fetch all students who belong to a specific class
    List<Student> findBystdClass(int stdClass);

    // Fetch all students who belong to a specific city
    List<Student> findBystdCity(String stdCity);

    // Delete all students belonging to a given city (Transactional ensures DB consistency)
    @Transactional
    Long deleteBystdCity(String stdCity);

    // Delete all students belonging to a given class (Transactional ensures DB consistency)
    @Transactional
    Long deleteBystdClass(int stdClass);
}
