package entity;

import java.util.Scanner;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    private String description;

    // Default constructor
    public Appointment() {
    }

    // Parameterized constructor
    public Appointment(int appointmentId, int patientId, int doctorId, String appointmentDate, String description) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters and setters for Appointment class
    // Getters
    
    
    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString method to display object details
    @Override
    public String toString() {
        return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
                + ", appointmentDate=" + appointmentDate + ", description=" + description + "]";
    }
    public static void main(String args[]) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter Appointment Id : ");
    	int appointmentId=sc.nextInt();
    	System.out.println("Enter Patient Id : ");
        int patientId=sc.nextInt();
        System.out.println("Enter Doctor Id : ");
         int doctorId=sc.nextInt();
         System.out.println("Enter Appointment Date : ");
        String appointmentDate=sc.nextLine();
         System.out.println("Enter Description : ");
        String description=sc.nextLine();
        Appointment app = new Appointment(appointmentId, patientId , doctorId,appointmentDate ,description);
        System.out.println(app.getAppointmentId());
        System.out.println(app.getPatientId());
        System.out.println(app.getDoctorId());
        System.out.println(app.getAppointmentDate());
        System.out.println(app.getDescription());
      
        System.out.println(app.toString());
}
}