package com.blackcrowsys.dataaccess.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.blackcrowsys.domain.User;

public interface UserDao {

	/**
	 * Find all users in the database.
	 * 
	 * @return list of users
	 */
	@Transactional(readOnly = true)
	public List<User> findAllUsers();

	/**
	 * Find a user by a given id.
	 * 
	 * @param id user id
	 * @return User user
	 */
	@Transactional(readOnly = true)
	public User findUser(Integer id);

	/**
	 * Find user by the username.
	 * 
	 * @param username the username to be searched
	 * @return User user
	 */
	@Transactional(readOnly = true)
	public User findUser(String username);

	/**
	 * Save a user.
	 * 
	 * @param user the user
	 */
	@Transactional
	public void saveUser(User user);

	/**
	 * Delete a user from the database.
	 * 
	 * @param user the user
	 */
	@Transactional
	public void deleteUser(User user);

}
