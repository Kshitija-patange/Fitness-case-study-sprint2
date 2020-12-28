package com.capgemini.fitness.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.fitness.dao.TrainerDataDao;
import com.capgemini.fitness.entity.Trainer;
import com.capgemini.fitness.exception.TrainerException;

@Service
@Transactional
public class TrainerServiceDataImpl implements TrainerService{
	@Autowired
	private TrainerDataDao trainerDataDaoImpl;

	/*
	 * Add trainer method
	 */
	@Override
	public Integer addTrainer(Trainer trainer) throws TrainerException {
		try {
			Trainer p= 
					trainerDataDaoImpl.save(trainer);
			System.out.println(p);
			return 1;
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
	/*
	 * Get Trainer details by id
	 */
	@Override
	public Trainer getTrainerById(Integer trainerId) throws TrainerException {
		try {
			Optional<Trainer> optional= 
					trainerDataDaoImpl.findById(trainerId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
	/*
	 * delete trainer
	 */
	@Override
	public Integer deleteTrainer(Integer trainerId) throws TrainerException {
		try {
			trainerDataDaoImpl.deleteById(trainerId);
			//return appointmentId;
			return 1;
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
	/*
	 * update trainer details
	 */
	@Override
	public Trainer updateTrainer(Trainer trainer) throws TrainerException {
		try {
			Trainer p= 
					trainerDataDaoImpl.save(trainer);
			return p;
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
}

