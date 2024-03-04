package com.miniproject.fingerprintauthentication.controller;

import com.miniproject.fingerprintauthentication.entity.Student;
import com.miniproject.fingerprintauthentication.model.StudentModel;
import com.miniproject.fingerprintauthentication.service.StudentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")

public class StudentContoller {

    @Autowired
    private StudentSerivce studentService;

    @GetMapping("/getAllStudents")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<StudentModel>> getAllRegisteredStudents(){
        List<StudentModel> allRegisteredStudents = studentService.getAllRegisteredStudents();
        return ResponseEntity.status(HttpStatus.CREATED).body(allRegisteredStudents);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        Student newStudent = studentService.registerStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student registered: " + newStudent.getName());
    }
    /*
    @GetMapping("/verify/{fingerprint}")
    public ResponseEntity<String> verifyStudent(@PathVariable String fingerprint) {
        Optional<Student> studentOptional = studentService.findByFingerprint(fingerprint);
        return studentOptional.map(student -> ResponseEntity.ok("Student verified: " + student.getName()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found"));
    }



    @DeleteMapping("/delete/{fingerprint}")
    public ResponseEntity<String> deleteStudent(@PathVariable String fingerprint) {
        boolean deleted = studentService.deleteStudent(fingerprint);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

 */
}
