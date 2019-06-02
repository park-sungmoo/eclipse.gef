package com.advantest.gef.editpart;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import com.advantest.gef.editpolicies.AppEditLayoutPolicy;
import com.advantest.gef.figure.EntrepriseFigure;
import com.advantest.gef.model.Entreprise;
import com.advantest.gef.model.Node;

public class EntreprisePart extends AppAbstractEditpart {

	@Override
	protected IFigure createFigure() {
		EntrepriseFigure figure = new EntrepriseFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AppEditLayoutPolicy());
	}
	
	@Override
	protected void refreshVisuals() {
		EntrepriseFigure figure = (EntrepriseFigure)getFigure();
		Entreprise model = (Entreprise)getModel();
		
		figure.setName(model.getName());
		figure.setAddress(model.getAddress());
		figure.setCapital(model.getCapital());
		
		super.refreshVisuals();
	}
	
	@Override
	protected List getModelChildren() {
		return ((Entreprise)getModel()).getChildren();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals(Node.PROPERTY_ADD_NODE)) {
			refreshChildren();
		}
		
		if (event.getPropertyName().equals(Node.PROPERTY_DELETE_NODE)) {
			refreshChildren();
		}
		
		if (event.getPropertyName().equals(Node.PROPERTY_RENAME)) {
			refreshVisuals(); 
		}
		if(event.getPropertyName().equals(Entreprise.PROPERTY_CAPITAL)) {
			refreshVisuals();
		}
	}

}
