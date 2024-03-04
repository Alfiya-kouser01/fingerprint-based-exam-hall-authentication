package com.miniproject.fingerprintauthentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRegistrationRequest {
    private String fingerprint;
    private String name;
    private String usn;
}
