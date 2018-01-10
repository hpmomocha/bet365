package com.hpe.kevin.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy="tUser", cascade = CascadeType.ALL)
	// mappedBy indicates the entity is the inverse of the relationship.
	private Set<TOrder> orders = new HashSet<TOrder>();

	public TUser() {
	}

	public TUser(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public TUser(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

//	public Set<TOrder> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<TOrder> orders) {
//		this.orders = orders;
//	}
}
