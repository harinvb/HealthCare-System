package com.cg.healthcare.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

import com.cg.healthcare.exception.InvalidAppointmentStatusException;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Appointment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonFormat(pattern = "dd-MMM-YYYY")
	private LocalDate appointmentDate;
	private AppointmentStatus approvalStatus;
	@OneToMany
	private Set<DiagnosticTest> diagnosticTests; 
	private Patient patient;
	private DiagnosticCenter diagnosticCenter;
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public AppointmentStatus getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(AppointmentStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public Set<DiagnosticTest> getDiagnosticTests() {
		return diagnosticTests;
	}
	public void setDiagnosticTests(Set<DiagnosticTest> diagnosticTests) {
		this.diagnosticTests = diagnosticTests;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}
	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
	public Set<TestResult> getTestResult() {
		return testResult;
	}
	public void setTestResult(Set<TestResult> testResult) {
		this.testResult = testResult;
	}
	private Set<TestResult> testResult;
	
}