package com.advantest.gef.editpart;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import com.advantest.gef.editpolicies.AppEditLayoutPolicy;
import com.advantest.gef.figure.EntrepriseFigure;
import com.advantest.gef.model.Entreprise;

public class EntreprisePart extends AbstractGraphicalEditPart {

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

}
