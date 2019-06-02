package com.advantest.gef.model;

public class Employe extends Node {
	private String prenom;
	public static final String PROPERTY_FIRSTNAME = "EmployeePrenom";

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
