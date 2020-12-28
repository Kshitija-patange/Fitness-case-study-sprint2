package com.capgemini.fitness.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.fitness.dao.LoginRepository;
import com.capgemini.fitness.entity.LogOutPayload;
import com.capgemini.fitness.entity.Login;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.OperationFailedException;
import com.capgemini.fitness.exception.ResourceNotFound;
import static com.capgemini.fitness.exception.AppConstants.OPERATION_FAILED;
import static com.capgemini.fitness.exception.AppConstants.USER_NOT_FOUND;
import static com.capgemini.fitness.exception.AppConstants.WRONG_PASSWORD;
import java.util.Optional;

/*
 * @Service annotation is used to mark the class as a service provider
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired 
	private LoginRepository loginRepository;

	/*
	 * Signin the log in page  using Id and the password
	 */
	@Override
	public String signIn(Login user) {
		String str = null;
		Optional<User> userObj = loginRepository.findById(user.getId());
		if (!userObj.isPresent()) {
			System.out.println(userObj);
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = userObj.get().getPassword();
			if (!pwd.equals(user.getPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				str = "Sign in sucessfull";
				loginRepository.saveAndFlush(userObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}

	/*
	 * signout the page  using UserId and the password
	 */
	@Override
	public String signOut(LogOutPayload user) {
		String str = null;
		Optional<User> userObj = loginRepository.findById(1);
		if (!userObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			try {
				str = "Sign Out sucessfull";
				loginRepository.saveAndFlush(userObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}
	/*
	 * reset password
	 */
	@Override
	public String changePassword(Login user, String new_password) {
		String str = null;
		Optional<User> userObj = loginRepository.findById(user.getId());
		if (!userObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = userObj.get().getPassword();
			if (!pwd.equals(user.getPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				userObj.get().setPassword(new_password);
				loginRepository.saveAndFlush(userObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}
}