package com.hpe.kevin.business.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class TUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5860388185936258405L;

	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;

	public TUser(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
