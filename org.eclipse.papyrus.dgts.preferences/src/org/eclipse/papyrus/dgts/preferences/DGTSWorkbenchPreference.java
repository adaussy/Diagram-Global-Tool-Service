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
package org.eclipse.papyrus.dgts.preferences;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.papyrus.dgts.service.ServiceStaticEventNotifier;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.framework.Bundle;

/**
 * Define the DGTS Preference page
 * 
 * @author vlartiga
 * 
 */
public class DGTSWorkbenchPreference extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	@SuppressWarnings("rawtypes")
	protected Map mapResource = new HashMap();

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Select global diagram Global Tool Definition preference");

	}

	@Override
	protected void createFieldEditors() {

		laodDGTSPreferences();
		addPreferences();

	}

	protected void addPreferences() {
		Set<?> cles = mapResource.keySet();
		Object cle;
		PreferenceObject preferenceObject;
		Iterator<?> it = cles.iterator();
		String[][] theme = new String[mapResource.size() + 1][2];
		int i = 0;
		while (it.hasNext()) {
			cle = it.next();
			preferenceObject = (PreferenceObject) mapResource.get(cle);
			theme[i][0] = preferenceObject.getDescription();
			theme[i][1] = preferenceObject.getResource();
			i++;
		}
		theme[i][0] = "no predefinies DGTS";
		theme[i][1] = "";
		ComboFieldEditor editor = new ComboFieldEditor("SelectDGTSTheme",
				"Current DGTS", theme, getFieldEditorParent());

		addField(editor);
	}

	@SuppressWarnings("deprecation")
	public static String getDGTSPreference() {
		return Activator.getDefault().getPluginPreferences()
				.getString("SelectDGTSTheme");
	}

	@SuppressWarnings("unchecked")
	public void laodDGTSPreferences() {
		IConfigurationElement[] conf = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.eclipse.papyrus.dgts.preferences.DGTSPreferences");
		String resource = null;
		String ID = null;
		String description = null;

		for (IConfigurationElement c : conf) {

			resource = c.getAttribute("resource");
			ID = c.getAttribute("ID");
			description = c.getAttribute("description");
			if (resource != null && ID != null) {
				Bundle bundle = Platform
						.getBundle(c.getContributor().getName());
				URL url = bundle.getEntry(resource);
				File file = null;
				try {
					file = new File(FileLocator.resolve(url).toURI());
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
				mapResource.put(ID, new PreferenceObject(
						file.getAbsolutePath(), description));

			}
		}

	}

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		ServiceStaticEventNotifier.notifyObservers();
		return result;
	}

	protected void loadDGTSPreferenceResource(String r) {

	}

	protected static class PreferenceObject {

		protected String resource;
		protected String description;

		public PreferenceObject(String resource, String description) {
			this.resource = resource;
			this.description = description;
		}

		public String getResource() {
			return resource;
		}

		public void setResource(String resource) {
			this.resource = resource;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
