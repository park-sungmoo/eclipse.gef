package com.advantest.gef.model;

public class Entreprise extends Node {
	private String address;
	private int capital;
	public static final String PROPERTY_CAPITAL = "EnterpriseCapital";
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	
	
}
