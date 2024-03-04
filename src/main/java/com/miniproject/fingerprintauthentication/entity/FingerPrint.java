package com.miniproject.fingerprintauthentication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fingerPrint")
public class FingerPrint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fingerPrintData", nullable = false)
    private String fingerPrintData;

    @Column(name = "biometricId", nullable = false)
    private String biometricId;

}
