package com.advantest.gef.figure;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class EntrepriseFigure extends Figure {
	private Label labelName = new Label();
	private Label labelAddress = new Label();
	private Label labelCapital = new Label();
	private XYLayout layout;
	
	public EntrepriseFigure() {
		layout = new XYLayout();
		setLayoutManager(layout);
		
		labelName.setForegroundColor(ColorConstants.blue);
		add(labelName);
		setConstraint(labelName, new Rectangle(5, 5, -1, -1));
		
		labelAddress.setForegroundColor(ColorConstants.lightBlue);
		add(labelAddress);
		setConstraint(labelAddress, new Rectangle(5, 17, -1, -1));
		
		labelCapital.setForegroundColor(ColorConstants.lightBlue);
		add(labelCapital);
		setConstraint(labelCapital, new Rectangle(5, 30, -1, -1));
		
		setForegroundColor(ColorConstants.black);
		setBorder(new LineBorder(5));
	}

	public void setName(String name) {
		labelName.setText(name);
	}

	public void setAddress(String address) {
		labelAddress.setText(address);
	}

	public void setCapital(int capital) {
		labelCapital.setText("Capital: " + capital);
	}

	public void setLayout(Rectangle rectangle) {
		setBounds(rectangle);
	}
	
}
