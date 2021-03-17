package com.cg.healthcare.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	private int patientId;
	private String name;
	private String phoneNo;
	private int age;
	private String gender;
	private Set<Appointment> appointments=new HashSet<>();

}
