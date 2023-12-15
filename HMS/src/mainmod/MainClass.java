package mainmod;

//MainClass.java
import myexceptions.PatientNumberNotFoundException;

public class MainClass {
 // Simulating a database with patient numbers
 private static int[] patientDatabase = {101, 102, 103, 104, 105};

 public static void main(String[] args) {
     try {
         int patientNumberToFind = 106;  // Replace with the actual input from the user

         findPatient(patientNumberToFind);
     } catch (PatientNumberNotFoundException e) {
         System.out.println("Exception: " + e.getMessage());
     }
 }

 // Method to find a patient in the database
 private static void findPatient(int patientNumber) throws PatientNumberNotFoundException {
     boolean patientExists = false;

     // Check if the patient number exists in the database
     for (int number : patientDatabase) {
         if (number == patientNumber) {
             patientExists = true;
             break;
         }
     }

     // If the patient number is not found, throw the custom exception
     if (!patientExists) {
         throw new PatientNumberNotFoundException("Patient with number " + patientNumber + " not found in the database.");
     }

     // If the patient is found, perform the necessary operations
     System.out.println("Patient with number " + patientNumber + " found in the database.");
     // Add additional logic here as needed
 }
}
