package com.blackcrowsys.domain;

import java.io.Serializable;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 7348403375702121366L;
	private Integer id;
	private Integer userId;
	private Integer roleId;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "role_id")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
