package com.miniproject.fingerprintauthentication.model;

import lombok.Builder;

@Builder
public class StudentModel {
    private Integer id;
    private String usn;
    private String name;

    private String email;

    private String biometricId;

    private String registrationDate;

    private String fingerPrintData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiometricId() {
        return biometricId;
    }

    public void setBiometricId(String biometricId) {
        this.biometricId = biometricId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFingerPrintData() {
        return fingerPrintData;
    }

    public void setFingerPrintData(String fingerPrintData) {
        this.fingerPrintData = fingerPrintData;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", usn='" + usn + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", biometricId='" + biometricId + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", fingerPrintData='" + fingerPrintData + '\'' +
                '}';
    }
}
