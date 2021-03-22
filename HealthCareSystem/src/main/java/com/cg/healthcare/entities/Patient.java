package com.cg.healthcare.entities;

import java.io.Serializable;


import java.util.HashSet;
import java.util.Set;
import com.cg.healthcare.entities.Appointment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Patient{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	private String name;
	private String phoneNo;
	private int age;
	private String gender;
	@OneToMany(mappedBy = "patient")
	private Set<Appointment> appointments;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public Patient(String name, String phoneNo, int age, String gender, Set<Appointment> appointments) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.age = age;
		this.gender = gender;
		this.appointments = appointments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

}
