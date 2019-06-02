package com.advantest.gef.commands;

import org.eclipse.gef.commands.Command;

import com.advantest.gef.model.Node;

public class DeleteCommand extends Command {
	private Node model;
	private Node parentModel;
	
	@Override
	public void execute() {
		this.parentModel.removeChild(model);
		model.setParent(null);
	}
	
	@Override
	public void undo() {
		this.parentModel.addChild(model);
		model.setParent(parentModel);
	}
	
	public void setModel(Object model) {
		this.model = (Node)model;
	}
	
	public void setParentModel(Object model) {
		this.parentModel = (Node)model;
	}

}
