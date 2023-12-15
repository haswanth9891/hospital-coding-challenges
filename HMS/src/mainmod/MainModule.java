package mainmod;

import dao.HospitalServiceImpl;
import entity.Appointment;

import java.util.List;

public class MainModule {

    public static void main(String[] args) {
        // Create an instance of the HospitalServiceImpl (or your service implementation)
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();

        // Triggering methods from the service implementation class
        triggerMethods(hospitalService);
    }

    private static void triggerMethods(HospitalServiceImpl hospitalService) {
        // Method 1: Get appointment by ID
        Appointment appointmentById = hospitalService.getAppointmentById(101);
        System.out.println("Appointment by ID: " + appointmentById);

        // Method 2: Get appointments for a patient
        List<Appointment> appointmentsForPatient = hospitalService.getAppointmentsForPatient(1);
        System.out.println("Appointments for patient: " + appointmentsForPatient);

        // Method 3: Get appointments for a doctor
        List<Appointment> appointmentsForDoctor = hospitalService.getAppointmentsForDoctor(1);
        System.out.println("Appointments for doctor: " + appointmentsForDoctor);

        // Method 4: Schedule a new appointment
        Appointment newAppointment = new Appointment(103, 2, 2, "2023-03-20", "New Appointment");
        boolean isScheduled = hospitalService.scheduleAppointment(newAppointment);
        System.out.println("New appointment scheduled: " + isScheduled);

        // Method 5: Update an appointment
        Appointment existingAppointment = new Appointment(102, 2, 2, "2023-02-20", "Updated Description");
        boolean isUpdated = hospitalService.updateAppointment(existingAppointment);
        System.out.println("Appointment updated: " + isUpdated);

        // Method 6: Cancel an appointment by ID
        boolean isCancelled = hospitalService.cancelAppointment(101);
        System.out.println("Appointment cancelled: " + isCancelled);
    }
}
