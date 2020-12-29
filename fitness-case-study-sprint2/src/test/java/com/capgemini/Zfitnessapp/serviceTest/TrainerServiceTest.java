package com.capgemini.Zfitnessapp.serviceTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capgemini.fitness.dao.TrainerDataDao;
import com.capgemini.fitness.entity.Role;
import com.capgemini.fitness.entity.Trainer;
import com.capgemini.fitness.exception.TrainerException;
import com.capgemini.fitness.service.TrainerService;

@SpringBootTest
public class TrainerServiceTest  {
	@Autowired
	private TrainerService trainerService;
	@MockBean
	private TrainerDataDao  trainerDataDao;

	/*
	 * Add Trainer test
	 */
	@Test
	@DisplayName("Test save Trainer")
	public void testSave() throws TrainerException  {
		// Setup our mock repository
		Trainer trainer = new Trainer(1,"ankita","ankita@gmail.com","otur",9960344815L,"asxdx@gmail.com",Role.TRAINER,null);
		doReturn(trainer).when(trainerDataDao).save(any());
		// Execute the service call
		Integer returnedTrainer=  trainerService.addTrainer(trainer);
		// Assert the response
		Assertions.assertNotNull(returnedTrainer, "The saved Trainer should not be null");
	}
}
