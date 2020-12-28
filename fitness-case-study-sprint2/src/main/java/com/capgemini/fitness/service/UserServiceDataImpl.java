package com.capgemini.fitness.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.fitness.dao.UserDataDao;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.UserException;

@Service
@Transactional
public class UserServiceDataImpl implements UserService{
	@Autowired
	private UserDataDao userDataDaoImpl;

	/*
	 * Add User 
	 */
	@Override
	public Integer addUser(User user) throws UserException {
		try {
			User p= 
					userDataDaoImpl.save(user);
			System.out.println(p);
			return 1;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	/*
	 * Get User details
	 */
	@Override
	public User getUserById(Integer userId) throws UserException {
		try {
			Optional<User> optional= 
					userDataDaoImpl.findById(userId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	/*
	 * delete user
	 */
	@Override
	public Integer deleteUser(Integer userId) throws UserException {
		try {
			userDataDaoImpl.deleteById(userId);
			//return appointmentId;
			return 1;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	/*
	 * Update user details
	 */
	@Override
	public User updateUser(User user) throws UserException {
		try {
			User p= 
					userDataDaoImpl.save(user);
			return p;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
}

