package com.cg.healthcare.entities;

import java.io.Serializable;



public class TestResult implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private double testReading;
	private String condition;
	private Appointment appointment;	
}