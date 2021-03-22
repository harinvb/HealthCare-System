package com.cg.healthcare.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;


public class DiagnosticTest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String testName;
	private double testPrice;
	private String normalValue;
	private String units;
	@ManyToMany
	private Set<DiagnosticCenter> diagnosticCenters = new HashSet<>();
	
	
	public DiagnosticTest(String testName, double testPrice, String normalValue, String units,
			Set<DiagnosticCenter> diagnosticCenters) {
		super();
		this.testName = testName;
		this.testPrice = testPrice;
		this.normalValue = normalValue;
		this.units = units;
		this.diagnosticCenters = diagnosticCenters;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}

	public String getNormalValue() {
		return normalValue;
	}

	public void setNormalValue(String normalValue) {
		this.normalValue = normalValue;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Set<DiagnosticCenter> getDiagnosticCenters() {
		return diagnosticCenters;
	}

	public void setDiagnosticCenters(Set<DiagnosticCenter> diagnosticCenters) {
		this.diagnosticCenters = diagnosticCenters;
	}
	
	
}
