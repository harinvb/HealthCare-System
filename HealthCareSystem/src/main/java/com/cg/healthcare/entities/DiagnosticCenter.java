package com.cg.healthcare.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
/************************************************************************************
 *          @author          	Sai Pavan Gajjela
 *          Description      	It is a basic POJO class that is used to initialize variables, 
 *          				 	define relationships with other entity classes. It consists of
 *          				 	Constructors and Getters, Setters. 
  *         Version             1.0
  *         Created Date    	30-MAR-2021
 ************************************************************************************/


@Entity
@DynamicUpdate
public class DiagnosticCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int diagonasticCenterid;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	@JsonIgnore
	@OneToMany(mappedBy = "diagnosticCenter",cascade = CascadeType.ALL)
	private Set<DiagnosticTest> tests = new HashSet<>();

	/************************************************************************************
		 * Method: 						DiagnosticCenter
	     * Description: 				To initialize objects of class. Called when an object of class is called.
		 * @param name       - 			Diagnostic Center Name
		 * @param contactNo            	Diagnostic Center contact number
		 * @param address              	Diagnostic Center Address
		 * @param contactEmail			Diagnostic Center mail Id
		 * @param tests					Tests in Diagnostic Center
	     * Created By                  	Sai Pavan Gajjela
	     * Created Date                  30-MAR-2021                           
		 
		 ************************************************************************************/
	public DiagnosticCenter() {
	}
	public DiagnosticCenter(String name, String contactNo, String address, String contactEmail,
			Set<DiagnosticTest> tests) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.contactEmail = contactEmail;
		this.tests = tests;
	}
	/************************************************************************************
	 * Method: 						getDiagonasticCenterid
     * Description: 				To get diagnostic center Id.
	 * @returns						diagonasticCenterid.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public int getDiagonasticCenterid() {
		return diagonasticCenterid;
	}
	/************************************************************************************
	 * Method: 						setDiagonasticCenterid
     * Description: 				To set diagnostic center Id.
	 * @returns						void.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public void setDiagonasticCenterid(int diagonasticCenterid) {
		this.diagonasticCenterid = diagonasticCenterid;
	}
	
	/************************************************************************************
	 * Method: 						getName
     * Description: 				To get diagnostic center Name.
	 * @returns						diagonasticCenter Name.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public String getName() {
		return name;
	}
	/************************************************************************************
	 * Method: 						setName
     * Description: 				To set diagnostic center name.
	 * @returns						void.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public void setName(String name) {
		this.name = name;
	}
	/************************************************************************************
	 * Method: 						getContactNo
     * Description: 				To get diagnostic center contact number.
	 * @returns						diagonasticCenter Contact number.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public String getContactNo() {
		return contactNo;
	}
	/************************************************************************************
	 * Method: 						setContactNo
     * Description: 				To set diagnostic center contact number.
	 * @returns						void.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/************************************************************************************
	 * Method: 						getAddress
     * Description: 				To get diagnostic center address.
	 * @returns						diagonasticCenter address.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public String getAddress() {
		return address;
	}
	/************************************************************************************
	 * Method: 						setAddress
     * Description: 				To set diagnostic center address.
	 * @returns						void.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public void setAddress(String address) {
		this.address = address;
	}
	/************************************************************************************
	 * Method: 						getContactEmail
     * Description: 				To get diagnostic center email id.
	 * @returns						diagonasticCenter email id.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public String getContactEmail() {
		return contactEmail;
	}
	/************************************************************************************
	 * Method: 						setContactEmail
     * Description: 				To set diagnostic center mail id.
	 * @returns						void.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/************************************************************************************
	 * Method: 						getTests
     * Description: 				To get set of diagnostic center tests.
	 * @returns						diagonasticCenter tests.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/

	public Set<DiagnosticTest> getTests() {
		return tests;
	}
	/************************************************************************************
	 * Method: 						setTests
     * Description: 				To set diagnostic center tests.
	 * @returns						void.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                            
	 ************************************************************************************/
	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}
	
}
