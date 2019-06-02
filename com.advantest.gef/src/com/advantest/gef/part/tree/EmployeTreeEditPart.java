package com.advantest.gef.part.tree;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.advantest.gef.editpolicies.AppDeletePolicy;
import com.advantest.gef.model.Employe;
import com.advantest.gef.model.Node;

public class EmployeTreeEditPart extends AppAbstractTreeEditPart {

	@Override
	protected List getModelChildren() {
		return ((Employe)getModel()).getChildren();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
	}
	
	@Override
	protected void refreshVisuals() {
		Employe model = (Employe)getModel();
		setWidgetText(model.getName() + " " + model.getPrenom());
		setWidgetImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEF_VIEW));
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD_NODE)) {
			refreshChildren();
		}
		
		if (evt.getPropertyName().equals(Node.PROPERTY_DELETE_NODE)) {
			refreshChildren();
		}
	}

}
