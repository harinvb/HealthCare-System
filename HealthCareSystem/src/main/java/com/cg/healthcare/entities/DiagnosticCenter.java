package com.cg.healthcare.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class DiagnosticCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int diagonasticCenterid;
	
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	@JsonIgnore
	@ManyToMany(mappedBy = "diagnosticCenters",cascade = CascadeType.ALL)
	private Set<DiagnosticTest> tests = new HashSet<>();
	
	public DiagnosticCenter() {
	}
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

	public Set<DiagnosticTest> getTests() {
		return tests;
	}
	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}
	
}
