package com.cg.healthcare.entities;

/************************************************************************************
 *          @author          	Nalluri Hari Babu
 *          
 *          @implNote	      	It is an Enum To set the approval/appointment Status
 *          					of the appointment class/entity.
  *         @version			1.0
  *         @since				30-MAR-2021
 ************************************************************************************/

public enum AppointmentStatus{

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
