package com.advantest.gef.figure;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class ServiceFigure extends Figure {
	private Label labelName = new Label();
	private Label labelEtage = new Label();
	private XYLayout layout;
	
	public ServiceFigure() {
		layout = new XYLayout();
		setLayoutManager(layout);
		
		labelEtage.setForegroundColor(ColorConstants.black);
		add(labelEtage, ToolbarLayout.ALIGN_CENTER);
		setConstraint(labelEtage, new Rectangle(5, 5, -1, -1));
		
		labelName.setForegroundColor(ColorConstants.darkGray);
		add(labelName, ToolbarLayout.ALIGN_CENTER);
		setConstraint(labelName, new Rectangle(5, 17, -1, -1));
		
		/*
		 * just for fun
		 */
		
		/*
		setForegroundColor(new Color(null, 
				(new Double(Math.random()*128)).intValue(),
				(new Double(Math.random()*128)).intValue(),
				(new Double(Math.random()*128)).intValue()));
		
		setBackgroundColor(new Color(null, 
				(new Double(Math.random()*128)).intValue() + 128,
				(new Double(Math.random()*128)).intValue() + 128,
				(new Double(Math.random()*128)).intValue() + 128));
		*/
		
		setForegroundColor(ColorConstants.black);
		setBorder(new LineBorder(1));
		setOpaque(true);
	}

	public void setName(String name) {
		labelName.setText(name);
	}
	
	public void setEtage(int etage) {
		labelEtage.setText("Etage: " + etage);
	}

	public void setLayout(Rectangle rectangle) {
		getParent().setConstraint(this, rectangle);
	}
	
}
