package com.advantest.gef.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;

import com.advantest.gef.editpart.AppEditPartFactory;
import com.advantest.gef.model.Entreprise;

public class MyGraphicalEditor extends GraphicalEditor {
	public static final String ID = "com.advantest.gef.mygraphicaleditor";
	
	public MyGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	public Entreprise creatEntreprise() {
		Entreprise entreprise = new Entreprise();
		
		entreprise.setName("Hua wei");
		entreprise.setAddress("xi'an road");
		entreprise.setCapital(10086);
		
		return entreprise;
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(creatEntreprise());
	}
	
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new AppEditPartFactory());
	}
}
