package com.cg.healthcare.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String password;
	private String role;
	
	User(){
		
	}
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	/** 
	 * @return int
	 */
	public int getUserid() {
		return userid;
	}
	
	/** 
	 * @param userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	/** 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	
	/** 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/** 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/** 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** 
	 * @return String
	 */
	public String getRole() {
		return role;
	}
	
	/** 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
}
