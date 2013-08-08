package org.eclipse.papyrus.dgts.commands;


import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.impl.EAnnotationImpl;
import org.eclipse.uml2.common.util.UML2Util;
public class testEAnnotation {
	
public testEAnnotation(){
	EAnnotationImpl anno = null ;
	Object obj = new Object() ;
	EModelElement newEModelElement = null;
	
	String source ="ID";
	EAnnotation e = UML2Util.createEAnnotation(newEModelElement, source ) ;
	newEModelElement.getEAnnotation("ID");
	anno.setEModelElement(newEModelElement);
}

}
