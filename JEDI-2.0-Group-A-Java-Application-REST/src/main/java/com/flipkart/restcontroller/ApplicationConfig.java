package com.flipkart.restcontroller;

import org.glassfish.jersey.server.ResourceConfig;


/**
 * @author Group-A
 * Aaryan Pawar
 * Harsh Garg
 * Pulkit Bhargava
 * Rudra Tiwari
 * Shruti Sharma
 * Vedant Patel
 *
 */


public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

	register(StudentRestAPI.class);
	register(UserRestAPI.class);
	register(ProfessorRestAPI.class);
	register(AdminRestAPI.class);

	}

}