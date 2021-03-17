package com.cg.healthcare.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class DiagnosticTest implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String testName;
	private double testPrice;
	private String normalValue;
	private String units;	
	private Set<DiagnosticCenter> diagnosticCenters = new HashSet<>();
}
