package com.capgemini.Zfitnessapp.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.util.List;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.fitness.dao.UserDataDao;
import com.capgemini.fitness.entity.Role;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.service.UserService;
import com.capgemini.fitnesscasestudysprint2.FitnessCaseStudySprint2Application;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FitnessCaseStudySprint2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class UserControllerTest {
	
	private MockMvc mvc;

	@Autowired
	private UserDataDao repository;
	
	@Autowired
	private UserService service;

	@BeforeEach
	public void resetDb() {
		repository.deleteAll();
	}
	
	
	@Test
	 @DisplayName("POST /fitness/user")
	public void CreateUser() throws IOException, Exception {
		User us = new User(1,"pallavi","badhe","abc@gmail.com","pune","india","maharashtra","pune",412412,987654321L,22,"ankita@15",Role.USER,null,null);
		mvc.perform(post("/fitness/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(us)));

		List<User> found = repository.findAll();
		assertThat(found);
	}

   
}
