package com.advantest.gef.editpart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.advantest.gef.figure.EntrepriseFigure;
import com.advantest.gef.figure.ServiceFigure;
import com.advantest.gef.model.Entreprise;
import com.advantest.gef.model.Node;
import com.advantest.gef.model.Service;

public class ServicePart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		ServiceFigure figure = new ServiceFigure();
		return figure;	
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void refreshVisuals() {
		ServiceFigure figure = (ServiceFigure)getFigure();
		Service model = (Service)getModel();
		
		figure.setName(model.getName());
		figure.setEtage(model.getEtage());
		figure.setLayout(model.getRectangle());
		
		super.refreshVisuals();
	}
	
	@Override
	protected List getModelChildren() {
		return ((Service)getModel()).getChildren();
	}

}
