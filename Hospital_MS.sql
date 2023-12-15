-- HMS
DROP SCHEMA

IF EXISTS HMS;
	CREATE SCHEMA HMS COLLATE = utf8_general_ci;

USE HMS;

-- CREATING TABLES --

CREATE TABLE Patient (
    patientId INT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    dateOfBirth DATE,
    gender VARCHAR(10),
    contactNumber VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE Doctor (
    doctorId INT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    specialization VARCHAR(100),
    contactNumber VARCHAR(20)
);


CREATE TABLE Appointment (
    appointmentId INT PRIMARY KEY,
    patientId INT,
    doctorId INT,
    appointmentDate DATE,
    description TEXT
);


-- FOREIGN KEYS --
Alter table Appointment ADD FOREIGN KEY (patientId) REFERENCES Patient(patientId); 
Alter table Appointment ADD FOREIGN KEY (doctorId) REFERENCES Doctor(doctorId); 



-- Inserting values ----

INSERT INTO Patient (patientId, firstName, lastName, dateOfBirth, gender, contactNumber, address)
VALUES 
    (1, 'John', 'Doe', '1990-05-15', 'Male', '1234567890', '123 Main Street'),
    (2, 'Jane', 'Smith', '1985-09-20', 'Female', '9876543210', '456 Elm Street');

INSERT INTO Doctor (doctorId, firstName, lastName, specialization, contactNumber)
VALUES 
    (11, 'Dr. David', 'Johnson', 'Cardiologist', '5551112222'),
    (22, 'Dr. Emily', 'Williams', 'Pediatrician', '5553334444');

INSERT INTO Appointment (appointmentId, patientId, doctorId, appointmentDate, description)
VALUES 
    (101, 1, 11, '2023-01-10', 'Regular checkup'),
    (102, 2, 22, '2023-02-15', 'Vaccination');
