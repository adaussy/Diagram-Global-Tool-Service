package org.papyrus.dgts.service;

import java.io.IOException;

import org.eclipse.core.resources.IFile;



public interface IDgtsResourceLoader {
	
	public void LoadResource(IFile file) throws IOException;
		
}
