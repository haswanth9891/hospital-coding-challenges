package entity;

import java.util.Scanner;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactNumber;
    private String address;

    // Default constructor
    public Patient() {
    }

    // Parameterized constructor
    public Patient(int patientId, String firstName, String lastName, String dateOfBirth,
                   String gender, String contactNumber, String address) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    // Getters and setters for Patient class
    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString method to display object details
    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", contactNumber=" + contactNumber
                + ", address=" + address + "]";
    }
    public static void main(String args[]) {
    	Scanner sc=new Scanner(System.in);
    	
        System.out.println("Enter Patient Id : ");
         int patientId=sc.nextInt();
         System.out.println("Enter First Name : ");
        String firstName=sc.nextLine();
         System.out.println("Enter Last Name : ");
        String lastName=sc.nextLine();
        System.out.println("Enter Date of Birth : ");
        String dateOfBirth=sc.nextLine();
        System.out.println("Enter Gender : ");
        String gender=sc.nextLine();
        System.out.println("Enter Contact Number : ");
        String contactNumber=sc.nextLine();
        System.out.println("Enter Contact Number : ");
        String address=sc.nextLine();
        Patient pat = new Patient(patientId, firstName , lastName,dateOfBirth ,gender,contactNumber,address);
        System.out.println(pat.getPatientId());
        System.out.println(pat.getFirstName());
        System.out.println(pat.getLastName());
        System.out.println(pat.getDateOfBirth());
        System.out.println(pat.getGender());
        System.out.println(pat.getContactNumber());
        System.out.println(pat.getAddress());
      
        System.out.println(pat.toString());
}
}
