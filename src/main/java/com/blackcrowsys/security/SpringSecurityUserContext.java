package com.blackcrowsys.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.blackcrowsys.domain.User;

/**
 *
 * @author rahulsingh
 *
 * Maintains details of the current user.
 *
 */
@Component
public class SpringSecurityUserContext implements UserContext {

	/**
	 * Get the current user using the context of the
	 * Spring application.
	 *
	 * @return User the user
	 */
	public User getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (User) authentication.getPrincipal();
	}

	/**
	 * Set the current user to the context of the
	 * application.
	 *
	 * @param user the user
	 */
	public void setCurrentUser(User user) {
		Collection authorities = BINDDNSUserAuthorityUtils
				.createAuthorities(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword(), authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
