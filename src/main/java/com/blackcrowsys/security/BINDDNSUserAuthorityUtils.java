package com.blackcrowsys.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.blackcrowsys.domain.Role;
import com.blackcrowsys.domain.User;

/**
 * 
 * @author rahulsingh
 * 
 * A utility class to define the authorities of a user.
 * 
 */
public class BINDDNSUserAuthorityUtils {
	private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN",
            "ROLE_USER");
    private static final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    private static final List<GrantedAuthority> ANONYMOUS_ROLES = AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS");

    /**
     * Creates the authorities for a user.
     * 
     * @param user the user
     * @return collection of granted authorities
     */
    public static Collection<? extends GrantedAuthority> createAuthorities(User user) {
    	if (user.getRoles() != null) {
    		for (Role role : user.getRoles()) {
    			if (role.getAuthority().equals("ROLE_ADMIN")) {
    				return ADMIN_ROLES;
    			}
    		}
    		return USER_ROLES;
    	} else {
    		return ANONYMOUS_ROLES;
    	}
    }

    private BINDDNSUserAuthorityUtils() {
    }
}
