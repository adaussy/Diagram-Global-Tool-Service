package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.PromptForConnectionAndEndCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;

public class CustomPromptForConnectionAndEndCommand extends PromptForConnectionAndEndCommand {

    public CustomPromptForConnectionAndEndCommand(CreateConnectionRequest request, IGraphicalEditPart containerEP) {

	super(request, containerEP);
	this.request = request;
	this.containerEP = containerEP;
    }

    /**
     * The request to create a connection. It may contain the connection type or
     * it may be a <code>CreateUnspecifiedTypeConnectionRequest</code>.
     */
    private CreateConnectionRequest request;

    /** The container editpart to send the view request to. */
    private IGraphicalEditPart containerEP;

    
    @Override
    protected List getConnectionMenuContent() {
	List validRelTypes = new ArrayList();
	if (request instanceof CreateUnspecifiedTypeConnectionRequest) {

	    if (((CreateUnspecifiedTypeConnectionRequest) request).useModelingAssistantService()) {
		validRelTypes = isDirectionReversed() ? CustomModelingAssistantService.getInstance().getRelTypesOnTarget(getKnownEnd()) : CustomModelingAssistantService.getInstance().getRelTypesOnSource(getKnownEnd());
	    } else {
		validRelTypes = ((CreateUnspecifiedTypeConnectionRequest) request).getElementTypes();
	    }

	}

	return validRelTypes;
    }


    
    
    @Override
    protected List getEndMenuContent(Object connectionItem) {
	if (connectionItem instanceof IElementType) {
	    IElementType connectionType = (IElementType) connectionItem;
	    List menuContent = isDirectionReversed() ? CustomModelingAssistantService.getInstance().getTypesForSourceAndContainer(getKnownEnd(), connectionType, containerEP) : CustomModelingAssistantService.getInstance().getTypesForTargetAndContainer(getKnownEnd(), connectionType, containerEP);

	    return menuContent;
	}
	return Collections.EMPTY_LIST;
    }

    
    
    @Override
    protected PopupMenu createPopupMenu() {

	final List connectionMenuContent = getConnectionMenuContent();

	if (connectionMenuContent == null || connectionMenuContent.isEmpty()) {
		return null;
	} else if (connectionMenuContent.size() == 1) {
		List menuContent = getEndMenuContent(connectionMenuContent.get(0));
		if (menuContent == null || menuContent.isEmpty()) {
			return null;
		}

		ILabelProvider labelProvider = getConnectionAndEndLabelProvider(connectionMenuContent
			.get(0));
		return new PopupMenu(menuContent, labelProvider) {

			/**
			 * @see org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu#getResult()
			 */
			public Object getResult() {
				Object endResult = super.getResult();
				if (endResult == null) {
					return null;
				} else {
					List resultList = new ArrayList(2);
					resultList.add(connectionMenuContent.get(0));
					resultList.add(endResult);
					return resultList;
				}
			}
		};
	} else {
		List menuContent = new ArrayList();
		for (Iterator iter = connectionMenuContent.iterator(); iter
			.hasNext();) {
			Object connectionItem = iter.next();

			List subMenuContent = getEndMenuContent(connectionItem);

			if (subMenuContent.isEmpty()) {
				continue;
			}

			PopupMenu subMenu = new PopupMenu(subMenuContent,
				getEndLabelProvider());

			menuContent.add(new PopupMenu.CascadingMenu(connectionItem,
				subMenu));
			
		}
		if (!menuContent.isEmpty()) {
			return new PopupMenu(menuContent, getConnectionLabelProvider());
		}
	}
	return null;
}
    
    
    

    
    
    private EditPart getKnownEnd() {
	return request.getSourceEditPart();
    }

}
