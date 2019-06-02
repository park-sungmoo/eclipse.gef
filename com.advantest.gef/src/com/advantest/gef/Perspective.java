package com.advantest.gef;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


/*
 * run configuration -> run in clear mode
 * otherwise, the perspective page can not shown.
 */
public class Perspective implements IPerspectiveFactory {

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		System.out.println("=============createInitial=================");
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.addStandaloneView(IPageLayout.ID_OUTLINE, true, IPageLayout.LEFT, (float) 0.5, editorArea);
	}
}
