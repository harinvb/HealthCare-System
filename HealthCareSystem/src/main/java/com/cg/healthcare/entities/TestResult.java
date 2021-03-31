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
	
	public TestResult() {
	}
	
	/**
	 * @param testReading
	 * @param condition
	 * @param appointment
	 */
	public TestResult(double testReading, String condition, Appointment appointment) {
		super();
		this.testReading = testReading;
		this.testcondition = condition;
		this.appointment = appointment;
	}
	
	
	
	/** 
	 * @return int
	 */
	public int getTestResultid() {
		return testResultid;
	}

	
	/** 
	 * @param testResultid
	 */
	public void setTestResultid(int testResultid) {
		this.testResultid = testResultid;
	}

	
	/** 
	 * @return String
	 */
	public String getTestcondition() {
		return testcondition;
	}

	
	/** 
	 * @param testcondition
	 */
	public void setTestcondition(String testcondition) {
		this.testcondition = testcondition;
	}

	
	/** 
	 * @return double
	 */
	public double getTestReading() {
		return testReading;
	}
	
	/** 
	 * @param testReading
	 */
	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}
	
	/** 
	 * @return String
	 */
	public String getCondition() {
		return testcondition;
	}
	
	
	/** 
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.testcondition = condition;
	}
	
	/** 
	 * @return Appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}
	
	/** 
	 * @param appointment
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}	
}