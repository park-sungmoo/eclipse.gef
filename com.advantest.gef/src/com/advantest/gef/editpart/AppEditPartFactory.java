package com.advantest.gef.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.advantest.gef.model.Entreprise;

public class AppEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		AbstractGraphicalEditPart editPart = null;
		
		if (model instanceof Entreprise) {
			editPart = new EntreprisePart();
		}
		
		editPart.setModel(model);
		return editPart;
	}

}
