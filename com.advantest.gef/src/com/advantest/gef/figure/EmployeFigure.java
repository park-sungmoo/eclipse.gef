package com.advantest.gef.figure;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class EmployeFigure extends Figure {
	private Label labelName = new Label();
	private Label labelFirstName = new Label();
	
	public EmployeFigure() {
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		
		labelName.setForegroundColor(ColorConstants.darkGray);
		add(labelName, ToolbarLayout.ALIGN_CENTER);
		
		labelFirstName.setForegroundColor(ColorConstants.black);
		add(labelFirstName, ToolbarLayout.ALIGN_CENTER);
		
		setForegroundColor(ColorConstants.darkGray);
		
		setBackgroundColor(ColorConstants.lightGray	);
		
		
		setBorder(new LineBorder(1));
		setOpaque(true);
	}

	public void setName(String name) {
		labelName.setText(name);
	}
	
	public void setFirstName(String firstName) {
		labelFirstName.setText(firstName);
	}

	public void setLayout(Rectangle rectangle) {
		getParent().setConstraint(this, rectangle);
	}
	
}
