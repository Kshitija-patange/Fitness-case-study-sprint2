package com.capgemini.fitness.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.capgemini.fitness.entity.Appointment;
import com.capgemini.fitness.exception.AppointmentException;
import com.capgemini.fitness.service.AppointmentService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fitness/appointment")
public class AppointmentNewController {

	@Autowired
	private AppointmentService appointmentService;

	/*
	 * http://localhost:8081/fitness/appointment/ add Appointment
	 */
	@ApiOperation(value = "Add appointment",
			consumes = "receives appointment object as Request body",
			response = String.class,
			httpMethod = "POST"
			)
	@PostMapping("/")
	public String addAppointment(@RequestBody Appointment appointment) {
		try {
			Integer status = appointmentService.addAppointment(appointment);
			if (status == 1) {
				return "Appointment:" + appointment.getAppointment_id() + " added to database";
			} else {
				return "Unable to add Appointment to database";
			}

		} catch (AppointmentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*
	 * get user by Id //http://localhost:8081/fitness/appointment/1
	 */ 
	@ApiOperation(value = "Get appointment by Id",
			response = Appointment.class,
			tags = "get-appointment",
			consumes = "appointment_id",
			httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer id) {
		try {
			Appointment appointment = appointmentService.getAppointmentById(id);
			return new ResponseEntity<>(appointment, HttpStatus.OK);
		} catch (AppointmentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*
	 *  http://localhost:8081/fitness/appointment/1 delete appointment
	 */
	@ApiOperation(value = "Delete appointment",
			consumes = "appointment id",
			response = String.class,
			httpMethod = "DELETE")
	@DeleteMapping("/{id}") public String deleteAppointment(@PathVariable Integer id) {
		try { Integer status= appointmentService.deleteAppointment(id);
		if(status ==1) {
			return "Appointment: "+id+" deleted from database"; }
		else {
			return"Unable to delete Appointment from database"; }

		}catch(AppointmentException e) { throw new
			ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }


	/*
	 * get all Appointment //http://localhost:8081/fitness/appointment/
	 */
	@ApiOperation(value = "Get all appointment",
			response = Appointment.class,
			tags = "get-all-appointments",			
			httpMethod = "GET")
	@GetMapping("/") public ResponseEntity<List<Appointment>> viewAppointment(){ try {
		List<Appointment> appointmentList = appointmentService.viewAppointment();
		return new ResponseEntity<>(appointmentList,HttpStatus.OK); }catch(AppointmentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }

	/*
	 * update appointment //http://localhost:8081/fitness/user/ update product
	 */  
	@ApiOperation(value = "Update appointment",
			consumes = "appointment object sent as request body",
			response = Appointment.class,
			httpMethod = "PUT")
	@PutMapping("/") public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) { 
		try { 
			Appointment updatedAppointment= appointmentService.updateAppointment(appointment);
			return new ResponseEntity<>(updatedAppointment,HttpStatus.OK);

		}catch(AppointmentException e) { 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		} 
	}
}

