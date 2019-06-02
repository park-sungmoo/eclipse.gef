package com.advantest.gef.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.geometry.Rectangle;

public class Node {
	private String name;
	private Rectangle rectangle;
	private List<Node> children;
	private Node parent;
	
	/*
	 * propertyChangeSupport
	 */
	public static final String PROPERTY_LAYOUT = "NodeLayout";
	private PropertyChangeSupport listens;
	
	public Node() {
		this.name = "Unknown";
		this.rectangle = new Rectangle(10, 10, 100, 100);
		this.children = new ArrayList<Node>();
		this.parent = null;
		listens = new PropertyChangeSupport(this);
	}
	
	public Node(String name, Rectangle rectangle, List<Node> children, Node parent) {
		super();
		this.name = name;
		this.rectangle = rectangle;
		this.children = children;
		this.parent = parent;
		listens = new PropertyChangeSupport(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle newLayout) {
		Rectangle oldLayout = this.rectangle;
		this.rectangle = newLayout;
		getListeners().firePropertyChange(PROPERTY_LAYOUT, oldLayout, newLayout);
	}
	
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public boolean addChild(Node child) {
		child.setParent(this);
		return this.children.add(child);
	}
	
	public boolean removeChild(Node child) {
		child.setParent(null);
		return this.children.remove(child);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listens.addPropertyChangeListener(listener);
	}
	
	public PropertyChangeSupport getListeners() {
		return listens;
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listens.removePropertyChangeListener(listener);
	}
}
