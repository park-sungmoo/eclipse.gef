package com.advantest.gef.part.tree;

import java.beans.PropertyChangeEvent;
import java.util.List;

import com.advantest.gef.model.Entreprise;
import com.advantest.gef.model.Node;

public class EntrepriseTreeEditPart extends AppAbstractTreeEditPart {

	@Override
	protected List getModelChildren() {
		return ((Entreprise)getModel()).getChildren();
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
		
		if(evt.getPropertyName().equals(Entreprise.PROPERTY_CAPITAL)) {
			refreshVisuals();
		}	
	}

}
