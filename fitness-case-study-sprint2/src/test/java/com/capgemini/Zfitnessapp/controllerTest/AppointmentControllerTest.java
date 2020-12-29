package com.capgemini.Zfitnessapp.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
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
import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.capgemini.fitness.dao.AppointmentDataDao;
import com.capgemini.fitness.entity.Appointment;
import com.capgemini.fitness.service.AppointmentService;
import com.capgemini.fitnesscasestudysprint2.FitnessCaseStudySprint2Application;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FitnessCaseStudySprint2Application.class)
@AutoConfigureMockMvc 
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AppointmentControllerTest {

	@MockBean
	private AppointmentService service;
	 @Autowired
	    private MockMvc mvc;
	 @MockBean
	 private AppointmentDataDao repository;
	 
	 @BeforeEach
		public void resetDb() {
			repository.deleteAll();
		}
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	 
	 @Test
	    @DisplayName("POST /fitness/appointment")
	    void testCreatAppointment() throws Exception {
	        // Setup our mocked service
		 Appointment ap = new  Appointment(1,1,1,"female","yes",1000,"pune",LocalDate.parse("10/12/2020", formatter),null); 
	       mvc.perform(post("/fitness/appointment")
					.contentType(MediaType.APPLICATION_JSON)
					.content(JsonUtil.toJson(ap)));

			List<Appointment> found = repository.findAll();
			assertThat(found);
	 }
	       
	  
	 @Test
	    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
	        createTestAppointment(1);
	        createTestAppointment(2);

	        
	        mvc.perform(get("/fitness/appointment").contentType(MediaType.APPLICATION_JSON))
	          .andDo(print())
	          .andExpect(status().isOk())
	          .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	          .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
	          .andExpect(jsonPath("$[0].appointment_id", is(1)))
	          .andExpect(jsonPath("$[1].appointment_id", is(2)));
	        
	    }

	   private void createTestAppointment(Integer id) {
	        Appointment ap = new Appointment(id);
	        repository.saveAndFlush(ap);
	    }    
	 
	 
	
	
		

}