package dao;

import entity.Appointment;
import util.DBConnection;
import util.PropertyUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements IHospitalService {
	//String str = PropertyUtil.getConnectionString("resources\\db.properties");
    Connection con = DBConnection.getConnection();
    
    @Override
    public Appointment getAppointmentById(int appointmentId) {
    	String query = "select * from appointment where appointmentId  = ?";
        PreparedStatement ps = null;
        Appointment apple= new Appointment();
        try{
       
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setInt(1,appointmentId );
            rs = ps.executeQuery();
            if(rs.next()){
            	apple.setAppointmentId(rs.getInt(1));
            	apple.setPatientId(rs.getInt(2));
            	apple.setDoctorId(rs.getInt(3));
            	apple.setAppointmentDate(rs.getDate(4).toString());
            	apple.setDescription(rs.getString(5));
            	}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return apple;
    }

    // Implementation of getAppointmentsForPatient method
    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) {
    	String query = "select * from Appointment where patientID = ?";
    	PreparedStatement ps = null;
    	List<Appointment> list = new ArrayList<>();

    	try{
    	ResultSet rs = null;
    	ps = con.prepareStatement(query);
    	ps.setInt(1,patientId);

    	rs = ps.executeQuery();

    	while(rs.next()){

    	int appointmentID = rs.getInt(1);
    	int patientID = rs.getInt(2);
    	int doctorID = rs.getInt(3);
    	String date = rs.getDate(4).toString();
    	String desc = rs.getString(5);

    	list.add(new Appointment(appointmentID, patientID, doctorID, date, desc));
    	}
    	}catch(SQLException e){
    	e.printStackTrace();
    	}
        return list; // Return an empty list for now
    }

    // Implementation of getAppointmentsForDoctor method
    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();

        // Establish a connection to your database
        try  {
            // Assuming you have a table named 'appointments' in your database
            String query = "SELECT appointmentId, patientId, doctorId, appointmentDate, description " +
                           "FROM appointments " +
                           "WHERE doctorId = ?";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, doctorId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int appointmentId = resultSet.getInt("appointmentId");
                    int patientId = resultSet.getInt("patientId");
                    String appointmentDate = resultSet.getString("appointmentDate");
                    String description = resultSet.getString("description");

                    Appointment appointment = new Appointment(appointmentId, patientId, doctorId, appointmentDate, description);
                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle potential exceptions in a suitable way
        }

        return appointments;
    }


	@Override
	public boolean scheduleAppointment(Appointment appointment) {
		String query = "insert into Appointment value (?,?,?,?,?)";
				PreparedStatement ps = null;

				try{
				ResultSet rs = null;
				ps = con.prepareStatement(query);
				ps.setInt(1,appointment.getAppointmentId());
				ps.setInt(2,appointment.getPatientId());
				ps.setInt(3,appointment.getDoctorId());
				//ps.setDate(4,LocalDate.parse(appointment.getAppointmentDate()));
				ps.setString(4,appointment.getAppointmentDate());
				ps.setString(5, appointment.getDescription());

				rs = ps.executeQuery() ;
				}catch(SQLException e){
				e.printStackTrace();
				}

				return true;
		
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
	    boolean updated = false;

	    try  {
	        // Assuming you have a table named 'appointments' in your database
	        String updateQuery = "UPDATE appointments SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";
	        
	        try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
	            preparedStatement.setInt(1, appointment.getPatientId());
	            preparedStatement.setInt(2, appointment.getDoctorId());
	            preparedStatement.setString(3, appointment.getAppointmentDate());
	            preparedStatement.setString(4, appointment.getDescription());
	            preparedStatement.setInt(5, appointment.getAppointmentId());

	            int rowsAffected = preparedStatement.executeUpdate();
	            
	            // If the update query affected at least one row, consider it as successful
	            updated = rowsAffected > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle potential exceptions in a suitable way
	    }

	    return updated;
	}

	@Override
	public boolean cancelAppointment(int appointmentId) {
	    boolean cancelled = false;

	    try  {
	        // Assuming you have a table named 'appointments' in your database
	        String deleteQuery = "DELETE FROM appointments WHERE appointmentId = ?";
	        
	        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
	            preparedStatement.setInt(1, appointmentId);

	            int rowsAffected = preparedStatement.executeUpdate();
	            
	            // If the delete query affected at least one row, consider it as successful cancellation
	            cancelled = rowsAffected > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle potential exceptions in a suitable way
	    }

	    return cancelled;
	}
	}