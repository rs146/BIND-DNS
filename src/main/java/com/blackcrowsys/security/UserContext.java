package com.blackcrowsys.security;

import com.blackcrowsys.domain.User;

/**
 * 
 * @author rahulsingh
 * 
 * Manages the current user.
 */
public interface UserContext {

	/**
	 * Get the current user.
	 * 
	 * @return user the user
	 */
	public User getCurrentUser();

	/**
	 * Set the current user.
	 * 
	 * @param user the user
	 */
	public void setCurrentUser(User user);
}
