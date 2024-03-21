package com.miniproject.fingerprintauthentication.service;

import com.miniproject.fingerprintauthentication.entity.FingerPrint;
import com.miniproject.fingerprintauthentication.entity.Student;
import com.miniproject.fingerprintauthentication.model.StudentModel;
import com.miniproject.fingerprintauthentication.repository.FingerPrintRepository;
import com.miniproject.fingerprintauthentication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
public class StudentSerivce {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FingerPrintRepository fingerPrintRepository;

    public List<StudentModel> getAllRegisteredStudents() {
        List<StudentModel> response = new ArrayList<>();
        List<Student> allStudents = studentRepository.findAll();
        for(Student student : allStudents){
            FingerPrint fingerPrintByBiometricId = fingerPrintRepository.findFingerPrintByBiometricId(student.getBiometricId());
            StudentModel studentModel = studentResponseMapper(student, fingerPrintByBiometricId);
            response.add(studentModel);
        }
        return response;
    }

    private StudentModel studentResponseMapper(Student student, FingerPrint fingerPrintByBiometricId) {
        return StudentModel.builder()
                .id(student.getId())
                .name(student.getName())
                .usn(student.getUsn())
                .email(student.getEmail())
                .registrationDate(student.getRegistrationDate())
                .biometricId(student.getBiometricId())
                .fingerPrintData(fingerPrintByBiometricId.getFingerPrintData())
                .build();
    }

    public Student registerStudent(Student student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setUsn(student.getUsn());
        return studentRepository.save(newStudent);
    }

    public long getTotalRegistration() {
        return studentRepository.count();
    }

      public Map<Integer,Integer> getGraphData(){
          Map<Integer, Integer> monthlyData = new HashMap<>();
          List<Student> allStudents = studentRepository.findAll();
          Month currentMonth = LocalDate.now().getMonth();
          for (Student student : allStudents) {
              String registrationDate = student.getRegistrationDate(); // Assuming registrationDate is a string in "DD-MM-YYYY" format
              int registrationMonth = Integer.parseInt(registrationDate.split("-")[1]); // Extract month from registrationDate string
              int monthDifference = Math.abs(registrationMonth - currentMonth.getValue()); // Calculate difference from current month

              // Update the monthlyData map with the month difference
              monthlyData.put(monthDifference, monthlyData.getOrDefault(monthDifference, 0) + 1);
          }
          return monthlyData;
      }

    /*
       public Optional<Student> findByFingerprint(String fingerprint) {
        return studentRepository.findByFingerprint(fingerprint);
    }

    // Additional methods for registration and other business logic

    // Example of a registration method:

    public boolean deleteStudent(String fingerprint) {
        Optional<Student> studentOptional = studentRepository.findByFingerprint(fingerprint);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true; // Student deleted successfully
        }
        return false; // Student not found
    }



     */
}
