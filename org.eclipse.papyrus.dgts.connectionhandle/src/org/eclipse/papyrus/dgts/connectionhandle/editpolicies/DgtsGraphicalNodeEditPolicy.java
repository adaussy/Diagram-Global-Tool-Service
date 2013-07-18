package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;

public class DgtsGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
 

    @Override
    protected List getConnectionMenuContent(CreateConnectionRequest request) {
	
	List validRelTypes = new ArrayList();
	if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
	    CreateUnspecifiedTypeConnectionRequest unspecifiedRequest = (CreateUnspecifiedTypeConnectionRequest) request;
	    List allRequests = unspecifiedRequest.getAllRequests();
	    if (allRequests.isEmpty()) {
		return null;
	    }
	    IGraphicalEditPart sourceEP = (IGraphicalEditPart) ((CreateConnectionRequest) allRequests.get(0)).getSourceEditPart();
	    IGraphicalEditPart targetEP = (IGraphicalEditPart) ((CreateConnectionRequest) allRequests.get(0)).getTargetEditPart();
	    validRelTypes = unspecifiedRequest.useModelingAssistantService() ? CustomModelingAssistantService.getInstance().getRelTypesOnSourceAndTarget(sourceEP, targetEP) : unspecifiedRequest.getElementTypes();

	}

	
	return validRelTypes;
    }

}
