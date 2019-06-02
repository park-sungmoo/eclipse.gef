package com.advantest.gef.editpart;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

import com.advantest.gef.editpolicies.AppDeletePolicy;
import com.advantest.gef.editpolicies.AppEditLayoutPolicy;
import com.advantest.gef.editpolicies.AppRenamePolicy;
import com.advantest.gef.figure.ServiceFigure;
import com.advantest.gef.model.Node;
import com.advantest.gef.model.Service;

public class ServicePart extends AppAbstractEditpart {

	@Override
	protected IFigure createFigure() {
		ServiceFigure figure = new ServiceFigure();
		return figure;	
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AppEditLayoutPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new AppRenamePolicy());
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_LAYOUT)) {
			refreshVisuals();
		}
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD_NODE)) {
			refreshChildren();
		}
		if (evt.getPropertyName().equals(Node.PROPERTY_DELETE_NODE)) {
			refreshChildren();
		}
		if (evt.getPropertyName().equals(Node.PROPERTY_RENAME)) {
			refreshVisuals();
		}
	}

}
