package com.advantest.gef.editpolicies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.advantest.gef.commands.AbstractLayoutCommand;
import com.advantest.gef.commands.EmployLayoutCommand;
import com.advantest.gef.commands.ServiceLayoutCommand;
import com.advantest.gef.editpart.EmployePart;
import com.advantest.gef.editpart.ServicePart;

public class AppEditLayoutPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest arg0) {
		return null;
	}
	
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		AbstractLayoutCommand command = null;
		
		if (child instanceof EmployePart) {
			command = new EmployLayoutCommand();
		}else if(child instanceof ServicePart) {
			command = new ServiceLayoutCommand();
		}
		
		command.setModel(child.getModel());
		command.setConstraint((Rectangle)constraint);
		return command;
	}

}
