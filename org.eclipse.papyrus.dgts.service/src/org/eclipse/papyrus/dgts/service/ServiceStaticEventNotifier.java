/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 * Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.dgts.service;

import java.util.Observable;
import java.util.Observer;



/**
 * @author vlartigaut
 * 
 */
public class ServiceStaticEventNotifier {

	protected static ToolDefintionMenuObservable listener = new ToolDefintionMenuObservable();


	public static void notifyObservers() {
		listener.setChange();
		//listener.notifyObservers(null);
	}

	public static void addObserver(Observer o) {
		listener.addObserver(o);
	}

	protected static class ToolDefintionMenuObservable extends Observable {

		public void setChange() {
			setChanged();
		}

	}
}
