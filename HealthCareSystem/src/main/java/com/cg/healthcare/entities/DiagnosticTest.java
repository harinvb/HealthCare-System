package com.cg.healthcare.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DiagnosticTest{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int diagonasticTestid;
	private String testName;
	private double testPrice;
	private String normalValue;
	private String units;
	
	@JsonIgnore
	@ManyToOne
	private DiagnosticCenter diagnosticCenter;
	
	
	public DiagnosticTest() {
		
	}
	public DiagnosticTest(String testName, double testPrice, String normalValue, String units,
			DiagnosticCenter diagnosticCenter) {
		super();
		this.testName = testName;
		this.testPrice = testPrice;
		this.normalValue = normalValue;
		this.units = units;
		this.diagnosticCenter = diagnosticCenter;
	}

	
	/** 
	 * @return String
	 */
	public String getTestName() {
		return testName;
	}

	
	/** 
	 * @param testName
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	
	/** 
	 * @return double
	 */
	public double getTestPrice() {
		return testPrice;
	}

	
	/** 
	 * @param testPrice
	 */
	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}

	
	/** 
	 * @return String
	 */
	public String getNormalValue() {
		return normalValue;
	}

	
	/** 
	 * @param normalValue
	 */
	public void setNormalValue(String normalValue) {
		this.normalValue = normalValue;
	}

	
	/** 
	 * @return String
	 */
	public String getUnits() {
		return units;
	}

	
	/** 
	 * @param units
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	
	/** 
	 * @return DiagnosticCenter
	 */
	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	
	/** 
	 * @param diagnosticCenter
	 */
	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
	
	/** 
	 * @return int
	 */
	public int getDiagonasticTestid() {
		return diagonasticTestid;
	}
	
	/** 
	 * @param diagonasticTestid
	 */
	public void setDiagonasticTestid(int diagonasticTestid) {
		this.diagonasticTestid = diagonasticTestid;
	}
	
	
}
