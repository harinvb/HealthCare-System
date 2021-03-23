package com.cg.healthcare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class TestResult{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testResultid;
	private double testReading;
	private String testcondition;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Appointment appointment;
	
	
	
	public int getTestResultid() {
		return testResultid;
	}

	public void setTestResultid(int testResultid) {
		this.testResultid = testResultid;
	}

	public String getTestcondition() {
		return testcondition;
	}

	public void setTestcondition(String testcondition) {
		this.testcondition = testcondition;
	}

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