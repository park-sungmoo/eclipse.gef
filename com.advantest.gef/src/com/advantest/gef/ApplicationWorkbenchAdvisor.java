package com.advantest.gef;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.advantest.gef.editor.MyEditorInput;
import com.advantest.gef.editor.MyGraphicalEditor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.advantest.gef.perspective"; //$NON-NLS-1$

	@Override
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    @Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
    
    @Override
    public void postStartup() {
    	super.postStartup();
    	try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.openEditor(new MyEditorInput("MyGraphicalEditor"), MyGraphicalEditor.ID, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
