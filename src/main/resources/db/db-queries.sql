CREATE TABLE student
(
    id                TEXT PRIMARY KEY NOT NULL UNIQUE,
    usn               TEXT             NOT NULL,
    name              TEXT             NOT NULL,
    email             TEXT             NOT NULL,
    biometric_id      TEXT             NOT NULL,
    registration_date TEXT             NOT NULL
);


CREATE TABLE FINGER_PRINT
(
    id              TEXT PRIMARY KEY NOT NULL UNIQUE,
    biometric_id    TEXT             NOT NULL,
    fingerPrintData TEXT             NOT NULL
);