package org.eclipse.papyrus.dgts.wizards.pages;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.dnd.SimpleObjectTransfer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizards.AddDiagramWizard;
import org.eclipse.papyrus.dgts.wizards.utility.ElementRequests;
import org.eclipse.papyrus.dgts.wizards.utility.SelectionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;

public class DgtsGlobalPage extends WizardPage {

    // Constants
    private static final int WIDTH_DRAWER_SELECTION = 200;
    private static final int WIDTH_TOOL_SELECTION = 200;
    private static final int WIDTH_DIAGRAM_SELECTION = 200;
    private static final int HEIGHT_DRAWER_SELECTION = 100;
    private static final int HEIGHT_TOOL_SELECTION = 100;
    private static final int HEIGHT_DIAGRAM_SELECTION = 100;

    // Types for Transfer :
    private String DIAGRAM_TYPE = "DiagramType";
    private String DRAWER_TYPE = "DrawerType";
    private String TOOL_TYPE = "ToolType";

    // TODO change the way we get the resource
    protected Resource myResource = SelectionHelper.getResourceFromSelection();
    protected ToolsProvider toolsProvider = new ToolsProvider();
    private Composite container;
    protected DiagramGlobalToolDefinition globalDiag;

    private ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

    // swt elements
    private Group groupToolSelection;
    private Button addDiagramButton;
    private Button addDrawerButton;
    private Button deleteDrawerButton;
    private Button addToolButton;
    private Button deleteToolButton;
    private Button browseDrawerIcon;
    private Button browseToolIcon;
    
    	private Button popupCheckBox ;
	private Button paletteCheckBox; 
	private Button menuCheckBox;
	private Button isEdgeCheckBox;

    private Label labelDrawerIcon;
    private Label labelDrawerName;
    private Label labelToolIcon;
    private Label labelToolName;

    private Text drawerName;
    private Text drawerIcon;
    private Text toolName;
    private Text toolIcon;
    private TableViewer diagramSelectionTableViewer;
    private TableViewer drawerSelectionTableViewer;
    private TableViewer toolSelectionTableViewer;

    // current state of the wizard
    private DiagramDefinition currentSelectedDiagram;
    private DrawerDefinition currentSelectedDrawer;
    private Tool currentSelectedTool;

    protected Tool getCurrentSelectedTool() {
	return currentSelectedTool;
    }

    protected void setCurrentSelectedTool(Tool currentSelectedTool) {
	this.currentSelectedTool = currentSelectedTool;
    }

    protected DrawerDefinition getCurrentSelectedDrawer() {
	return currentSelectedDrawer;
    }

    protected void setCurrentSelectedDrawer(DrawerDefinition currentSelectedDrawer) {
	this.currentSelectedDrawer = currentSelectedDrawer;
    }

    protected DiagramDefinition getCurrentDiagram() {
	return currentSelectedDiagram;
    }

    protected void setCurrentDiagram(DiagramDefinition diag) {
	this.currentSelectedDiagram = diag;
    }

    public DgtsGlobalPage() {
	super("Tools Configuration Helper");

	setTitle("Tools Configuration Helper");

	setDescription("Tools Configuration Helper");
    }

    @Override
    public void createControl(Composite parent) {

	container = new Composite(parent, SWT.NONE);
	GridLayout layout = new GridLayout();
	container.setLayout(layout);
	layout.numColumns = 3;
	setControl(container);

	createDiagramSelectionForm(container);
	globalDiag = toolsProvider.getDiagramGlobalToolDefinitionFromResource(myResource);
	diagramSelectionTableViewer.setInput(globalDiag);

	createDrawerSelectionForm(container);
	drawerSelectionTableViewer.setInput(getCurrentDiagram());
	createToolSelectionForm(container);
	toolSelectionTableViewer.setInput(getCurrentSelectedDrawer());

	setPageComplete(false);

    }

    protected void createToolSelectionForm(Composite composite) {

	Group group = createGroup(composite, "Select a tool");
	groupToolSelection = createGroup(group, "");
	GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
	selectionData.heightHint = HEIGHT_TOOL_SELECTION;
	// Drawer Selection
	final Table toolSelectionTable = new Table(groupToolSelection, SWT.NO_BACKGROUND);
	final TableColumn toolSelectionColumn = new TableColumn(toolSelectionTable, SWT.NO_BACKGROUND);
	toolSelectionTable.setLayoutData(selectionData);
	toolSelectionTable.setFont(groupToolSelection.getFont());
	toolSelectionTable.setBackground(groupToolSelection.getBackground());
	toolSelectionColumn.setWidth(WIDTH_TOOL_SELECTION);

	toolSelectionTable.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		if (e.item.getData() instanceof Tool) {
		    handlerToolSelected((Tool) e.item.getData());
		}
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});

	toolSelectionTableViewer = new TableViewer(toolSelectionTable);
	toolSelectionTableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	toolSelectionTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

	Transfer[] types = new Transfer[] { new MyObjectTransfer(new String[] { TOOL_TYPE }) };
	addDragSupport(types, toolSelectionTableViewer);
	addDropSupportForTool(types);

	// Tool Name
	labelToolName = new Label(groupToolSelection, SWT.NONE);
	labelToolName.setText("Tool Name : ");
	toolName = new Text(groupToolSelection, SWT.BORDER | SWT.SINGLE);
	toolName.setText("");
	toolName.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent e) {

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		getCurrentSelectedTool().setName(toolName.getText());
		toolSelectionTableViewer.setInput(getCurrentSelectedDrawer());

	    }

	});

	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	toolName.setLayoutData(gd);

	// Tool Icon
	labelToolIcon = new Label(groupToolSelection, SWT.NONE);
	labelToolIcon.setText("Tool Icon (absolute path) : ");
	toolIcon = new Text(groupToolSelection, SWT.BORDER | SWT.SINGLE);
	toolIcon.setText("");
	toolIcon.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent e) {

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		handleChangeToolIcon(toolIcon.getText());
	    }

	});
	GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
	toolIcon.setLayoutData(gd2);

	// Browse Icon
	browseToolIcon = new Button(groupToolSelection, SWT.PUSH);
	browseToolIcon.setText("Browse Icon");
	browseToolIcon.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.NULL);
		String path = dialog.open();
		if (path != null) {
		    handleChangeToolIcon(path);
		    toolIcon.setText(path);
		}
	    }
	});

	browseToolIcon.setLayoutData(gd2);

	// Is Edge

	isEdgeCheckBox = new Button(groupToolSelection, SWT.CHECK);
	isEdgeCheckBox.setText("Is Edge");
	isEdgeCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (isEdgeCheckBox.getSelection()) {
		    getCurrentSelectedTool().setIsEdge(true);
		}
		else {
		    getCurrentSelectedTool().setIsEdge(false);
		}

	    }
	});


	//popup
	popupCheckBox = new Button(groupToolSelection, SWT.CHECK);
	popupCheckBox.setText("Popup");
	popupCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (popupCheckBox.getSelection()) {
		    getCurrentSelectedTool().setSetPopup(true);
		}
		else {
		    getCurrentSelectedTool().setSetPopup(false);
		}

	    }
	});

	//palette
	paletteCheckBox = new Button(groupToolSelection, SWT.CHECK);
	paletteCheckBox.setText("Palette");
	paletteCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (paletteCheckBox.getSelection()) {
		    getCurrentSelectedTool().setSetPalette(true);
		}
		else {
		    getCurrentSelectedTool().setSetPalette(false);
		}

	    }
	});
	
	//menu
	menuCheckBox = new Button(groupToolSelection, SWT.CHECK);
	menuCheckBox.setText("Menu");
	menuCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (menuCheckBox.getSelection()) {
		    getCurrentSelectedTool().setSetMenu(true);
		}
		else {
		    getCurrentSelectedTool().setSetMenu(false);
		}

	    }
	});
	
	
	
	Group groupActions = createGroup(group, "");
	// Add Tool
	addToolButton = new Button(groupActions, SWT.PUSH);
	addToolButton.setText("Add Tool");
	addToolButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (getCurrentDiagram() != null) {
		    ElementRequests.addTool(getCurrentSelectedDrawer());
		    toolSelectionTableViewer.setInput(getCurrentSelectedDrawer());
		    toolSelectionTableViewer.getTable().setSelection(toolSelectionTableViewer.getTable().getItemCount() - 1);
		    setDefaultToolSelection(getCurrentSelectedDrawer());
		}

	    }

	});

	// delete
	deleteToolButton = new Button(groupActions, SWT.PUSH);
	deleteToolButton.setText("Delete Tool");
	deleteToolButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (getCurrentSelectedTool() != null) {
		    ElementRequests.deleteTool(getCurrentSelectedTool());
		    toolSelectionTableViewer.setInput(getCurrentSelectedDrawer());
		    setDefaultToolSelection(getCurrentSelectedDrawer());
		}

	    }

	});
	setToolEditionVisilble(false);
    }

    private void addDropSupportForTool(Transfer[] types) {
	toolSelectionTableViewer.addDropSupport(DND.DROP_MOVE, types, new ViewerDropAdapter(toolSelectionTableViewer) {
	    @Override
	    public boolean performDrop(Object data) {
		if (data instanceof Tool) {
		    Tool source = (Tool) data;
		    if (getCurrentTarget() instanceof Tool) {
			Tool target = (Tool) getCurrentTarget();
			// Move the tool :
			int targetPosition = getCurrentSelectedDrawer().getToolRef().indexOf(target);
			getCurrentSelectedDrawer().getToolRef().move(targetPosition, source);
			toolSelectionTableViewer.setInput(getCurrentSelectedDrawer());
		    }
		}
		return false;
	    }

	    @Override
	    public boolean validateDrop(Object target, int operation, TransferData transferType) {
		if (operation == DND.DROP_MOVE) {
		    if (target instanceof Tool) {
			return true;

		    }
		}
		return false;
	    }
	});

    }

    protected void createDrawerSelectionForm(Composite composite) {
	final Group group = createGroup(composite, "Select a drawer");
	GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
	selectionData.heightHint = HEIGHT_DRAWER_SELECTION;
	// Drawer Selection
	final Table drawerSelectionTable = new Table(group, SWT.NO_BACKGROUND);
	final TableColumn drawerSelectionColumn = new TableColumn(drawerSelectionTable, SWT.NO_BACKGROUND);
	drawerSelectionTable.setFont(group.getFont());
	drawerSelectionTable.setBackground(group.getBackground());
	drawerSelectionColumn.setWidth(WIDTH_DRAWER_SELECTION);
	drawerSelectionTable.setLayoutData(selectionData);
	drawerSelectionTable.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		if (e.item.getData() instanceof DrawerDefinition) {
		    handlerDrawerSelected((DrawerDefinition) e.item.getData());
		}
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});

	drawerSelectionTableViewer = new TableViewer(drawerSelectionTable);
	drawerSelectionTableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	drawerSelectionTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

	Transfer[] types = new Transfer[] { new MyObjectTransfer(new String[] { DRAWER_TYPE }) };
	addDragSupport(types, drawerSelectionTableViewer);
	addDropSupportForDrawer(types);

	// Drawer Name
	labelDrawerName = new Label(group, SWT.NONE);
	labelDrawerName.setText("Drawer Name : ");
	drawerName = new Text(group, SWT.BORDER | SWT.SINGLE);
	drawerName.setText("");
	drawerName.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent e) {

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		getCurrentSelectedDrawer().setName(drawerName.getText());
		drawerSelectionTableViewer.setInput(getCurrentDiagram());

	    }

	});

	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	drawerName.setLayoutData(gd);

	// Drawer Icon
	labelDrawerIcon = new Label(group, SWT.NONE);
	labelDrawerIcon.setText("Drawer Icon (absolute path) : ");
	drawerIcon = new Text(group, SWT.BORDER | SWT.SINGLE);
	drawerIcon.setText("");
	drawerIcon.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent e) {

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {

		handleChangeDrawerIcon(drawerIcon.getText());
	    }

	});
	GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
	drawerIcon.setLayoutData(gd2);

	// Browse Icon
	browseDrawerIcon = new Button(group, SWT.PUSH);
	browseDrawerIcon.setText("Browse Icon");
	browseDrawerIcon.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.NULL);
		String path = dialog.open();
		if (path != null) {
		    handleChangeDrawerIcon(path);
		    drawerIcon.setText(path);
		}
	    }
	});

	browseDrawerIcon.setLayoutData(gd2);

	// Add Drawer
	addDrawerButton = new Button(group, SWT.PUSH);
	addDrawerButton.setText("Add Drawer");
	addDrawerButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (getCurrentDiagram() != null) {
		    ElementRequests.addDrawer(getCurrentDiagram());
		    drawerSelectionTableViewer.setInput(getCurrentDiagram());
		    drawerSelectionTableViewer.getTable().setSelection(drawerSelectionTableViewer.getTable().getItemCount() - 1);
		    setDefaultDrawerSelection(getCurrentDiagram());
		}

	    }

	});

	// delete
	deleteDrawerButton = new Button(group, SWT.PUSH);
	deleteDrawerButton.setText("Delete Drawer");
	deleteDrawerButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (getCurrentSelectedDrawer() != null) {
		    ElementRequests.deleteDrawer(getCurrentSelectedDrawer());
		    drawerSelectionTableViewer.setInput(getCurrentDiagram());
		    setDefaultDrawerSelection(getCurrentDiagram());
		}

	    }

	});
	setDrawerEditionVisilble(false);
    }

    protected void addDropSupportForDrawer(Transfer[] types) {
	drawerSelectionTableViewer.addDropSupport(DND.DROP_MOVE | DND.DROP_COPY, types, new ViewerDropAdapter(drawerSelectionTableViewer) {
	    @Override
	    public boolean performDrop(Object data) {
		if (data instanceof DrawerDefinition) {
		    DrawerDefinition source = (DrawerDefinition) data;
		    if (getCurrentTarget() instanceof DrawerDefinition) {
			DrawerDefinition target = (DrawerDefinition) getCurrentTarget();
			// Move the drawer :
			int targetPosition = getCurrentDiagram().getDrawerDefinitionRef().indexOf(target);
			getCurrentDiagram().getDrawerDefinitionRef().move(targetPosition, source);
			drawerSelectionTableViewer.setInput(getCurrentDiagram());
		    }
		}
		return false;
	    }

	    @Override
	    public boolean validateDrop(Object target, int operation, TransferData transferType) {
		if (operation == DND.DROP_MOVE) {
		    if (target instanceof DrawerDefinition) {
			return true;
		    }
		} else if (operation == DND.DROP_COPY) {
		    System.out.println("bim");
		}
		return false;
	    }
	});
    }

    protected void createDiagramSelectionForm(Composite composite) {
	Group group = createGroup(composite, "Select a diagram");
	GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
	selectionData.heightHint = HEIGHT_DIAGRAM_SELECTION;
	final Table diagramSelectionTable = new Table(group, SWT.NO_BACKGROUND | SWT.FULL_SELECTION);
	diagramSelectionTable.setFont(group.getFont());
	diagramSelectionTable.setBackground(group.getBackground());
	diagramSelectionTable.setLayoutData(selectionData);
	diagramSelectionTable.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */

	    public void widgetSelected(SelectionEvent e) {
		if (e.item.getData() instanceof DiagramDefinition) {
		    DiagramDefinition diag = (DiagramDefinition) e.item.getData();
		    setCurrentDiagram(diag);
		    drawerSelectionTableViewer.setInput(getCurrentDiagram());
		    setDefaultDrawerSelection(diag);

		}

	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});
	diagramSelectionTableViewer = new TableViewer(diagramSelectionTable);
	diagramSelectionTableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	diagramSelectionTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

	Transfer[] types = new Transfer[] { new MyObjectTransfer(new String[] { DIAGRAM_TYPE }) };
	addDragSupport(types, diagramSelectionTableViewer);
	addDropSupportForDiagram(types);

	// Add Diagram
	addDiagramButton = new Button(group, SWT.PUSH);
	addDiagramButton.setText("Add Diagram");
	addDiagramButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {

		// Create an AddDiagramWizard
		AddDiagramWizard newWizard = new AddDiagramWizard();
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), newWizard);
		if (dialog.open() == WizardDialog.OK) {
		    List<AddCommand> cmds = newWizard.getCommands();
		    if (!cmds.isEmpty()) {

			for (AddCommand cmd : cmds) {
			    if (cmd != null && cmd.canExecute()) {
				newWizard.getEditingDomain().getCommandStack().execute(cmd);

			    }
			}
		    }

		}

		// Refresh
		diagramSelectionTableViewer.setInput(globalDiag);

	    }

	});

    }

    protected void addDropSupportForDiagram(Transfer[] types) {
	diagramSelectionTableViewer.addDropSupport(DND.DROP_MOVE, types, new ViewerDropAdapter(diagramSelectionTableViewer) {
	    @Override
	    public boolean performDrop(Object data) {
		if (data instanceof DiagramDefinition) {
		    DiagramDefinition source = (DiagramDefinition) data;
		    if (getCurrentTarget() instanceof DiagramDefinition) {
			DiagramDefinition target = (DiagramDefinition) getCurrentTarget();
			// Move the diagram :
			int targetPosition = globalDiag.getDiagramDefinitionRef().indexOf(target);
			globalDiag.getDiagramDefinitionRef().move(targetPosition, source);
			diagramSelectionTableViewer.setInput(globalDiag);
		    }
		}

		return false;
	    }

	    @Override
	    public boolean validateDrop(Object target, int operation, TransferData transferType) {
		if (operation == DND.DROP_MOVE) {
		    if (target instanceof DiagramDefinition) {

			return true;

		    }
		}
		return false;
	    }
	});
    }

    private static Group createGroup(Composite parent, String name) {

	Group group = new Group(parent, SWT.NONE);
	group.setText(name);
	Color color = new Color(null, 255, 255, 255);
	group.setBackground(color);
	group.setBackground(color);
	GridLayout layout = new GridLayout(1, false);
	layout.marginHeight = 5;
	layout.marginWidth = 5;
	group.setLayout(layout);
	GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	group.setLayoutData(data);
	return group;
    }

    private void setDrawerEditionVisilble(boolean visible) {
	labelDrawerIcon.setVisible(visible);
	labelDrawerName.setVisible(visible);
	drawerName.setVisible(visible);
	drawerIcon.setVisible(visible);
	browseDrawerIcon.setVisible(visible);

    }

    private void setToolEditionVisilble(boolean visible) {

	groupToolSelection.setVisible(visible);

    }

    protected void handlerDrawerSelected(DrawerDefinition drawer) {
	setCurrentSelectedDrawer(drawer);
	setDrawerEditionVisilble(true);
	drawerName.setText(drawer.getName());
	drawerIcon.setText("");
	if (drawer.getIconReference() != null) {
	    if (drawer.getIconReference().getIconPath() != null) {
		drawerIcon.setText(drawer.getIconReference().getIconPath());
	    }
	}

	toolSelectionTableViewer.setInput(drawer);
	setDefaultToolSelection(drawer);

    }

    private void handlerToolSelected(Tool tool) {
	setCurrentSelectedTool(tool);
	setToolEditionVisilble(true);
	if (tool.getName() != null){
	toolName.setText(tool.getName());
	}
	else{
	    toolName.setText("");
	}
	toolIcon.setText("");
	isEdgeCheckBox.setSelection(tool.isIsEdge());
	popupCheckBox.setSelection(tool.isSetPopup());
	paletteCheckBox.setSelection(tool.isSetPalette());
	menuCheckBox.setSelection(tool.isSetMenu());
	if (tool.getIconReference() != null) {
	    if (tool.getIconReference().getIconPath() != null) {
		toolIcon.setText(tool.getIconReference().getIconPath());
	    }
	}
    }

    protected void setDefaultDrawerSelection(DiagramDefinition diag) {
	// set the current selection on the first drawer
	if (!toolsProvider.getDrawers(diag).equals(Collections.emptyList())) {
	    int itemSelected = 0;
	    // if nothing is selected
	    if (drawerSelectionTableViewer.getTable().getSelectionIndex() == -1) {
		// selection the first element
		drawerSelectionTableViewer.getTable().setSelection(0);
	    }
	    itemSelected = drawerSelectionTableViewer.getTable().getSelectionIndex();
	    handlerDrawerSelected((DrawerDefinition) drawerSelectionTableViewer.getTable().getItem(itemSelected).getData());
	    setDrawerEditionVisilble(true);
	} else {
	    setCurrentSelectedDrawer(null);
	    setDrawerEditionVisilble(false);
	}
    }

    private void setDefaultToolSelection(DrawerDefinition drawer) {
	// set the current selection on the first drawer
	if (!toolsProvider.getTools(drawer).equals(Collections.emptyList())) {
	    int itemSelected = 0;
	    // if nothing is selected
	    if (toolSelectionTableViewer.getTable().getSelectionIndex() == -1) {
		// selection the first element
		toolSelectionTableViewer.getTable().setSelection(0);
	    }
	    itemSelected = toolSelectionTableViewer.getTable().getSelectionIndex();
	    handlerToolSelected((Tool) toolSelectionTableViewer.getTable().getItem(itemSelected).getData());
	    setToolEditionVisilble(true);
	} else {
	    setCurrentSelectedTool(null);
	    setToolEditionVisilble(false);
	}

    }

    protected void addDragSupport(Transfer[] types, TableViewer tableViewer) {
	tableViewer.addDragSupport(DND.DROP_MOVE, types, new DragSourceAdapter() {
	    @Override
	    public void dragSetData(DragSourceEvent event) {
		// Get the selected items in the drag source
		DragSource ds = (DragSource) event.widget;
		Table table = (Table) ds.getControl();
		TableItem[] selection = table.getSelection();
		event.data = selection[0].getData();
	    }
	});
    }

    protected void handleChangeDrawerIcon(String path) {
	if (path != "") {

	    if (getCurrentSelectedDrawer().getIconReference() == null) {
		ElementRequests.addIconReference(getCurrentSelectedDrawer());
	    }
	    if (getCurrentSelectedDrawer().getIconReference() != null) {
		getCurrentSelectedDrawer().getIconReference().setIconPath(path);
		drawerSelectionTableViewer.setInput(getCurrentDiagram());
	    }
	} else {
	    if (getCurrentSelectedDrawer().getIconReference() != null) {
		ElementRequests.deleteIconReference(getCurrentSelectedDrawer());
	    }
	}
    }

    protected void handleChangeToolIcon(String path) {
	if (path != "") {
	    if (getCurrentSelectedTool().getIconReference() == null) {
		ElementRequests.addIconReference(getCurrentSelectedTool());
	    }
	    if (getCurrentSelectedTool().getIconReference() != null) {
		getCurrentSelectedTool().getIconReference().setIconPath(path);
		toolSelectionTableViewer.setInput(getCurrentSelectedDrawer());
	    }
	} else {
	    if (getCurrentSelectedTool().getIconReference() != null) {
		ElementRequests.deleteIconReference(getCurrentSelectedTool());
	    }
	}
    }

    private class MyObjectTransfer extends SimpleObjectTransfer {
	private String[] myTypes;
	final int[] myTypeIds;

	public MyObjectTransfer(String[] types) {
	    super();
	    this.myTypes = types;
	    int[] typeIds = new int[types.length];
	    for (int i = 0; i < types.length; i++) {
		typeIds[i] = registerType(types[i]);
	    }
	    this.myTypeIds = typeIds;

	}

	@Override
	protected String[] getTypeNames() {

	    return myTypes;
	}

	@Override
	protected int[] getTypeIds() {
	    return myTypeIds;
	}

    }
}
