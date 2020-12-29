package com.capgemini.Zfitnessapp.serviceTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capgemini.fitness.dao.UserDataDao;
import com.capgemini.fitness.entity.Role;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.UserException;
import com.capgemini.fitness.service.UserService;

@SpringBootTest
public class UserServiceTest  {
	@Autowired
	private UserService userService;
	@MockBean
	private UserDataDao  userDataDao;

	/*
	 * Add User test
	 */
	@Test
	@DisplayName("Test save user")
	public void testSave() throws UserException  {
		// Setup our mock repository
		User user = new User(1,"ankita","pansare","ankita@gmail.com","otur","india","maha","pune",412409,9960344815L,22,"ankita#12",Role.USER,null,null);
		doReturn(user).when(userDataDao).save(any());
		// Execute the service call
		Integer returnedUser =  userService.addUser(user);
		// Assert the response
		Assertions.assertNotNull(returnedUser, "The saved user should not be null");
	}
}