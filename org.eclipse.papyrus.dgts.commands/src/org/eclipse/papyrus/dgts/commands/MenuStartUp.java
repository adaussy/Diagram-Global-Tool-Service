package org.eclipse.papyrus.dgts.commands;

import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.ui.IStartup;

public class MenuStartUp implements IStartup {

	@Override
	public void earlyStartup() {
		ToolDefinitionResourceProvider.notifyObserver();

	}

}
