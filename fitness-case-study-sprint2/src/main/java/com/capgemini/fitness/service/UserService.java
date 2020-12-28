package com.capgemini.fitness.service;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.UserException;

public interface UserService {
	public Integer addUser(User user) throws  UserException;
	public User getUserById(Integer user_id) throws  UserException;
	public Integer deleteUser(Integer user_id) throws UserException;
	public User updateUser(User user) throws UserException;

}
