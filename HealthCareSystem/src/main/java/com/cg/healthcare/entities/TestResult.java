package com.cg.healthcare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TestResult implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double testReading;
	private String condition;
	@ManyToOne
	private Appointment appointment;
	
	public TestResult() {
		// TODO Auto-generated constructor stub
	}
	
	public TestResult(double testReading, String condition, Appointment appointment) {
		super();
		this.testReading = testReading;
		this.condition = condition;
		this.appointment = appointment;
	}
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