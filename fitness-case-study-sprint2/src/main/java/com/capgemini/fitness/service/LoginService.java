package com.capgemini.fitness.service;
import com.capgemini.fitness.entity.LogOutPayload;
import com.capgemini.fitness.entity.Login;

public interface LoginService {
	/**
	 * Sign in user
	 * @param User
	 * @return sign in successful
	 * else throw invalid user
	 */
	public String signIn(Login user);

	/**
	 * Sign out 
	 * @param user
	 * @return sign out successful
	 */
	public String signOut(LogOutPayload user);

	/**
	 * Change Password
	 * @param user
	 * @param new_password
	 * @return changed password
	 */
	public String changePassword(Login user, String new_password);
}