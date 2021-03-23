package com.cg.healthcare.entities;

public enum AppointmentStatus {

	statusnotapproved("statusnotapproved"),approved("approved"),cancelled("cancelled");
	private String status;
	AppointmentStatus(String status ) {
		this.setStatus(status);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
