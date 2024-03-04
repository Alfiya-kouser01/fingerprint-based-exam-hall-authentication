package com.miniproject.fingerprintauthentication.repository;

import com.miniproject.fingerprintauthentication.entity.FingerPrint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FingerPrintRepository extends JpaRepository<FingerPrint,Integer> {
    FingerPrint findFingerPrintByBiometricId(String biometricId);
}
