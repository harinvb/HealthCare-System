package com.cg.healthcare.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

@Entity
public class DiagnosticCenter implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	private List<String> servicesOffered;
	private Set<DiagnosticTest> tests = new HashSet<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public List<String> getServicesOffered() {
		return servicesOffered;
	}
	public void setServicesOffered(List<String> servicesOffered) {
		this.servicesOffered = servicesOffered;
	}
	public Set<DiagnosticTest> getTests() {
		return tests;
	}
	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}
	
}
