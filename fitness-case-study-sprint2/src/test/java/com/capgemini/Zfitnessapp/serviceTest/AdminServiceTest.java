package com.capgemini.Zfitnessapp.serviceTest;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;





import com.capgemini.fitness.dao.AdminDataDao;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.entity.Role;
import com.capgemini.fitness.exception.AdminException;
import com.capgemini.fitness.service.AdminService;

@SpringBootTest
public class AdminServiceTest  {
	@Autowired
	private AdminService adminService;
	@MockBean
	private AdminDataDao  adminDataDao;

	/*
	 * Add Admin test
	 */
	@Test
	@DisplayName("Test save admin")
	public void testSave() throws AdminException  {
		// Setup our mock repository
		Admin admin = new Admin(1,"pall", "pune", "abc@gmail.com",987654321L,"ankita@5",Role.ADMIN);   
		doReturn(admin).when(adminDataDao).save(any());
		// Execute the service call
		Integer returnedAdmin =  adminService.addAdmin(admin);
		// Assert the response
		Assertions.assertNotNull(returnedAdmin, "The saved widget should not be null");
	}
	/*
	 * Get by id test
	 */
	@Test
	@DisplayName("Test findById Success")
	void testFindById() throws AdminException {
		// Setup our mock repository
		Admin admin = new Admin(1,"pall", "pune", "abc@gmail.com",987654321L,"ankita@5",Role.ADMIN);
		doReturn(Optional.of(admin)).when(adminDataDao).findById(1);
		// Execute the service call
		Admin returnedAdmin = adminService.getAdminById(1);
		boolean a;
		if(returnedAdmin!=null) {
			a=true;}
		else {
			a=false;}
		Assertions.assertTrue(a, "Admin was  found");        
	}
}