package org.eclipse.papyrus.dgts.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.dgts.service.DgtsElementTypeRegistry;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizards.utility.ElementRequests;
import org.eclipse.papyrus.dgts.wizards.utility.ElementTypeContentFinalProvider;
import org.eclipse.papyrus.dgts.wizards.utility.IElementTypeLabelProvider;
import org.eclipse.papyrus.dgts.wizards.utility.MyObjectTransfer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;
import ElementRegistry.EClassDefinition;
import ElementRegistry.ElementType;

public class MainTreeBloc {

    Color WHITE = new Color(null, 255, 255, 255);
    
    private static final int HEIGHT_IELEMENT_SELECTION = 150;
    private static final String ADD_DRAWER_TOOLTIP = "Add a drawer";
    private static final String DELETE_DRAWER_TOOLTIP = "Delete this drawer";
    private static final String DELETE_TOOL_TOOLTIP = "Delete this tool";
    private static final String ADD_TOOL_TOOLTIP = "Add a tool";

    private Button deleteElementButton;
    private Button addToolButton;
    private Button deleteToolButton;
    private Button addDrawerButton;
    private Button deleteDrawerButton;

    private ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    private int HEIGHT_MAIN_TREE = 200;
    TreeViewer mainTreeViewer;

    private Object currentTarget = null;
    private IElementType currentSelectedIElementType;
    private DrawerDefinition currentSelectedDrawer = null;
    private Tool currentSelectedTool = null;
    private EditBloc editBloc;

    private TableViewer elementTypeFinalTableViewer;

    public EditBloc getEditBloc() {
	return editBloc;
    }

    public void setEditBloc(EditBloc editBloc) {
	this.editBloc = editBloc;
    }

    protected Object getCurrentTarget() {
	return currentTarget;
    }

    protected void setCurrentTarget(Object target) {
	currentTarget = target;
	if (currentTarget instanceof Tool) {
	    Tool tool = (Tool) currentTarget;
	    currentSelectedTool = tool;
	    currentSelectedDrawer = null;
	    editBloc.setCurrentSelectedTool(tool);
	    editBloc.setCurrentSelectedDrawer(null);
	} else if (currentTarget instanceof DrawerDefinition) {
	    DrawerDefinition drawer = (DrawerDefinition) currentTarget;
	    currentSelectedDrawer = drawer;
	    currentSelectedTool = null;
	    editBloc.setCurrentSelectedTool(null);
	    editBloc.setCurrentSelectedDrawer(drawer);
	}
	else{
	    currentSelectedTool = null;
	    currentSelectedDrawer = null;
	    currentSelectedTool = null;
	    editBloc.setCurrentSelectedTool(null);
	    editBloc.setCurrentSelectedDrawer(null);
	    
	}

	refreshToolBar();
	editBloc.refreshBloc();
	refreshIElementTypeBloc();

    }

    private void refreshToolBar() {
	if (currentTarget instanceof Tool) {
	    addDrawerButton.setEnabled(true);
	    addToolButton.setEnabled(true);
	    deleteToolButton.setEnabled(true);
	    deleteDrawerButton.setEnabled(false);
	} else if (currentTarget instanceof DrawerDefinition) {
	    addDrawerButton.setEnabled(true);
	    addToolButton.setEnabled(true);
	    deleteToolButton.setEnabled(false);
	    deleteDrawerButton.setEnabled(true);
	} else {
	    addDrawerButton.setEnabled(true);
	    addToolButton.setEnabled(false);
	    deleteToolButton.setEnabled(false);
	    deleteDrawerButton.setEnabled(false);
	}

    }
    public void disableToolBar(){
		addDrawerButton.setEnabled(false);
	    addToolButton.setEnabled(false);
	    deleteToolButton.setEnabled(false);
	    deleteDrawerButton.setEnabled(false);
    }

    static String TOOL = "Tool";
    private static Transfer[] transfer = new Transfer[] { new MyObjectTransfer(new String[] { TOOL }) };

    public static Transfer[] getTransfer() {
	return transfer;
    }

    public MainTreeBloc(Composite container) {

	Group group = DgtsGlobalPage.createGroup(container, "My Tools");
	mainTreeViewer = createMainTreeForm(group);
	createIElementTypeFinalForm(group);

    }

    public void refreshBloc(DiagramDefinition diagram) {
	if (diagram != null) {
	    Object[] expand = mainTreeViewer.getExpandedElements();
	    mainTreeViewer.setInput(diagram);
	    mainTreeViewer.setExpandedElements(expand);
	    refreshToolBar();
	}

    }

    public TreeViewer createMainTreeForm(Group group) {

	
	   

	    

	   

	
	
	Composite groupButton = new Composite(group,SWT.NONE);
	groupButton.setBackground(WHITE);
	GridLayout toolBarLayout = new GridLayout(4, true);
	groupButton.setLayout(toolBarLayout);
	// Add Drawer
	addDrawerButton = new Button(groupButton, SWT.PUSH);
	Image addDrawerImage = new Image(null,getClass().getResourceAsStream("../icons/drawerAdd.png"));
	addDrawerButton.setImage(addDrawerImage);
	addDrawerButton.setToolTipText(ADD_DRAWER_TOOLTIP);
	addDrawerButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (DgtsGlobalPage.getCurrentDiagram() != null) {
		    ElementRequests.addDrawer(DgtsGlobalPage.getCurrentDiagram());
		    refreshBloc(DgtsGlobalPage.getCurrentDiagram());
		    // TODO set the selection on the current drawer
		    // drawerSelectionTableViewer.getTable().setSelection(drawerSelectionTableViewer.getTable().getItemCount()
		    // - 1);
		    // setDefaultDrawerSelection(getCurrentDiagram());
		}

	    }

	});

	// delete drawer
	deleteDrawerButton = new Button(groupButton, SWT.PUSH);
	
	Image deleteDrawerImage = new Image(null,getClass().getResourceAsStream("../icons/drawerDelete.png"));
	deleteDrawerButton.setImage(deleteDrawerImage);
	deleteDrawerButton.setToolTipText(DELETE_DRAWER_TOOLTIP);
	deleteDrawerButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (currentTarget instanceof DrawerDefinition) {
		    ElementRequests.deleteDrawer((DrawerDefinition) currentTarget);
		    setCurrentTarget(null);
		    refreshBloc(DgtsGlobalPage.getCurrentDiagram());
		    

		}

	    }

	});

	// Add Tool
	addToolButton = new Button(groupButton, SWT.PUSH);
	Image addToolImage = new Image(null,getClass().getResourceAsStream("../icons/toolAdd.png"));
	addToolButton.setImage(addToolImage);
	addToolButton.setToolTipText(ADD_TOOL_TOOLTIP);
	addToolButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (DgtsGlobalPage.getCurrentDiagram() != null) {
		    DrawerDefinition drawer = null;
		    if (currentTarget instanceof DrawerDefinition) {
			drawer = (DrawerDefinition) currentTarget;
		    } else if (currentTarget instanceof Tool) {
			drawer = (DrawerDefinition) (((Tool) currentTarget).eContainer());
		    }
		    if (drawer != null) {
			ElementRequests.addTool(drawer);
		    }
		    refreshBloc(DgtsGlobalPage.getCurrentDiagram());

		    // TODO : select the element created
		}

	    }

	});

	// delete tool
	deleteToolButton = new Button(groupButton, SWT.PUSH);
	Image deleteToolImage = new Image(null,getClass().getResourceAsStream("../icons/toolDelete.png"));
	deleteToolButton.setImage(deleteToolImage);
	deleteToolButton.setToolTipText(DELETE_TOOL_TOOLTIP);
	deleteToolButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (currentTarget != null) {
		    if (currentTarget instanceof Tool) {
			ElementRequests.deleteTool((Tool) currentTarget);
			setCurrentTarget(null);
			refreshBloc(DgtsGlobalPage.getCurrentDiagram());
		    }
		}

	    }

	});

	Group groupElementSelection = DgtsGlobalPage.createGroup(group, "");

	GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
	selectionData.heightHint = HEIGHT_MAIN_TREE;

	final Tree mainTree = new Tree(groupElementSelection, SWT.NO_BACKGROUND);

	mainTree.setLayoutData(selectionData);
	mainTree.setFont(groupElementSelection.getFont());
	mainTree.setBackground(groupElementSelection.getBackground());

	mainTree.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		handleSelection(e.item.getData());
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});

	mainTreeViewer = new TreeViewer(mainTree);
	mainTreeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	mainTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
	mainTreeViewer.addDragSupport(DND.DROP_MOVE, transfer, new DragSourceAdapter() {

	    @Override
	    public void dragSetData(DragSourceEvent event) {
		DragSource ds = (DragSource) event.widget;
		Tree tree = (Tree) ds.getControl();
		TreeItem[] selection = tree.getSelection();
		if (selection[0].getData() instanceof DrawerDefinition) {
		    event.data = (DrawerDefinition) selection[0].getData();
		} else if (selection[0].getData() instanceof Tool) {
		    event.data = (Tool) selection[0].getData();
		}
	    }
	});

	mainTreeViewer.addDropSupport(DND.DROP_MOVE, transfer, new ViewerDropAdapter(mainTreeViewer) {
	    @Override
	    public boolean performDrop(Object data) {
		if (data instanceof Tool) {
		    Tool source = (Tool) data;
		    if (getCurrentTarget() instanceof Tool) {
			Tool target = (Tool) getCurrentTarget();

			// The source and target are in the same drawer
			if (source.eContainer() == target.eContainer()) {
			    // Move the tool :
			    int targetPosition = ((DrawerDefinition) source.eContainer()).getToolRef().indexOf(target);
			    ((DrawerDefinition) source.eContainer()).getToolRef().move(targetPosition, source);
			} else {
			    // TODO
			    // delete the tool and add a tool in the new drawer
			    // ElementRequests.moveToolToDrawer(source,
			    // (DrawerDefinition)target.eContainer());
			    // int targetPosition =
			    // ((DrawerDefinition)source.eContainer()).getToolRef().indexOf(target);

			}
		    } else if ((getCurrentTarget() instanceof DrawerDefinition)) {
			// TODO
			// Move the tool to the drawer
		    }
		} else if (data instanceof EClassDefinition) {
		    EClassDefinition eclass = (EClassDefinition) data;
		    if (getCurrentTarget() instanceof Tool) {
			Tool target = (Tool) getCurrentTarget();

			ElementRequests.addNewToolFromEclass(eclass, ((DrawerDefinition) target.eContainer()));
		    } else if (getCurrentTarget() instanceof DrawerDefinition) {
			DrawerDefinition target = (DrawerDefinition) getCurrentTarget();
			ElementRequests.addNewToolFromEclass(eclass, target);
		    }
		}
		refreshBloc(DgtsGlobalPage.getCurrentDiagram());
		return false;
	    }

	    @Override
	    public boolean validateDrop(Object target, int operation, TransferData transferType) {
		if (operation == DND.DROP_MOVE) {
		    // if (target instanceof Tool) {
		    return true;

		    // }
		}
		return false;
	    }
	});

	return mainTreeViewer;
    }

    protected void handleSelection(Object data) {
	setCurrentTarget(data);
	deleteElementButton.setEnabled(false);

    }

    public void createIElementTypeFinalForm(Group group) {

	Group groupElementSelection = DgtsGlobalPage.createGroup(group, "IElement types");

	GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
	selectionData.heightHint = HEIGHT_IELEMENT_SELECTION;
	// Element Selection
	final Table elementSelectionTable = new Table(groupElementSelection, SWT.NO_BACKGROUND);
	
	elementSelectionTable.setLayoutData(selectionData);
	elementSelectionTable.setFont(groupElementSelection.getFont());
	elementSelectionTable.setBackground(groupElementSelection.getBackground());
	elementSelectionTable.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		if (e.item.getData() instanceof IElementType) {
		    
		    currentSelectedIElementType = (IElementType) e.item.getData();
		    deleteElementButton.setEnabled(true);
		}
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});

	elementTypeFinalTableViewer = new TableViewer(elementSelectionTable);
	addDropSupportForIElementType(MainTreeBloc.getTransfer());
	elementTypeFinalTableViewer.setContentProvider(new ElementTypeContentFinalProvider());
	elementTypeFinalTableViewer.setLabelProvider(new IElementTypeLabelProvider());

	// delete
	deleteElementButton = new Button(groupElementSelection, SWT.PUSH);
	Image deleteElementImage = new Image(null,getClass().getResourceAsStream("../icons/deleteElementIcon.png"));
	deleteElementButton.setImage(deleteElementImage);
	deleteElementButton.setToolTipText("Remove the selected IElementType");
	deleteElementButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseDoubleClick(MouseEvent e) {
	    }

	    @Override
	    public void mouseDown(MouseEvent e) {
	    }

	    @Override
	    public void mouseUp(MouseEvent e) {
		if (currentSelectedIElementType != null) {
		    ElementRequests.deleteIElementType(currentSelectedIElementType, currentSelectedTool);
		    refreshIElementTypeBloc();
		    currentSelectedIElementType=null;
		    deleteElementButton.setEnabled(false);
		}

	    }

	});

    }

    private void refreshIElementTypeBloc() {
	
	elementTypeFinalTableViewer.setInput(currentSelectedTool);
    }

    private void addDropSupportForIElementType(Transfer[] types) {
	elementTypeFinalTableViewer.addDropSupport(DND.DROP_MOVE, types, new ViewerDropAdapter(elementTypeFinalTableViewer) {
	    @Override
	    public boolean performDrop(Object data) {
		List<IElementType> sources = new ArrayList<IElementType>();

		if (data instanceof IElementType) {
		    sources.add((IElementType) data);
		    // just add the element type
		} else if (data instanceof EClassDefinition) {
		    for (ElementRegistry.ElementType type : ((EClassDefinition) data).getRefElementTypes()) {
			sources.add(ElementTypeRegistry.getInstance().getType(type.getElementTypeID()));
		    }
		}
		for (IElementType source : sources) {
		    ElementRequests.addElementType(currentSelectedTool, source);

		    if (getCurrentTarget() instanceof IElementType) {
			IElementType target = (IElementType) getCurrentTarget();
			// move the element type at the current position :

			ToolsProvider toolsProvider = new ToolsProvider();
			int targetPosition = toolsProvider.getIElementTypesFromTool(currentSelectedTool).indexOf(target);
			int sourcePosition = currentSelectedTool.getElementTypes().size() - 1;

			currentSelectedTool.getElementTypes().move(targetPosition, sourcePosition);
		    }
		}
		refreshIElementTypeBloc();

		return false;
	    }

	    @Override
	    public boolean validateDrop(Object target, int operation, TransferData transferType) {

		return true;
	    }
	});

    }

}
