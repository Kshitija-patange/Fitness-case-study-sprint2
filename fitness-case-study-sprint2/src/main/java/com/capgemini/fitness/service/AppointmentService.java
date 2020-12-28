package com.capgemini.fitness.service;
import java.util.List;
import com.capgemini.fitness.entity.Appointment;
import com.capgemini.fitness.exception.AppointmentException;

public interface AppointmentService {
	public Integer addAppointment(Appointment appointment) throws AppointmentException;
	public List<Appointment> viewAppointment() throws AppointmentException;
	public Appointment getAppointmentById(Integer appointment_id) throws  AppointmentException;
	public Integer deleteAppointment(Integer appointment_id) throws AppointmentException;
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException;
}
