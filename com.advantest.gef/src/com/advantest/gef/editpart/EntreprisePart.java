package com.advantest.gef.editpart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.advantest.gef.figure.EntrepriseFigure;
import com.advantest.gef.model.Entreprise;
import com.advantest.gef.model.Node;

public class EntreprisePart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		EntrepriseFigure figure = new EntrepriseFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

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
		return new ArrayList<Node>();
	}

}
