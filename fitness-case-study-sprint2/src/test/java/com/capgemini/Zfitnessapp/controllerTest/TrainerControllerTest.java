package com.capgemini.Zfitnessapp.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.capgemini.fitness.dao.TrainerDataDao;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.entity.Role;
import com.capgemini.fitness.entity.Trainer;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.TrainerException;
import com.capgemini.fitness.service.TrainerService;
import com.capgemini.fitnesscasestudysprint2.FitnessCaseStudySprint2Application;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes =FitnessCaseStudySprint2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TrainerControllerTest {
	@Autowired
	private MockMvc mvc;

	//@Autowired
	@MockBean
	private TrainerDataDao repository;
	
	@Autowired
	private TrainerService service;

	@BeforeEach
	public void resetDb() {
		repository.deleteAll();
	}
	
	@Test
	 @DisplayName("POST /fitness/trainer")
	public void CreateTrainer() throws IOException, Exception {
		Trainer trainer = new Trainer(1,"pallavi","abc@gmail.com","pune",987654321L,"ankita@15",Role.TRAINER,null);
		mvc.perform(post("/fitness/trainer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(trainer)));

		List<Trainer> found = repository.findAll();
		assertThat(found);
	}
	
	
	 @Test
	   public void deleteTrainerById() throws TrainerException {
		 Trainer trainer = new Trainer(1,"pallavi","abc@gmail.com","pune",987654321L,"ankita@15",Role.TRAINER,null);
		 service.deleteTrainer(trainer.getTrainerId());
		 verify(repository,times(1)).deleteById(trainer.getTrainerId());
	 }
	 
	 @Test
	 public void testFindById() throws TrainerException {
		 Trainer trainer = new Trainer(1,"pallavi","abc@gmail.com","pune",987654321L,"ankita@15",Role.TRAINER,null);
		// repository.save(trainer);
		 service.addTrainer(trainer);
		 
		 //Optional<Trainer> found = repository.findById(1);
		 Trainer t = service.getTrainerById(1);
		// assertTrue(found.isPresent());
		 assertThat(t);

		 //Trainer tr = found.get();
		 assertEquals(1,t.getTrainerId());
	 }

}
