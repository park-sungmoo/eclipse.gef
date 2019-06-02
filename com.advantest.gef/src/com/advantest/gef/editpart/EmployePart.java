package com.advantest.gef.editpart;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

import com.advantest.gef.editpolicies.AppDeletePolicy;
import com.advantest.gef.figure.EmployeFigure;
import com.advantest.gef.model.Employe;
import com.advantest.gef.model.Node;

public class EmployePart extends AppAbstractEditpart {

	@Override
	protected IFigure createFigure() {
		EmployeFigure figure = new EmployeFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
	}
	
	@Override
	protected void refreshVisuals() {
		EmployeFigure figure = (EmployeFigure)getFigure();
		Employe model = (Employe)getModel();
		
		figure.setName(model.getName());
		figure.setFirstName(model.getPrenom());
		figure.setLayout(model.getRectangle());
		
		super.refreshVisuals();
	}
	
	@Override
	protected List getModelChildren() {
		return new ArrayList<Node>();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_LAYOUT)) {
			refreshVisuals();
		}
		
		if (evt.getPropertyName().equals(Employe.PROPERTY_FIRSTNAME)) {
			refreshVisuals();
		}
	}

}
