/**
 * 
 */
package com.flipkart.service;

/**
 * @author pulkit.bhargava
 *
 */
public interface AdminOperationInterface {
	public void addProff() ;
	public void addCourse();
	public void dropCourse();
	public void assignCource();
	public void approveStudent();
	public void generateGradecard();
	public void sendNotification();
}
