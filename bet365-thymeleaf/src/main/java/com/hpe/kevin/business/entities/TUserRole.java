package com.hpe.kevin.business.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_user_role")
public class TUserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2829846390387032254L;
	
	@Id
	@Column(name="user_role_id")
	private int userRoleId;
	
	@OneToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	private TUser user;
	
	@Column(name="user_role")
	private String userRole;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public TUserRole() {
		super();
	}

	public TUserRole(int userRoleId, TUser user, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.userRole = userRole;
	}
}
