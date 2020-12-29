package com.capgemini.Zfitnessapp.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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


import com.capgemini.fitness.dao.AdminDataDao;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.entity.Role;
import com.capgemini.fitness.exception.AdminException;
import com.capgemini.fitness.service.AdminService;
import com.capgemini.fitnesscasestudysprint2.FitnessCaseStudySprint2Application;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FitnessCaseStudySprint2Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AdminControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private AdminDataDao repository;
	
	@Autowired
	private AdminService service;
	
	//@Autowired
	//private LearningActivityRepository learningRepository;
	
	@BeforeEach
	public void resetDb() {
		//learningRepository.deleteAll();
		repository.deleteAll();
	}

	@Test
	public void whenValidInput_thenCreateAdmin() throws IOException, Exception {
		Admin admin = new Admin(1,"pall", "pune", "abc@gmail.com",987654321L,"ankita@5",Role.ADMIN);
		mvc.perform(post("/fitness/admin/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(admin)));

		List<Admin> found = repository.findAll();
		assertThat(found);
		//.extracting(Admin::addAdmin()).containsOnly("Java");
	}

	
	@Test
    public void testFindById() throws AdminException {

        Admin admin = new Admin(1,"pall", "pune", "abc@gmail.com",987654321L,"ankita@5",Role.ADMIN);
        repository.save(admin);

       Optional<Admin> found = repository.findById(1);
       assertTrue(found.isPresent());
        
        
        Admin ad = found.get();
        assertEquals(1, ad.getAdmin_id());
    }
	
	
	
	/*
	  @Test 
	  public void givenAdmin_whenGetAdmin_thenStatus200() throws Exception,AdminException{
		  createTestAdmin("Pallavi"); 
	      //createTestAdmin("Teju");
	  
	  mvc.perform(get("/fitness/admin/").contentType(MediaType.APPLICATION_JSON))
	  .andDo(print()) .andExpect(status().isOk()) .andExpect(content()
	  .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	  .andExpect(jsonPath("$",hasSize(greaterThanOrEqualTo(1))))
	  .andExpect(jsonPath("$[1].admin_name", is("Pallavi")));
	 // .andExpect(jsonPath("$[1].admin_name", is("Teju")));
	  
	  }
	  
	  
	  private void createTestAdmin(String name) {
			Admin admin = new Admin(1,name, "pune", "abc@gmail.com",987654321L,"ankita@5",null);
	  //repository.saveAndFlush(admin); 
	  repository.save(admin);}
	 
	*/
}