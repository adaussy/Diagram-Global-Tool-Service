package org.eclipse.papyrus.dgts.popupbar;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class CustomConnectionHandleEditPolicy extends ConnectionHandleEditPolicy{
	
	
	
	
	IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

	/* !!!!!!! ICI on enleve la condition isDiagramPartActive car elle renvoie toujours false 
	(à priori car on a plusieurs diagrammes contenu dans le .di de papyrus)
	a voir si il faut pas la recoder pour verifier quand meme que le diagrame est actif.
	*/
	@Override
	protected boolean shouldShowDiagramAssistant() {
		return getHost().isActive() && isPreferenceOn() && isHostEditable() &&isHostResolvable() ;
	}
	
	//Meme code que DiagramAssistantEditPolicy
	private boolean isHostEditable() {
		if (getHost() instanceof GraphicalEditPart) {
			return ((GraphicalEditPart) getHost()).isEditModeEnabled();
		}
		return true;
	}

	/**
	 * Is the host's semantic reference resolvable (if applicable)?
	 * 
	 * @return true if the semantic reference is resolvable, true if there is no
	 *         semantic reference, and false otherwise
	 */
	//Meme code que DiagramAssistantEditPolicy
	private boolean isHostResolvable() {
		final View view = (View) getHost().getModel();
        EObject element = view.getElement();
		if (element != null) {
			return !element.eIsProxy();
		} 
		return true;
	}
}
