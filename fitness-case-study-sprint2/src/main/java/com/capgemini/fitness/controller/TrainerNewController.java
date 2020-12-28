package com.capgemini.fitness.controller;


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
import com.capgemini.fitness.entity.Trainer;
import com.capgemini.fitness.exception.TrainerException;
import com.capgemini.fitness.service.TrainerService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fitness/trainer")
public class TrainerNewController {
	@Autowired
	private TrainerService trainerService;

	/*
	 * http://localhost:8081/fitness/trainer/ add trainer
	 */
	@ApiOperation(value = "Add trainer",
			consumes = "receives trainer object as Request body",
			response = String.class,
			httpMethod = "POST"
			)
	@PostMapping("/")
	public String addTrainer(@RequestBody Trainer trainer) {
		try {
			Integer status = trainerService.addTrainer(trainer);
			if (status == 1) {
				return "trainer:" + trainer.getTrainerName()+ " added to database";
			} else {
				return "Unable to add trainer to database";
			}
		} catch (TrainerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*
	 * get trainer by Id //http://localhost:8081/fitness/trainer/1
	 */ 
	@ApiOperation(value = "Get trainer by Id",
			response = Trainer.class,
			tags = "get-trainer",
			consumes = "trainerId",
			httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable Integer id) {
		try {
			Trainer trainer = trainerService.getTrainerById(id);
			return new ResponseEntity<>(trainer, HttpStatus.OK);
		} catch (TrainerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*
	 * http://localhost:8081/fitness/appointment/1 delete appointment
	 */
	@ApiOperation(value = "Delete trainer",
			consumes = "trainer id",
			response = String.class,
			httpMethod = "DELETE")
	@DeleteMapping("/{id}") 
	public String deleteTrainer(@PathVariable Integer id) {
		try { 
			Integer status= trainerService.deleteTrainer(id);
			if(status ==1) {
				return "Trainer: "+id+" deleted from database";
			}else {
				return"Unable to delete Trainer from database";
			}
		}catch(TrainerException e) { 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		} 
	}

	/*
	 * http://localhost:8081/fitness/user/ update product
	 */ 
	@ApiOperation(value = "Update trainer",
			consumes = "trainer object sent as request body",
			response = Trainer.class,
			httpMethod = "PUT")
	@PutMapping("/") 
	public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) { 
		try { 
			Trainer updatedTrainer= trainerService.updateTrainer(trainer);
			return new ResponseEntity<>(updatedTrainer,HttpStatus.OK);

		}catch(TrainerException e) { 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		} 
	}
}

