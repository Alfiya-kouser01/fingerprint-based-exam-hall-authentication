package com.miniproject.fingerprintauthentication.repository;

import com.miniproject.fingerprintauthentication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student,Integer> {
    //Optional<Student> findByFingerprint(String fingerprint);
}
