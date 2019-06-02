package com.advantest.gef;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


/*
 * run configuration -> run in clear mode
 * otherwise, the perspective page can not shown.
 */
public class Perspective implements IPerspectiveFactory {
    
	private static final String ID_TABS_FOLDER = "PropertySheet";
    
	@Override	
	public void createInitialLayout(IPageLayout layout) {
//		System.out.println("=============createInitial=================");
//		String editorArea = layout.getEditorArea();
//		layout.setEditorAreaVisible(true);
//		layout.addStandaloneView(IPageLayout.ID_OUTLINE, true, IPageLayout.LEFT, (float) 0.5, editorArea);
		
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
//		layout.addStandaloneView(IPageLayout.ID_OUTLINE, true, IPageLayout.LEFT, 0.3f, editorArea);
		IFolderLayout tabs = layout.createFolder(ID_TABS_FOLDER, IPageLayout.LEFT, 0.3f, editorArea);
		tabs.addView(IPageLayout.ID_OUTLINE);
		tabs.addPlaceholder(IPageLayout.ID_PROP_SHEET);
	}
}
