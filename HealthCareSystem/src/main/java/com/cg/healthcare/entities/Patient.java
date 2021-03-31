package com.cg.healthcare.entities;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Patient{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	private String name;
	private String phoneNo;
	private int age;
	private String gender;
	@JsonIgnore
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
	private Set<Appointment> appointments = new HashSet<>();
	
	
	/** 
	 * @return int
	 */
	public int getPatientId() {
		return patientId;
	}
	
	/** 
	 * @param patientId
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public Patient() {
		
	}
	/**
	 * @param name
	 * @param phoneNo
	 * @param age
	 * @param gender
	 * @param appointments
	 */
	public Patient(String name, String phoneNo, int age, String gender, Set<Appointment> appointments) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.age = age;
		this.gender = gender;
		this.appointments = appointments;
	}
	
	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * @return String
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
	/** 
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/** 
	 * @return int
	 */
	public int getAge() {
		return age;
	}
	
	/** 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/** 
	 * @return String
	 */
	public String getGender() {
		return gender;
	}
	
	/** 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/** 
	 * @return Set<Appointment>
	 */
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	
	/** 
	 * @param appointments
	 */
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

}
