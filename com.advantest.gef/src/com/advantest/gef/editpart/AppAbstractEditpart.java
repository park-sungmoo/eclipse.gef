package com.advantest.gef.editpart;

import java.beans.PropertyChangeListener;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.advantest.gef.model.Node;

public abstract class AppAbstractEditpart extends AbstractGraphicalEditPart implements PropertyChangeListener {
	
	@Override
	public void activate() {
		super.activate();
		((Node)getModel()).addPropertyChangeListener(this);
	}
	
	@Override
	public void deactivate() {
		super.deactivate();
		((Node)getModel()).removePropertyChangeListener(this);
	}

}
