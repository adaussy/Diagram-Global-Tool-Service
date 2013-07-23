package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateOrSelectElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
import org.eclipse.papyrus.dgts.connectionhandle.requests.DgtsCreateUnspecifiedTypeConnectionRequest;
import org.eclipse.swt.widgets.Display;





public class DgtsGraphicalNodeEditPolicy extends GraphicalEditPolicy {
    /** describes the view to be created. */
    private IAdaptable _viewAdapter;

    /**
     * The label used for the command to create a new connection.
     */
    private static final String CREATE_CONNECTION_COMMAND_LABEL = DiagramUIMessages.GraphicalNodeEditPolicy_createRelationshipCommand_label;

    /**
     * Gets a command that pops up a menu which allows the user to select which
     * type of connection to be created and then creates the connection. This
     * command uses
     * {@link #getCommandForMenuSelection(Object, CreateConnectionRequest)} on
     * the connection chosen to get the creation command.
     * 
     * @author cmahoney
     */
    protected class PromptAndCreateConnectionCommand extends CreateOrSelectElementCommand {

	/**
	 * Cache the request because it needs to be passed to
	 * {@link #getCommandForMenuSelection(Object, CreateConnectionRequest)}.
	 */
	private CreateConnectionRequest request;

	/**
	 * Creates a new instance.
	 * 
	 * @param content
	 *            The list of items making up the content of the popup menu.
	 * @param request
	 *            The relevant create connection request.
	 */
	public PromptAndCreateConnectionCommand(List content, CreateConnectionRequest request) {
	    super(CREATE_CONNECTION_COMMAND_LABEL, Display.getCurrent().getActiveShell(), content);
	    this.request = request;
	}

	/**
	 * The command to create the connection that may need to be
	 * undone/redone.
	 */
	private Command createCommand;

	/**
	 * Pops up the dialog with the content provided, gets the command to be
	 * executed based on the user selection, and then executes the command.
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

	    CommandResult cmdResult = super.doExecuteWithResult(progressMonitor, info);
	    if (!cmdResult.getStatus().isOK()) {
		return cmdResult;
	    }

	    Object connectionType = cmdResult.getReturnValue();

	    Command cmd = getConnectionCompleteCommand(connectionType, getRequest());
	    Assert.isTrue(cmd != null && cmd.canExecute());
	    cmd.execute();
	    createCommand = cmd;

	    if (connectionType instanceof IElementType) {
		CreateRequest createRequest = ((DgtsCreateUnspecifiedTypeConnectionRequest) request).getRequestForType((IElementType) connectionType);
		Object newObject = createRequest.getNewObject();

		return CommandResult.newOKCommandResult(newObject);
	    }
	    return CommandResult.newOKCommandResult();
	}

	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
	    if (createCommand != null) {
		createCommand.undo();
	    }
	    return super.doUndoWithResult(progressMonitor, info);
	}

	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
	    if (createCommand != null) {
		createCommand.redo();
	    }
	    return super.doRedoWithResult(progressMonitor, info);
	}

	/**
	 * Gets the request.
	 * 
	 * @return Returns the request.
	 */
	private CreateConnectionRequest getRequest() {
	    return request;
	}

    }


    /**
     * get a connectable edit part
     * 
     * @return INodeEditPart
     */
    protected INodeEditPart getConnectableEditPart() {
	return (INodeEditPart) getHost();
    }

    /**
     * getConnectionCompleteEditPart
     * 
     * This method is used when the connection is verified and made complete to
     * retrieve the final connecting editpart to be used in the connection
     * creation. This is by default the "host" edit part which is what is
     * connected to by the user feedback. Subclassing edit-policies may wish to
     * redirect the connection to a different edit-part depending on the
     * gesture. i.e. the tree-view for generalizations will redirect the
     * connection to the target of the host.
     * 
     * @param request
     *            Request giving some information about the user gesture.
     * @return INodeEditPart which will be the target connection.
     */
    protected INodeEditPart getConnectionCompleteEditPart(Request request) {
	if (getHost() instanceof INodeEditPart) {
	    return (INodeEditPart) getHost();
	}
	return null;
    }

 
    /**
     * get this edit policy's edit part <code>View</code>
     * 
     * @return View
     */
    protected View getView() {
	return (View) getHost().getModel();
    }

    /**
     * getSemanticHint Retrieves the semanticHint from the request regarding the
     * type of elemen being manipulated.
     * 
     * @param request
     *            Request that is sent from the user gesture
     * @return String that is the semantic type.
     */


    /**
     * getRoutingAdjustment method to adjust routing if the reorient has moved
     * the connection into a different routing environment. Specifically, if the
     * connection has been reoriented out of a tree structure it will change
     * routing to the default set in preference. Likewise, if the connection has
     * connected to a tree structure then the routing will create a tree.
     * 
     * @param connection
     *            IAdaptable that is placeholder for not yet created connection.
     *            Also adapts directly to a ConnectionEditPart in the case of a
     *            reorient.
     * @param connectionHint
     *            String that is the semantic hint of the connection being
     *            manipulated
     * @param currentRouterType
     *            Integer current representation of the routing style
     * @param target
     *            EditPart that is being targeted by the request.
     * @return Command to make any routing adjustments if necessary.
     */
    
 
    
    
    protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
	ICommandProxy proxy = (ICommandProxy) request.getStartCommand();
	if (proxy == null) {
	    return null;
	}

	// reset the target edit-part for the request
	INodeEditPart targetEP = getConnectionCompleteEditPart(request);
	if (targetEP == null) {
	    return null;
	}

	CompositeCommand cc = (CompositeCommand) proxy.getICommand();
	ConnectionAnchor targetAnchor = targetEP.getTargetConnectionAnchor(request);
	Iterator commandItr = cc.iterator();
	commandItr.next(); // 0
	SetConnectionEndsCommand sceCommand = (SetConnectionEndsCommand) commandItr.next(); // 1
	sceCommand.setNewTargetAdaptor(new EObjectAdapter(((IGraphicalEditPart) targetEP).getNotationView()));
	SetConnectionAnchorsCommand scaCommand = (SetConnectionAnchorsCommand) commandItr.next(); // 2
	scaCommand.setNewTargetTerminal(targetEP.mapConnectionAnchorToTerminal(targetAnchor));
	setViewAdapter(sceCommand.getEdgeAdaptor());
	INodeEditPart sourceEditPart = (INodeEditPart) request.getSourceEditPart();
	ConnectionAnchor sourceAnchor = sourceEditPart.mapTerminalToConnectionAnchor(scaCommand.getNewSourceTerminal());
	PointList pointList = new PointList();
	if (request.getLocation() == null) {
	    pointList.addPoint(sourceAnchor.getLocation(targetAnchor.getReferencePoint()));
	    pointList.addPoint(targetAnchor.getLocation(sourceAnchor.getReferencePoint()));
	} else {
	    pointList.addPoint(sourceAnchor.getLocation(request.getLocation()));
	    pointList.addPoint(targetAnchor.getLocation(request.getLocation()));
	}
	SetConnectionBendpointsCommand sbbCommand = (SetConnectionBendpointsCommand) commandItr.next(); // 3
	sbbCommand.setNewPointList(pointList, sourceAnchor.getReferencePoint(), targetAnchor.getReferencePoint());
	return request.getStartCommand();
    }

    /**
     * Cache the view descriptor describing the connection to be create.
     * 
     * @param viewAdapter
     */
    protected final void setViewAdapter(IAdaptable viewAdapter) {
	_viewAdapter = viewAdapter;
    }

    /**
     * Return the view adapter describing the element to be created.
     * 
     * @see #setViewAdapter(IAdaptable)
     * @return adpater that can adapt <code>View.class</code>
     */
    protected final IAdaptable getViewAdapter() {
	return _viewAdapter;
    }

    protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
	if (!(request instanceof CreateConnectionViewRequest))
	    return null;
	CreateConnectionViewRequest req = (CreateConnectionViewRequest) request;
	CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_CreateCommand_Connection_Label);
	Diagram diagramView = ((View) getHost().getModel()).getDiagram();
	TransactionalEditingDomain editingDomain = getEditingDomain();
	CreateCommand createCommand = new CreateCommand(editingDomain, req.getConnectionViewDescriptor(), diagramView.getDiagram());
	setViewAdapter((IAdaptable) createCommand.getCommandResult().getReturnValue());

	SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
	sceCommand.setEdgeAdaptor(getViewAdapter());
	sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
	ConnectionAnchor sourceAnchor = getConnectableEditPart().getSourceConnectionAnchor(request);
	SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
	scaCommand.setEdgeAdaptor(getViewAdapter());
	scaCommand.setNewSourceTerminal(getConnectableEditPart().mapConnectionAnchorToTerminal(sourceAnchor));
	SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
	sbbCommand.setEdgeAdapter(getViewAdapter());
	cc.compose(createCommand);
	cc.compose(sceCommand);
	cc.compose(scaCommand);
	cc.compose(sbbCommand);
	Command c = new ICommandProxy(cc);
	request.setStartCommand(c);
	return c;
    }

    public Command getCommand(Request request) {
	if (RequestConstants.REQ_CONNECTION_START.equals(request.getType())) {
	  if (request instanceof DgtsCreateUnspecifiedTypeConnectionRequest) {
		return getUnspecifiedConnectionCreateCommand((DgtsCreateUnspecifiedTypeConnectionRequest) request);
	    }
	} else if (RequestConstants.REQ_CONNECTION_END.equals(request.getType())) {
	   if (request instanceof DgtsCreateUnspecifiedTypeConnectionRequest) {
		return getUnspecifiedConnectionCompleteCommand((DgtsCreateUnspecifiedTypeConnectionRequest) request);
	    }
	}
	return super.getCommand(request);
    }

    /**
     * Gets the command to start the creation of a new connection and
     * relationship. This will update the request appropriately.
     * 
     * @param request
     * @return Command
     */
    protected Command getConnectionAndRelationshipCreateCommand(CreateConnectionViewAndElementRequest request) {
	// get the element descriptor
	CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
	// get the semantic request
	CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
	// complete the semantic request by filling in the source
	View sourceView = (View) getHost().getModel();
	createElementRequest.setSource(ViewUtil.resolveSemanticElement(sourceView));
	// get the create element request based on the elementdescriptor's
	// request
	Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class), request.getExtendedData()));
	// if element cannot be created, ignore
	if (createElementCommand == null || !createElementCommand.canExecute()) {
	    // Even if the command is not executable, status information may be
	    // set.
	    return createElementCommand;
	}

	return getConnectionCreateCommand(request);
    }

    /**
     * Gets the command to start the creation of a new connection and
     * relationship (if applicable) for a unspecified type request. This will
     * update all the individual requests appropriately.
     * 
     * @param request
     *            the unspecified type request
     * @return the command
     */
    private Command getUnspecifiedConnectionCreateCommand(final DgtsCreateUnspecifiedTypeConnectionRequest request) {

	if (request.isDirectionReversed()) {
	    return new Command() {

		/**
		 * All we know is the target and the possible relationship
		 * types. At this point, there is no way to validate the
		 * commands for this scenario.
		 */
		public boolean canExecute() {
		    return true;
		}
	    };
	} else {

	    // Get the start command for each individual request, this will
	    // update each request as required.
	    final List commands = new ArrayList();
	    for (Iterator iter = request.getAllRequests().iterator(); iter.hasNext();) {
		Request individualRequest = (Request) iter.next();
		Command cmd = null;
		if (individualRequest instanceof CreateConnectionViewAndElementRequest) {
		    cmd = getConnectionAndRelationshipCreateCommand((CreateConnectionViewAndElementRequest) individualRequest);
		} else if (individualRequest instanceof CreateConnectionViewRequest) {
		    cmd = getConnectionCreateCommand((CreateConnectionViewRequest) individualRequest);
		}
		if (cmd != null && cmd.canExecute()) {
		    commands.add(cmd);
		}
	    }

	    if (commands.isEmpty()) {
		// GEF's AbstractConnectionCreationTool expects a null command
		// when the gesture should be disabled.
		return null;
	    }

	    // return an executable command that does nothing
	    return new Command() {/* do nothing */
	    };
	}
    }

    /**
     * Gets the command to complete the creation of a new connection and
     * relationship.
     * 
     * @param request
     * @return Command
     */
    protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
	// get the element descriptor
	CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
	// get the semantic request
	CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);

	createElementRequest.setPrompt(!request.isUISupressed());

	// complete the semantic request by filling in the source and
	// destination
	INodeEditPart targetEP = getConnectionCompleteEditPart(request);
	View sourceView = (View) request.getSourceEditPart().getModel();
	View targetView = (View) targetEP.getModel();

	// resolve the source
	EObject source = ViewUtil.resolveSemanticElement(sourceView);
	if (source == null) {
	    source = sourceView;
	}
	createElementRequest.setSource(source);

	// resolve the target
	EObject target = ViewUtil.resolveSemanticElement(targetView);
	if (target == null) {
	    target = targetView;
	}
	createElementRequest.setTarget(target);

	// get the create element request based on the elementdescriptor's
	// request
	Command createElementCommand = targetEP.getCommand(new EditCommandRequestWrapper((CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class), request.getExtendedData()));

	// create the create semantic element wrapper command
	if (null == createElementCommand)
	    return null;

	SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
	// get the view command
	Command viewCommand = getConnectionCompleteCommand(request);
	if (null == viewCommand)
	    return null;
	// form the compound command and return
	CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
	cc.compose(semanticCommand);
	cc.compose(new CommandProxy(viewCommand));
	return new ICommandProxy(cc);
    }

    /**
     * Gets the command to complete the creation of a new connection and
     * relationship (if applicable) for an unspecified type request. This
     * command includes a command to popup a menu to prompt the user for the
     * type of connection to be created.
     * 
     * @param request
     *            the unspecified type request
     * @return the command
     */
    protected Command getUnspecifiedConnectionCompleteCommand(DgtsCreateUnspecifiedTypeConnectionRequest request) {

	if (request.isDirectionReversed()) {
	    return getReversedUnspecifiedConnectionCompleteCommand(request);
	}

	List menuContent = getConnectionMenuContent(request);

	if (menuContent.isEmpty()) {
	    return null;
	} else if (menuContent.size() == 1) {
	    return getConnectionCompleteCommand(menuContent.get(0), request);
	} else {
	    return new ICommandProxy(getPromptAndCreateConnectionCommand(menuContent, request));
	}
    }

    /**
     * Gets a command that pops up a menu which allows the user to select which
     * type of connection to be created and then creates the connection.
     * 
     * @param content
     *            The list of items making up the content of the popup menu.
     * @param request
     *            The relevant create connection request.
     * @return the command to popup up the menu and create the connection
     */
    protected ICommand getPromptAndCreateConnectionCommand(List content, CreateConnectionRequest request) {
	return new PromptAndCreateConnectionCommand(content, request);
    }

    /**
     * Gets the command to create a connection based on the request and the
     * connection identifier. This method is called after the user has selected
     * the connection to be created when presented with a popup.
     * 
     * @see #getPromptAndCreateConnectionCommand(List, CreateConnectionRequest)
     * 
     * @param connectionType
     *            the connection type as specified in
     *            {@link #getConnectionMenuContent(CreateConnectionRequest)}
     * @param request
     *            the request, identifying the source and target
     * @return the command to create the connection
     */
    protected Command getConnectionCompleteCommand(Object connectionType, CreateConnectionRequest request) {
	if (connectionType instanceof IElementType) {
	    if (request instanceof DgtsCreateUnspecifiedTypeConnectionRequest) {
		CreateRequest createRequest = ((DgtsCreateUnspecifiedTypeConnectionRequest) request).getRequestForType((IElementType) connectionType);
		if (createRequest != null) {
		    return getHost().getCommand(createRequest);
		}
	    }
	}
	return null;
    }

    /**
     * Gets a list of all the connector items that will represent the connector
     * choices and will appear in the popup menu. This method will get the
     * connector content if the given request is a
     * <code>CreateUnspecifiedTypeConnectionRequest</code> using the types it
     * holds or the types retrieved from the Modeling Assistant Service.
     * 
     * <p>
     * If a subclass wishes to provide additional element types they should
     * consider providing these in a Modeling Assistant Provider. If a subclass
     * wishes to provide connector choices that are not elements types they may
     * provide them here, in this case, the label provider for
     * {@link PromptAndCreateConnectionCommand} may need to customized.
     * </p>
     * 
     * @return the list of connector items to appear in the popup menu
     */
    protected List getConnectionMenuContent(CreateConnectionRequest request) {
	List validRelTypes = new ArrayList();
	if (request instanceof DgtsCreateUnspecifiedTypeConnectionRequest) {
	    DgtsCreateUnspecifiedTypeConnectionRequest unspecifiedRequest = (DgtsCreateUnspecifiedTypeConnectionRequest) request;
	    List allRequests = unspecifiedRequest.getAllRequests();
	    if (allRequests.isEmpty()) {
		return null;
	    }
	    IGraphicalEditPart sourceEP = (IGraphicalEditPart) ((CreateConnectionRequest) allRequests.get(0)).getSourceEditPart();
	    IGraphicalEditPart targetEP = (IGraphicalEditPart) ((CreateConnectionRequest) allRequests.get(0)).getTargetEditPart();

	    List allRelTypes = unspecifiedRequest.useModelingAssistantService() ? CustomModelingAssistantService.getInstance().getRelTypesOnSourceAndTarget(sourceEP, targetEP) : unspecifiedRequest.getElementTypes();

	    for (Iterator iter = allRelTypes.iterator(); iter.hasNext();) {
		IElementType type = (IElementType) iter.next();

		Command individualCmd = null;

		Request createConnectionRequest = unspecifiedRequest.getRequestForType(type);
		if (createConnectionRequest != null) {
		    individualCmd = getHost().getCommand(createConnectionRequest);

		    if (individualCmd != null && individualCmd.canExecute()) {
			validRelTypes.add(type);
		    }
		} else {
		    // This type may not have been given when the connection
		    // creation occurred. In this case, use the deferred
		    // connection creation mechanism.

		    // First, setup the request to initialize the connection
		    // start command.
		    CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
		    connectionRequest.setSourceEditPart(null);
		    connectionRequest.setTargetEditPart(sourceEP);
		    connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		    sourceEP.getCommand(connectionRequest);

		    // Now, setup the request in preparation to get the
		    // connection end
		    // command.
		    connectionRequest.setSourceEditPart(sourceEP);
		    connectionRequest.setTargetEditPart(targetEP);
		    connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
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

    /**
     * Gets the command to complete the creation of a new connection and
     * relationship (if applicable) for an unspecified type request. This
     * command includes a command to popup a menu to prompt the user for the
     * type of relationship to be created.
     * 
     * @param request
     *            the reversed unspecified type request
     * @return the command
     */
    protected Command getReversedUnspecifiedConnectionCompleteCommand(DgtsCreateUnspecifiedTypeConnectionRequest request) {
	EditPart realSourceEP = request.getTargetEditPart();
	EditPart realTargetEP = request.getSourceEditPart();
	for (Iterator iter = request.getAllRequests().iterator(); iter.hasNext();) {
	    CreateConnectionRequest connectionRequest = (CreateConnectionRequest) iter.next();

	    // First, setup the request to initialize the connection start
	    // command.
	    connectionRequest.setSourceEditPart(null);
	    connectionRequest.setTargetEditPart(realSourceEP);
	    connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
	    realSourceEP.getCommand(connectionRequest);

	    // Now, setup the request in preparation to get the connection end
	    // command.
	    connectionRequest.setSourceEditPart(realSourceEP);
	    connectionRequest.setTargetEditPart(realTargetEP);
	    connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
	}

	// The requests are now ready to be sent to get the connection end
	// command from real source to real target.
	request.setDirectionReversed(false);
	Command command = realTargetEP.getCommand(request);
	return command;
    }

    private TransactionalEditingDomain getEditingDomain() {
	return ((IGraphicalEditPart) getHost()).getEditingDomain();
    }
}
