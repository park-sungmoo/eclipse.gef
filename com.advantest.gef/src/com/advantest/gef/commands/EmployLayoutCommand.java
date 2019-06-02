package com.advantest.gef.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import com.advantest.gef.model.Employe;

public class EmployLayoutCommand extends AbstractLayoutCommand {
	private Employe model;
	private Rectangle layout;
	private Rectangle oldLayout;
	
	@Override
	public void setConstraint(Rectangle rectangle) {
		this.layout = rectangle;
	}

	@Override
	public void setModel(Object model) {
		this.model = (Employe)model;
		oldLayout = ((Employe)model).getRectangle();
	}
	
	@Override
	public void execute() {
		model.setRectangle(layout);
	}
	
	@Override
	public void undo() {
		model.setRectangle(oldLayout);
	}

}
