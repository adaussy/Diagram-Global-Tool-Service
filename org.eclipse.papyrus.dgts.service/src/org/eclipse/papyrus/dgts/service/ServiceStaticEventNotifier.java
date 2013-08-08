package org.eclipse.papyrus.dgts.service;

import java.util.Observable;
import java.util.Observer;

public class ServiceStaticEventNotifier {

	protected static ToolDefintionMenuObservable listener = new ToolDefintionMenuObservable();


	public static void notifyObservers() {
		listener.setChange();
		//listener.notifyObservers(DGTSFileServiceProvider
		//	.getDiagramGlobalToolDefinition());
	}//

	public static void addObserver(Observer o) {
		listener.addObserver(o);
	}

	protected static class ToolDefintionMenuObservable extends Observable {

		public void setChange() {
			setChanged();
		}

	}
}
