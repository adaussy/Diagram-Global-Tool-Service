package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.PromptForConnectionAndEndCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.ElementTypeLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.SelectExistingElementForSourceOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.SelectExistingElementForTargetOperation;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
import org.eclipse.swt.widgets.Display;

public class CustomPromptForConnectionAndEndCommand extends PromptForConnectionAndEndCommand {

    public CustomPromptForConnectionAndEndCommand(CreateConnectionRequest request, IGraphicalEditPart containerEP) {
	
	super(request, containerEP);
	this.request = request;
	this.containerEP = containerEP;
    }

    /**
     * This can be added to the content list to add a 'select existing' option.
     */
    private static String EXISTING_ELEMENT = DiagramUIMessages.ConnectionHandle_Popup_ExistingElement;



    /**
     * The request to create a connection. It may contain the connection type or
     * it may be a <code>CreateUnspecifiedTypeConnectionRequest</code>.
     */
    private CreateConnectionRequest request;

    /** The container editpart to send the view request to. */
    private IGraphicalEditPart containerEP;

    /**
     * Creates a new <code>PromptForConnectionAndEndCommand</code>.
     * 
     * @param request
     *            The request to create a connection. It may contain the
     *            connection type or it may be a
     *            <code>CreateUnspecifiedTypeConnectionRequest</code>.
     * @param containerEP
     *            The container edit part, where the view and element request to
     *            create the other end is sent. This is used only for testing
     *            that a type is valid for the other end.
     */

    /**
     * Gets a list of all the connection items that will represent the
     * connection choices and will appear in the first part of the popup menu.
     * 
     * <p>
     * If the objects in this are not <code>IElementTypes</code> or they require
     * a special label provider, then {@link #getConnectionLabelProvider()}
     * should be overridden to provide this.
     * </p>
     * <p>
     * When this command has executed, the connection adapter result (
     * {@link #getConnectionAdapter()}) will be populated with the connection
     * item chosen.
     * </p>
     * 
     * @return the list of connection items to appear in the popup menu
     */
    @Override
    protected List getConnectionMenuContent() {
	List validRelTypes = new ArrayList();
	if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
	    List allRelTypes = null;
	    if (((CreateUnspecifiedTypeConnectionRequest) request).useModelingAssistantService()) {
		allRelTypes = isDirectionReversed() ? CustomModelingAssistantService.getInstance().getRelTypesOnTarget(getKnownEnd()) : CustomModelingAssistantService.getInstance()
			.getRelTypesOnSource(getKnownEnd());
	    } else {
		allRelTypes = ((CreateUnspecifiedTypeConnectionRequest) request).getElementTypes();
	    }

	    if (isDirectionReversed()) {
		validRelTypes = allRelTypes;
	    } else {
		// Cycle through and make sure each connection type is
		// supported
		// for starting a connection on the source.
		for (Iterator iter = allRelTypes.iterator(); iter.hasNext();) {
		    IElementType rType = (IElementType) iter.next();
		    if (((CreateConnectionRequest) ((CreateUnspecifiedTypeConnectionRequest) request).getRequestForType(rType)).getStartCommand() != null) {
			validRelTypes.add(rType);
		    }
		}
	    }

	} else if (request instanceof CreateConnectionViewAndElementRequest) {
	    if (((CreateConnectionViewAndElementRequest) request).getStartCommand() != null) {
		validRelTypes.add(((CreateRelationshipRequest) ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter()
			.getAdapter(CreateRelationshipRequest.class)).getElementType());
	    }
	} else if (request instanceof CreateConnectionViewRequest) {
	    if (((CreateConnectionViewRequest) request).getStartCommand() != null) {
		Object type = ((CreateConnectionViewRequest) request).getConnectionViewDescriptor().getElementAdapter().getAdapter(IElementType.class);
		if (type != null) {
		    validRelTypes.add(type);
		}
	    }
	}
	return validRelTypes;
    }

    /**
     * Gets a list of all the end items that will represent the other end
     * choices and will appear in the submenu popup of the given connection
     * item.
     * 
     * <p>
     * If the objects in this are not <code>IElementTypes</code> or they require
     * a special label provider, then {@link #getEndLabelProvider()} should be
     * overridden to provide this.
     * </p>
     * <p>
     * When this command has executed, the end adapter result (
     * {@link #getEndAdapter()}) will be populated with the end item chosen.
     * </p>
     * 
     * @param connectionItem
     *            the connection item for which this will be a submenu
     * @return the list of end items to appear in the popup menu
     */

    @Override
    protected List getEndMenuContent(Object connectionItem) {
	if (connectionItem instanceof IElementType) {
	    IElementType connectionType = (IElementType) connectionItem;
	    List menuContent = isDirectionReversed() ? CustomModelingAssistantService.getInstance().getTypesForSourceAndContainer(getKnownEnd(), connectionType,containerEP) : CustomModelingAssistantService.getInstance()
		    .getTypesForTargetAndContainer(getKnownEnd(), connectionType, containerEP);
	    	 

	    return menuContent;
	}
	return Collections.EMPTY_LIST;
    }





    /**
     * Pops up the dialog with the content provided. If the user selects 'select
     * existing', then the select elements dialog also appears.
     */
   

    /**
     * Checks if the <code>ModelingAssistantService</code> supports the ability
     * to open a dialog for the user to select an existing element
     * 
     * @param connectionType
     * @return true if the supported by the modeling assistant service; false
     *         otherwise
     */
    private boolean supportsExistingElement(IElementType connectionType) {
	if (isDirectionReversed()) {
	    if (CustomModelingAssistantService.getInstance().provides(new SelectExistingElementForSourceOperation(getKnownEnd(), connectionType))) {
		return true;
	    }
	} else if (CustomModelingAssistantService.getInstance().provides(new SelectExistingElementForTargetOperation(getKnownEnd(), connectionType))) {
	    return true;
	}
	return false;
    }



    /**
     * Gets the known end, which even in the case of a reversed
     * <code>CreateUnspecifiedTypeConnectionRequest</code>, is the source
     * editpart.
     * 
     * @return the known end
     */
    private EditPart getKnownEnd() {
	return request.getSourceEditPart();
    }

}
