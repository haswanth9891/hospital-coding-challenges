package dao;

import entity.Appointment;
import java.util.List;

public interface IHospitalService {

    // Retrieve an appointment by its ID
    Appointment getAppointmentById(int appointmentId);

    // Retrieve appointments for a specific patient
    List<Appointment> getAppointmentsForPatient(int patientId);

    // Retrieve appointments for a specific doctor
    List<Appointment> getAppointmentsForDoctor(int doctorId);

    // Schedule a new appointment
    boolean scheduleAppointment(Appointment appointment);

    // Update an existing appointment
    boolean updateAppointment(Appointment appointment);

    // Cancel an appointment by its ID
    boolean cancelAppointment(int appointmentId);
}
