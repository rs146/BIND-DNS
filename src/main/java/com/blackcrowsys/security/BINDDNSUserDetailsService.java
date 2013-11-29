package com.blackcrowsys.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blackcrowsys.dataaccess.user.UserDao;
import com.blackcrowsys.domain.User;

/**
 * 
 * @author rahulsingh
 * 
 * Service class that detects a user and authenticates 
 * whether a user is trusted or not.
 * 
 */
@Service("userDetailsService")
public class BINDDNSUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/**
	 * Load the user.
	 * 
	 * @param username the username
	 * @return userdetails spring user details
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findUser(username);
		if (user == null) {
			throw new UsernameNotFoundException(
					"Invalid username/password combination");
		}
		return new BINDDNSUserDetails(user);
	}

	/**
	 * 
	 * @author rahulsingh
	 * 
	 * Translation of our domain class User 
	 * and Spring Security's class UserDetails.
	 * 
	 */
	public final class BINDDNSUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = -7858491733256253841L;

		BINDDNSUserDetails(User user) {
			setId(user.getId());
			setUsername(user.getUsername());
			setPassword(user.getPassword());
			setRoles(user.getRoles());
		}

		public Collection<? extends GrantedAuthority> getAuthorities() {
			return BINDDNSUserAuthorityUtils.createAuthorities(this);
		}

		public boolean isAccountNonExpired() {
			return true;
		}

		public boolean isAccountNonLocked() {
			return true;
		}

		public boolean isCredentialsNonExpired() {
			return true;
		}

		public boolean isEnabled() {
			return true;
		}
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
