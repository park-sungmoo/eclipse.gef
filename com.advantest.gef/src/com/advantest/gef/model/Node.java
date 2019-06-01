package com.advantest.gef.model;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.geometry.Rectangle;

public class Node {
	private String name;
	private Rectangle rectangle;
	private List<Node> children;
	private Node parent;
	
	public Node() {
		this.name = "Unknown";
		this.rectangle = new Rectangle(10, 10, 100, 100);
		this.children = new ArrayList<Node>();
		this.parent = null;
	}
	
	public Node(String name, Rectangle rectangle, List<Node> children, Node parent) {
		super();
		this.name = name;
		this.rectangle = rectangle;
		this.children = children;
		this.parent = parent;
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
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
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
	
	
}
