package com.advantest.gef.part.tree;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.advantest.gef.editpolicies.AppDeletePolicy;
import com.advantest.gef.editpolicies.AppRenamePolicy;
import com.advantest.gef.model.Entreprise;
import com.advantest.gef.model.Node;
import com.advantest.gef.model.Service;

public class ServiceTreeEditPart extends AppAbstractTreeEditPart {

	@Override
	protected List getModelChildren() {
		return ((Service)getModel()).getChildren();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new AppRenamePolicy());
	}
	
	@Override
	protected void refreshVisuals() {
		Service model = (Service)getModel();
		setWidgetText(model.getName());
		setWidgetImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD_NODE)) {
			refreshChildren();
		}
		
		if (evt.getPropertyName().equals(Node.PROPERTY_DELETE_NODE)) {
			refreshChildren();
		}
		
		if (evt.getPropertyName().equals(Node.PROPERTY_RENAME)) {
			refreshVisuals();
		}
		
		if (evt.getPropertyName().equals(Service.PROPERTY_COLOR)) {
			refreshVisuals();
		}
		
		if (evt.getPropertyName().equals(Service.PROPERTY_FLOOR)) {
			refreshVisuals();
		}
	}

}
