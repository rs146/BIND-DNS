package com.blackcrowsys.domain;

import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author rahulsingh
 * Entity class for users in the database. Database - BIND_DB
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1794281823969368244L;
	private Integer id;
	private String login;
	private String password;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
