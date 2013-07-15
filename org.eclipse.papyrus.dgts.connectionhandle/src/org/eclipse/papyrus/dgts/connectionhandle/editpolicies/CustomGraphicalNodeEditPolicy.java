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


public class CustomGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
   
    @Override
    protected List getConnectionMenuContent(CreateConnectionRequest request) {
        List validRelTypes = new ArrayList();
        if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
            CreateUnspecifiedTypeConnectionRequest unspecifiedRequest = (CreateUnspecifiedTypeConnectionRequest) request;
            List allRequests = unspecifiedRequest.getAllRequests();
            if (allRequests.isEmpty()) {
                return null;
            }
            IGraphicalEditPart sourceEP = (IGraphicalEditPart) ((CreateConnectionRequest) allRequests
                .get(0)).getSourceEditPart();
            IGraphicalEditPart targetEP = (IGraphicalEditPart) ((CreateConnectionRequest) allRequests
                .get(0)).getTargetEditPart();

            List allRelTypes = unspecifiedRequest.useModelingAssistantService() ? CustomModelingAssistantService.getInstance().getRelTypesOnSourceAndTarget(sourceEP, targetEP)
                : unspecifiedRequest.getElementTypes();

            for (Iterator iter = allRelTypes.iterator(); iter.hasNext();) {
                IElementType type = (IElementType) iter.next();

                Command individualCmd = null;

                Request createConnectionRequest = unspecifiedRequest
                    .getRequestForType(type);
                if (createConnectionRequest != null) {
                    individualCmd = getHost().getCommand(
                        createConnectionRequest);
                    
                    if (individualCmd != null && individualCmd.canExecute()) {
                        validRelTypes.add(type);
                    }
                } else {
                    // This type may not have been given when the connection
                    // creation occurred. In this case, use the deferred
                    // connection creation mechanism.

                    // First, setup the request to initialize the connection
                    // start command.
                    CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory
                        .getCreateConnectionRequest(type,
                            ((IGraphicalEditPart) getHost())
                                .getDiagramPreferencesHint());
                    connectionRequest.setSourceEditPart(null);
                    connectionRequest.setTargetEditPart(sourceEP);
                    connectionRequest
                        .setType(RequestConstants.REQ_CONNECTION_START);
                    sourceEP.getCommand(connectionRequest);

                    // Now, setup the request in preparation to get the
                    // connection end
                    // command.
                    connectionRequest.setSourceEditPart(sourceEP);
                    connectionRequest.setTargetEditPart(targetEP);
                    connectionRequest
                        .setType(RequestConstants.REQ_CONNECTION_END);
                    individualCmd = targetEP.getCommand(connectionRequest);                   

                    if (individualCmd != null && individualCmd.canExecute()) {
                        validRelTypes.add(type);
                        unspecifiedRequest.addRequest(type, connectionRequest);
                    }
                }
            }

        }
        return validRelTypes;
    }
  
}
