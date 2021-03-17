package com.cg.healthcare.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DiagnosticCenter implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	private List<String> servicesOffered;
	private Set<DiagnosticTest> tests = new HashSet<>();
}
