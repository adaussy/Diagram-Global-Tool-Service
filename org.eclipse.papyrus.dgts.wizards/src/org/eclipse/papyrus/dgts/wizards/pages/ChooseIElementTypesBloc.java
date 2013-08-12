package org.eclipse.papyrus.dgts.wizards.pages;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.dgts.service.DgtsElementTypeRegistry;
import org.eclipse.papyrus.dgts.wizards.utility.MyObjectTransfer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import DiagramGlobalToolService.DiagramDefinition;
import ElementRegistry.EClassDefinition;

public class ChooseIElementTypesBloc {
    private ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    private IElementType currentSelectedIElementType;
   

    protected IElementType getCurrentSelectedIElementType() {
	return currentSelectedIElementType;
    }

    protected void setCurrentSelectedIElementType(IElementType currentSelectedIElementType) {
	this.currentSelectedIElementType = currentSelectedIElementType;
    }

    private Label labelIElementTypeContext;
    private TreeViewer elementTypeSelectionTreeViewer;
    private Combo comboSelectDiagram;
 
    private int HEIGHT_ELEMENT_SELECTION = 200;

    public static String ELEMENT_TYPE = "ElementType";

    private static Transfer[] transfer = new Transfer[] { new MyObjectTransfer(new String[] { ELEMENT_TYPE }) };

    public static Transfer[] getTransfer() {
	return transfer;
    }

    public void RefreshBloc(DiagramDefinition diagram) {
	if (diagram != null) {
	    
	    ElementRegistry.DiagramDefinition diag = DgtsElementTypeRegistry.getInstance().getDiagram(diagram.getDiagramType());
	    setDefaultDiagram(diag);
	    elementTypeSelectionTreeViewer.setInput(diag);
	}
    }
    
    public void setDefaultDiagram(ElementRegistry.DiagramDefinition diagram){
	if (diagram !=null){  
	    ElementRegistry.Registry registry = (ElementRegistry.Registry)diagram.eContainer();   
	    comboSelectDiagram.select(registry.getRefDiagrams().indexOf(diagram));
	}

    }
    

    public ChooseIElementTypesBloc(Composite container) {
	Group groupElementSelection = DgtsGlobalPage.createGroup(container, "Drag And Drop Tools");
	
	comboSelectDiagram = new Combo(groupElementSelection, SWT.BORDER | SWT.READ_ONLY);
	comboSelectDiagram.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		
		int index = comboSelectDiagram.getSelectionIndex();
		ElementRegistry.DiagramDefinition diagram= DgtsElementTypeRegistry.getInstance().getRegistry().getRefDiagrams().get(index);
		elementTypeSelectionTreeViewer.setInput(diagram);
	
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});
	
	ComboViewer comboViewerSelectDiagram = new ComboViewer(comboSelectDiagram);
	comboViewerSelectDiagram.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	comboViewerSelectDiagram.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
	comboViewerSelectDiagram.setInput(DgtsElementTypeRegistry.getInstance().getRegistry());

	
	elementTypeSelectionTreeViewer = createIElementTypeSelectionForm(groupElementSelection);
    }

    public TreeViewer createIElementTypeSelectionForm(Composite composite) {



	GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
	selectionData.heightHint = HEIGHT_ELEMENT_SELECTION;
	// Element Selection

	final Tree elementSelectionTree = new Tree(composite, SWT.NO_BACKGROUND);

	elementSelectionTree.setLayoutData(selectionData);
	elementSelectionTree.setFont(composite.getFont());
	elementSelectionTree.setBackground(composite.getBackground());

	elementSelectionTree.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		if (e.item.getData() instanceof ElementRegistry.ElementType) {
		    ElementRegistry.ElementType type = (ElementRegistry.ElementType) e.item.getData();
		    labelIElementTypeContext.setText(type.getContext().getLiteral());
		    // e.item.getData());
		} else {
		    labelIElementTypeContext.setText("");
		}
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});

	elementTypeSelectionTreeViewer = new TreeViewer(elementSelectionTree);
	elementTypeSelectionTreeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	elementTypeSelectionTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
	elementTypeSelectionTreeViewer.addDragSupport(DND.DROP_MOVE, MainTreeBloc.getTransfer(), new DragSourceAdapter() {
	    @Override
	    public void dragSetData(DragSourceEvent event) {
		// Get the selected items in the drag source
		DragSource ds = (DragSource) event.widget;
		Tree tree = (Tree) ds.getControl();
		TreeItem[] selection = tree.getSelection();
		if (selection[0].getData() instanceof ElementRegistry.ElementType) {
		    ElementRegistry.ElementType element = (ElementRegistry.ElementType) selection[0].getData();
		    event.data = ElementTypeRegistry.getInstance().getType(element.getElementTypeID());

		} else if (selection[0].getData() instanceof EClassDefinition) {
		    EClassDefinition eclass = (EClassDefinition) selection[0].getData();
		    event.data = eclass;
		} else {
		    event.data = null;
		}
	    }
	});

	labelIElementTypeContext = new Label(composite, SWT.NONE);

	labelIElementTypeContext.setText("                                                     ");

	return elementTypeSelectionTreeViewer;
    }





    private void handlerElementSelected(IElementType data) {
	setCurrentSelectedIElementType(data);
    }
}
