package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.PromptForConnectionAndEndCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerNodeEditPolicy;

public class DgtsContainerNodeEditPolicy extends ContainerNodeEditPolicy {
	
	
	@Override
	protected PromptForConnectionAndEndCommand getPromptForConnectionAndEndCommand(
			CreateConnectionRequest request) {
		return new CustomPromptForConnectionAndEndCommand(request,
			(IGraphicalEditPart) getHost());
	}

}
