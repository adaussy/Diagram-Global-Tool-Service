package org.eclipse.papyrus.dgts.service;
import org.eclipse.ui.IStartup;


public class LoadModelStartup implements IStartup {

	@Override
	public void earlyStartup() {
		ServiceStaticEventNotifier.notifyObservers();

	}

}
