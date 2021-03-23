package com.cg.healthcare.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


//import com.cg.healthcare.exception.InvalidAppointmentStatusException;

@Entity
public class Appointment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentid;
	
//	@JsonFormat(pattern = "dd-MM-YYYY",shape = Shape.STRING)
	private LocalDate appointmentDate;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus approvalStatus;
	
//	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<DiagnosticTest> diagnosticTests = new HashSet<>();
	
//	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patient;
	
//	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private DiagnosticCenter diagnosticCenter;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "appointment",cascade = CascadeType.ALL)
	private Set<TestResult> testResult = new HashSet<>();
	
	
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
	
	
}