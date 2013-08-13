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

package org.eclipse.papyrus.dgts.menus;


/** Kind of final String used in the menu creation
 * @author vlartiga
 *
 */
public class DGTSEventTopics {

	public static final String CONF_LOADED = "CONF_LOADED";

	public static final String CONF_UNLOAD = "CONF_UNLOAD";

	public static final String MENU_CONTRIBUTION_ID = "org.eclipse.papyrus.dgts.menus.menucontribution.0";
	
	public static final String COMMAND_ID = "org.eclipse.papyrus.dgts.menus.command.createElement";
	
	public static final String COMMAND_PARAMETER_ID = "org.eclipse.papyrus.dgts.menus.command.commandParameter";
	
	public static final String MENU_LABEL = "Create a new " ; 
	
	
	public static String getNameFromIElementDisplayName(String displayName){
		char[] charName = displayName.toCharArray() ;
		for(int i=0; i<charName.length ; i++){
			if(charName[i]==':'){
				String value = String.copyValueOf(charName, i+2, charName.length-i-2 ) ;
				return value ;
			}
		}
		
		
		return displayName;
		
	}
	

}
