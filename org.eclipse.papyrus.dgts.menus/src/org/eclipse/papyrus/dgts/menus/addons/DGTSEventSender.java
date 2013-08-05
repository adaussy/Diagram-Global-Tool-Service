 /*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 ******************************************************************************/

package org.eclipse.papyrus.dgts.menus.addons;

import java.util.Observable;
import java.util.Observer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.papyrus.dgts.service.ServiceStaticEventNotifier;


public class DGTSEventSender  implements Observer  {
	
	@Inject
	Object pipo;
	
	@Inject
	IEventBroker eventBroker;
	public DGTSEventSender(){
		
	}
	

	
	@PostConstruct
	void hookListeners() {
		ServiceStaticEventNotifier.addObserver(this);
		
	}
	
	@PreDestroy
	void unhookListeners() {
	}

	
	@Override
	public void update(Observable o, Object data) {
		if(data !=null){
			
			eventBroker.send(DGTSEventTopics.CONF_LOADED, data);
		}
		else{
			eventBroker.send(DGTSEventTopics.CONF_UNLOAD, data);
		}

	}	
}