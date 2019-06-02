package com.advantest.gef.editpart;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
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
		// TODO Auto-generated method stub

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
	}

}
