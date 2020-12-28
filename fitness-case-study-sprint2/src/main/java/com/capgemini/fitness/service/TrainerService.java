package com.capgemini.fitness.service;
import com.capgemini.fitness.entity.Trainer;
import com.capgemini.fitness.exception.TrainerException;

public interface TrainerService {
	public Integer addTrainer(Trainer trainer) throws  TrainerException;
	public Trainer getTrainerById(Integer trainer_id) throws  TrainerException;
	public Integer deleteTrainer(Integer trainer_id) throws TrainerException;
	public Trainer updateTrainer(Trainer trainer) throws TrainerException;
}
