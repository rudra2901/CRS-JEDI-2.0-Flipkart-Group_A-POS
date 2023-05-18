/**
 * 
 */
package com.flipkart.bean;

/**
 * @author rudra.tiwari
 *
 */
public class User {
	
	private int userID;
	private String name;
	private String role;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
