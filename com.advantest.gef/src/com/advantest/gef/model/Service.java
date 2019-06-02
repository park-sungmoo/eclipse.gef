package com.advantest.gef.model;

import org.eclipse.swt.graphics.Color;

public class Service extends Node {
	private int etage;
	private Color color;	
	public static final String PROPERTY_COLOR = "NodeColor";
	public static final String PROPERTY_FLOOR = "ServiceFloor";


	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	private Color createRandomColor() {
		return new Color(null, 
				(new Double(Math.random() * 128)).intValue() + 128, 
				(new Double(Math.random() * 128)).intValue() + 128, 
				(new Double(Math.random() * 128)).intValue() + 128);
	}
	
	public Service() {
		this.color = createRandomColor();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		Color oldColor = this.color;
		this.color = color;
		
		getListeners().firePropertyChange(PROPERTY_COLOR, oldColor, color);
	}
}
