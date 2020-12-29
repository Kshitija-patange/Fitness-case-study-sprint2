package com.capgemini.Zfitnessapp.serviceTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capgemini.fitness.dao.AppointmentDataDao;
import com.capgemini.fitness.entity.Appointment;
import com.capgemini.fitness.exception.AppointmentException;
import com.capgemini.fitness.service.AppointmentService;

@SpringBootTest
public class AppointmentServiceTest  {	
	@Autowired
	private AppointmentService appointmentService;
	@MockBean
	private AppointmentDataDao  appointmentDataDao;
	/*
	 * Add Appointment
	 */
	@Test
	@DisplayName("Test save appointment")
	public void testSave() throws AppointmentException  {
		// Setup our mock repository
		Appointment appointment = new Appointment();
		appointment.setAppointment_id(1);
		appointment.setUser_id(1);
		appointment.setTrainer_id(1);
		appointment.setTrainer_Preference("female");
		appointment.setPhy_the("yes");
		appointment.setAmount(1000);
		appointment.setLocation("pune");
		String appointmentDate="22-12-2020";
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate appointmentDate1= LocalDate.parse(appointmentDate, formatter);
		appointment.setDate(appointmentDate1);

		doReturn(appointment).when(appointmentDataDao).save(any());
		// Execute the service call
		Integer returnedAppointment =  appointmentService.addAppointment(appointment);
		// Assert the response
		Assertions.assertNotNull(returnedAppointment, "The saved appointment should not be null");
	}
	/*
	 * Get By id
	 */
	@Test
	@DisplayName("Test findById Success")
	void testFindById() throws AppointmentException {
		// Setup our mock repository
		Appointment appointment = new Appointment();
		appointment.setAppointment_id(1);
		appointment.setUser_id(1);
		appointment.setTrainer_id(1);
		appointment.setTrainer_Preference("female");
		appointment.setPhy_the("yes");
		appointment.setAmount(1000);
		appointment.setLocation("pune");
		String appointmentDate="22-12-2020";
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate appointmentDate1= LocalDate.parse(appointmentDate, formatter);
		appointment.setDate(appointmentDate1);
		doReturn(Optional.of(appointment)).when(appointmentDataDao).findById(1);
		// Execute the service call
		Appointment returnedAppointment = appointmentService.getAppointmentById(1);
		/*
		 * boolean a; if(returnedAppointment!=null) { a=true;} else { a=false;}
		 * Assertions.assertTrue(a, "Appointment was  found");
		 */
		Assertions.assertNotNull(returnedAppointment, "Appointment was  found");
	}
	/*
	 * View All 
	 */
	@Test
	@DisplayName("Test findAll")
	void testFindAll() throws AppointmentException {
		// Setup our mock repository
		Appointment appointment = new Appointment();
		appointment.setAppointment_id(1);
		appointment.setUser_id(1);
		appointment.setTrainer_id(1);
		appointment.setTrainer_Preference("female");
		appointment.setPhy_the("yes");
		appointment.setAmount(1000);
		appointment.setLocation("pune");
		String appointmentDate="22-12-2020";
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate appointmentDate1= LocalDate.parse(appointmentDate, formatter);
		appointment.setDate(appointmentDate1);

		Appointment appointment1 = new Appointment();
		appointment1.setAppointment_id(2);
		appointment1.setUser_id(1);
		appointment1.setTrainer_id(1);
		appointment1.setTrainer_Preference("female");
		appointment1.setPhy_the("yes");
		appointment1.setAmount(1000);
		appointment1.setLocation("pune");
		String appointmentDate2="22-12-2020";
		DateTimeFormatter formatter2 =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate appointmentDate3= LocalDate.parse(appointmentDate2, formatter2);
		appointment.setDate(appointmentDate3);
		doReturn(Arrays.asList(appointment, appointment1)).when(appointmentDataDao).findAll();
		// Execute the service call
		List<Appointment> appointments = appointmentService.viewAppointment();
		// Assert the response
		Assertions.assertEquals(2, appointments.size(), "findAll should return 2 widgets");
	}
	/*
	 * Update details
	 */
	@Test
	@DisplayName("Test update")
	void testupdate() throws AppointmentException {
		Appointment appointment = new Appointment();
		appointment.setAppointment_id(1);
		appointment.setUser_id(1);
		appointment.setTrainer_id(1);
		appointment.setTrainer_Preference("female");
		appointment.setPhy_the("yes");
		appointment.setAmount(1000);
		appointment.setLocation("pune");
		String appointmentDate="22-12-2020";
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate appointmentDate1= LocalDate.parse(appointmentDate, formatter);
		appointment.setDate(appointmentDate1);

		doReturn(Optional.of(appointment)).when(appointmentDataDao).findById(1);
		// Execute the service call
		Appointment returnedAppointment1 = appointmentService.getAppointmentById(1);
		Integer existing = returnedAppointment1.getAmount();
		returnedAppointment1.setAmount(2000);
		Integer e = appointmentService.addAppointment(returnedAppointment1);
		doReturn(appointment).when(appointmentDataDao).save( returnedAppointment1);
		doReturn(Optional.of(appointment)).when(appointmentDataDao).findById(1);
		// Execute the service call
		Appointment returnedAppointment2 = appointmentService.getAppointmentById(1);
		Integer present = returnedAppointment2.getAmount();
		boolean b;
		if(existing==present)	{
			b=false;
		}
		else {
			b=true;
		}
		Assertions.assertTrue(b,"Appointment updated");    	 
	}

	/*
	 * Delete Details
	 */
	@Test
	@DisplayName("Test delete")
	void testdelete() throws AppointmentException{
		Appointment appointment = new Appointment();
		appointment.setAppointment_id(1);
		appointment.setUser_id(1);
		appointment.setTrainer_id(1);
		appointment.setTrainer_Preference("female");
		appointment.setPhy_the("yes");
		appointment.setAmount(1000);
		appointment.setLocation("pune");
		String appointmentDate="22-12-2020";
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate appointmentDate1= LocalDate.parse(appointmentDate, formatter);
		appointment.setDate(appointmentDate1);

		doReturn(appointment).when(appointmentDataDao).save(appointment);
		Integer check =  appointmentService.addAppointment(appointment);		 
		// Execute the service call
		//doReturn(Optional.of(appointment)).when(appointmentDataDao).deleteById(1);	 
		appointmentService.deleteAppointment(1);
		Appointment returnedAppointment = appointmentService.getAppointmentById(1);
		Assertions.assertNull(returnedAppointment,"Appointment deleted");

	}
}
