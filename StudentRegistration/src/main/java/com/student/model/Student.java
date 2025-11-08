package com.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Student Entity Class
 * --------------------
 * Represents the Student table in the database.
 * Each object of this class corresponds to a record in the "StudentRegistration" table.
 * 
 * It contains basic student details such as roll number, name, city, mobile number, and class.
 * 
 * Author: Rohit  
 * Version: 1.0  
 * Date: 2025-10-14
 */

@Entity
@Table(name = "StudentRegistration")
public class Student {

    // -------------------- Fields --------------------

    // Unique roll number for each student (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    // Student full name
    private String stdName;

    // City where the student resides
    private String stdCity;

    // Mobile number of the student
    private long stdMobNo;

    // Class or standard in which the student is studying
    private int stdClass;


    // -------------------- Constructors --------------------

    // Default constructor (required by JPA)
    public Student() {
        super();
    }

    // Parameterized constructor for easy object creation
    public Student(int rollNo, String stdName, String stdCity, long stdMobNo, int stdClass) {
        super();
        this.rollNo = rollNo;
        this.stdName = stdName;
        this.stdCity = stdCity;
        this.stdMobNo = stdMobNo;
        this.stdClass = stdClass;
    }


    // -------------------- Getters and Setters --------------------

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdCity() {
        return stdCity;
    }

    public void setStdCity(String stdCity) {
        this.stdCity = stdCity;
    }

    public long getStdMobNo() {
        return stdMobNo;
    }

    public void setStdMobNo(long stdMobNo) {
        this.stdMobNo = stdMobNo;
    }

    public int getStdClass() {
        return stdClass;
    }

    public void setStdClass(int stdClass) {
        this.stdClass = stdClass;
    }


    // -------------------- Utility Method --------------------

    // Displays student information in a readable format
    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + 
               ", stdName=" + stdName + 
               ", stdCity=" + stdCity + 
               ", stdMobNo=" + stdMobNo + 
               ", stdClass=" + stdClass + "]";
    }
}
