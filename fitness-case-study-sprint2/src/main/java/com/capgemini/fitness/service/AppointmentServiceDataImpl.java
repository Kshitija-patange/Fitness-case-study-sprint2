package com.capgemini.fitness.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.fitness.dao.AppointmentDataDao;
import com.capgemini.fitness.entity.Appointment;
import com.capgemini.fitness.exception.AppointmentException;

@Service
@Transactional
public class AppointmentServiceDataImpl implements AppointmentService{
	@Autowired
	private AppointmentDataDao appointmentDataDaoImpl;
	/*
	 * Add Appointment
	 */
	@Override
	public Integer addAppointment(Appointment appointment) throws AppointmentException {
		try {
			Appointment p= 
					appointmentDataDaoImpl.save(appointment);
			System.out.println(p);
			return 1;
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}
	/*
	 * Get Appointment Details by using Id
	 */
	@Override
	public Appointment getAppointmentById(Integer appointmentId) throws AppointmentException {
		try {
			Optional<Appointment> optional= 
					appointmentDataDaoImpl.findById(appointmentId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}
	/*
	 * Delete Appointment
	 */
	@Override
	public Integer deleteAppointment(Integer appointmentId) throws AppointmentException {
		try {
			appointmentDataDaoImpl.deleteById(appointmentId);
			//return appointmentId;
			return 1;
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}
	/*
	 * View list of Appointment
	 */
	@Override
	public List<Appointment> viewAppointment() throws AppointmentException {
		try {
			List<Appointment> appointmentList=
					appointmentDataDaoImpl.findAll();
			return appointmentList;
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}
	/*
	 * update Appointment details
	 */
	@Override
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
		try {
			Appointment p= 
					appointmentDataDaoImpl.save(appointment);
			return p;
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}
}
