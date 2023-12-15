package entity;

import java.util.Scanner;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String contactNumber;

    // Default constructor
    public Doctor() {
    }

    // Parameterized constructor
    public Doctor(int doctorId, String firstName, String lastName, String specialization, String contactNumber) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    // Getters and setters for Doctor class
    // Getters
    public int getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    // Setters
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // toString method to display object details
    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", specialization=" + specialization + ", contactNumber=" + contactNumber + "]";
    }
    public static void main(String args[]) {
    	Scanner sc=new Scanner(System.in);
    	
        System.out.println("Enter Doctor Id : ");
         int doctorId=sc.nextInt();
         System.out.println("Enter First Name : ");
        String firstName=sc.nextLine();
         System.out.println("Enter Last Name : ");
        String lastName=sc.nextLine();
        System.out.println("Enter Specialization : ");
        String specialization=sc.nextLine();
        System.out.println("Enter Contact Number : ");
        String contactNumber=sc.nextLine();
        Doctor doc = new Doctor(doctorId, firstName , lastName,specialization ,contactNumber);
        System.out.println(doc.getDoctorId());
        System.out.println(doc.getFirstName());
        System.out.println(doc.getLastName());
        System.out.println(doc.getSpecialization());
        System.out.println(doc.getContactNumber());
      
        System.out.println(doc.toString());
}
}
