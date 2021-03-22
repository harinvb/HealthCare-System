package com.cg.healthcare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class TestResult{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testResultid;
	private double testReading;
	private String testcondition;
	@ManyToOne
	private Appointment appointment;
	
	public TestResult() {
	}
	
	public TestResult(double testReading, String condition, Appointment appointment) {
		super();
		this.testReading = testReading;
		this.testcondition = condition;
		this.appointment = appointment;
	}
	public double getTestReading() {
		return testReading;
	}
	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}
	public String getCondition() {
		return testcondition;
	}
	public void setCondition(String condition) {
		this.testcondition = condition;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}	
}