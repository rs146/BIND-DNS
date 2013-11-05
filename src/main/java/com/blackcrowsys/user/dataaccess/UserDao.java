package com.blackcrowsys.user.dataaccess;

import java.util.List;

import com.blackcrowsys.domain.User;

public interface UserDao {

	/**
	 * Find all users in the database.
	 * 
	 * @return list of users
	 */
	public List<User> findAllUsers();

	/**
	 * Find a user by a given id.
	 * 
	 * @param id user id
	 * @return User user
	 */
	public User findUser(Integer id);

	/**
	 * Find user by the username.
	 * 
	 * @param username the username to be searched
	 * @return User user
	 */
	public User findUser(String username);

	/**
	 * Save or update user.
	 * 
	 * @param user the user
	 */
	public void saveOrUpdateUser(User user);

	/**
	 * Delete a user from the database.
	 * 
	 * @param user the user
	 */
	public void deleteUser(User user);

}
