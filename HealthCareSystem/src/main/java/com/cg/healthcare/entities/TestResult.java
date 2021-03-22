package com.cg.healthcare.entities;

import java.io.Serializable;



public class TestResult implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private double testReading;
	private String condition;
	private Appointment appointment;
	public double getTestReading() {
		return testReading;
	}
	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}	
}