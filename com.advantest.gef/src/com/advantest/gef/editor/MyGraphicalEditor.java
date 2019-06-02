package com.advantest.gef.editor;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.swt.SWT;
import org.eclipse.ui.actions.ActionFactory;

import com.advantest.gef.editpart.AppEditPartFactory;
import com.advantest.gef.model.Employe;
import com.advantest.gef.model.Entreprise;
import com.advantest.gef.model.Service;

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
		
		    Service hrService = new Service();
		    hrService.setName("HR");
		    hrService.setEtage(2);
		    hrService.setRectangle(new Rectangle(40, 50, 250, 150));
		     
		        Employe employeHan = new Employe();
		        employeHan.setName("jiaojiao");
		        employeHan.setPrenom("han");
		        employeHan.setRectangle(new Rectangle(25, 40, 60, 40));
		        hrService.addChild(employeHan);

		        Employe employeZhang = new Employe();
		        employeZhang.setName("lin");
		        employeZhang.setPrenom("zhang");
		        employeZhang.setRectangle(new Rectangle(100, 60, 60, 40));
		        hrService.addChild(employeZhang);
		        
		        Employe employeZhang1 = new Employe();
		        employeZhang1.setName("wei");
		        employeZhang1.setPrenom("zhang");
		        employeZhang1.setRectangle(new Rectangle(180, 90, 60, 40));
		        hrService.addChild(employeZhang1);
		entreprise.addChild(hrService);
			
			Service developService = new Service();
			developService.setName("develop");
			developService.setEtage(1);
			developService.setRectangle(new Rectangle(220, 230, 250, 150));
			
				Employe employeHan1 = new Employe();
				employeHan1.setName("yutuo");
				employeHan1.setPrenom("han");
				employeHan1.setRectangle(new Rectangle(40, 70, 60, 40));
				developService.addChild(employeHan1);
			
				Employe employeEric = new Employe();
				employeEric.setName("eric");
				employeEric.setPrenom("zhang");
				employeEric.setRectangle(new Rectangle(170, 100, 60, 40));
				developService.addChild(employeEric);
		entreprise.addChild(developService);
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
		
		/*
		 * zoomin and zoomout
		 */
		
		double[] zoomLevels = new double[] {0.25, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 3.0, 4.0, 5.0};
		ArrayList<String> zoomContributions = new ArrayList<String>();
		ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		
		ZoomManager manager = rootEditPart.getZoomManager();
		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
		
		manager.setZoomLevels(zoomLevels);
		
		zoomContributions.add(ZoomManager.FIT_ALL);
		zoomContributions.add(ZoomManager.FIT_HEIGHT);
		zoomContributions.add(ZoomManager.FIT_WIDTH);
		manager.setZoomLevelContributions(zoomContributions);
		
		/*
		 * key handler
		 */
		KeyHandler keyHandler = new KeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0),
				getActionRegistry().getAction(ActionFactory.DELETE.getId()));

		keyHandler.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, 0),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		
		keyHandler.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, 0),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));
		
		viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.NONE),
				MouseWheelZoomHandler.SINGLETON);
		
		viewer.setKeyHandler(keyHandler);
		
		
	}
	
	@Override
	public Object getAdapter(Class type) {
		if (type == ZoomManager.class) {
			return ((ScalableRootEditPart)getGraphicalViewer().getRootEditPart()).getZoomManager();
		}else {
			return super.getAdapter(type);
		}
	}
}
