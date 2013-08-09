package org.eclipse.papyrus.dgts.wizards.pages;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.dgts.wizards.utility.ElementRequests;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;

public class EditBloc {


    private MainTreeBloc mainTreeBloc;
    // swt elements
    private Group groupToolEdit;
    private Group groupDrawerEdit;
    private Group group;
    GridData gridLayoutToolEdit;
    GridData gridLayoutDrawerEdit;
    

    private Button browseDrawerIcon;
    private Button browseToolIcon;

    private Button popupCheckBox;
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



    
    private DrawerDefinition currentSelectedDrawer = null;
    private Tool currentSelectedTool = null;

    

    public Tool getCurrentSelectedTool() {
	return currentSelectedTool;
    }

    protected void setCurrentSelectedTool(Tool tool) {
	currentSelectedTool = tool;
    }

    public DrawerDefinition getCurrentSelectedDrawer() {
	return currentSelectedDrawer;
    }

    protected void setCurrentSelectedDrawer(DrawerDefinition drawer) {
	currentSelectedDrawer = drawer;
    }

    public EditBloc(Composite container) {
	group = DgtsGlobalPage.createGroup(container, "");
	group.setSize(200, 800);
	createToolEditBlocForm(group);
	createDrawerEditBlocForm(group);
	groupDrawerEdit.setVisible(false);
	groupToolEdit.setVisible(false);
    }

    protected MainTreeBloc getMainTreeBloc() {
	return mainTreeBloc;
    }

    protected void setMainTreeBloc(MainTreeBloc mainTreeBloc) {
	this.mainTreeBloc = mainTreeBloc;
    }

    public void refreshBloc() {

	// the selection is a tool
	if (currentSelectedTool != null) {
	    if (currentSelectedTool.getName() != null) {
		toolName.setText(currentSelectedTool.getName());
	    } else {
		toolName.setText("");
	    }
	    toolIcon.setText("");
	    isEdgeCheckBox.setSelection(currentSelectedTool.isIsEdge());
	    popupCheckBox.setSelection(currentSelectedTool.isSetPopup());
	    paletteCheckBox.setSelection(currentSelectedTool.isSetPalette());
	    menuCheckBox.setSelection(currentSelectedTool.isSetMenu());
	    if (currentSelectedTool.getIconReference() != null) {
		if (currentSelectedTool.getIconReference().getIconPath() != null) {
		    toolIcon.setText(currentSelectedTool.getIconReference().getIconPath());
		}
	    }
	    gridLayoutDrawerEdit.exclude = true;
	    
	    groupDrawerEdit.setVisible(false);
	    groupToolEdit.setVisible(true);
	    groupToolEdit.getParent().layout();

	    // the selection is a drawer
	} else if (currentSelectedDrawer != null) {

	    drawerName.setText(currentSelectedDrawer.getName());
	    drawerIcon.setText("");
	    if (currentSelectedDrawer.getIconReference() != null) {
		if (currentSelectedDrawer.getIconReference().getIconPath() != null) {
		    drawerIcon.setText(currentSelectedDrawer.getIconReference().getIconPath());
		}
	    }
		    
	    groupToolEdit.setVisible(false);
	    gridLayoutToolEdit.exclude = true;
	    groupToolEdit.setParent(group);
	    groupDrawerEdit.setVisible(true);
	    groupDrawerEdit.getParent().layout();

	    // no selection
	} else {
	    groupToolEdit.setVisible(false);
	    groupDrawerEdit.setVisible(false);
	}

    }

    private void createToolEditBlocForm(Group group) {
	Image browseIcon = new Image(null,getClass().getResourceAsStream("../icons/browseIcon.png"));
	groupToolEdit = DgtsGlobalPage.createGroup(group, "");
	gridLayoutToolEdit = new GridData();
	groupToolEdit.setLayoutData(gridLayoutToolEdit);
	
	
	
	// Tool Name
	labelToolName = new Label(groupToolEdit, SWT.NONE);
	labelToolName.setText("Tool Name : ");
	toolName = new Text(groupToolEdit, SWT.BORDER | SWT.SINGLE);
	toolName.setText("");
	toolName.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent e) {

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		currentSelectedTool.setName(toolName.getText());
		mainTreeBloc.refreshBloc(DgtsGlobalPage.getCurrentDiagram());
	    }

	});

	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	
	toolName.setLayoutData(gd);

	// Tool Icon
	GridLayout gridLayout = new GridLayout(2,false);
	Composite iconContainer = new Composite(groupToolEdit, SWT.NONE);
	iconContainer.setLayout(gridLayout);
	
	
	labelToolIcon = new Label(iconContainer, SWT.NONE);
	labelToolIcon.setText("Tool Icon (absolute path) : ");
	
	// Browse Icon
	browseToolIcon = new Button(iconContainer, SWT.PUSH);
	browseToolIcon.setImage(browseIcon);
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
	
	toolIcon = new Text(groupToolEdit, SWT.BORDER | SWT.SINGLE);
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

	toolIcon.setLayoutData(gd);




	// Is Edge
	isEdgeCheckBox = new Button(groupToolEdit, SWT.CHECK);
	isEdgeCheckBox.setText("Is Edge");
	isEdgeCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (isEdgeCheckBox.getSelection()) {
		    currentSelectedTool.setIsEdge(true);
		} else {
		    currentSelectedTool.setIsEdge(false);
		}

	    }
	});

	// popup
	popupCheckBox = new Button(groupToolEdit, SWT.CHECK);
	popupCheckBox.setText("Popup");
	popupCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (popupCheckBox.getSelection()) {
		    currentSelectedTool.setSetPopup(true);
		} else {
		    currentSelectedTool.setSetPopup(false);
		}

	    }
	});

	// palette
	paletteCheckBox = new Button(groupToolEdit, SWT.CHECK);
	paletteCheckBox.setText("Palette");
	paletteCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (paletteCheckBox.getSelection()) {
		    currentSelectedTool.setSetPalette(true);
		} else {
		    currentSelectedTool.setSetPalette(false);
		}

	    }
	});

	// menu
	menuCheckBox = new Button(groupToolEdit, SWT.CHECK);
	menuCheckBox.setText("Menu");
	menuCheckBox.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		if (menuCheckBox.getSelection()) {
		    currentSelectedTool.setSetMenu(true);
		} else {
		    currentSelectedTool.setSetMenu(false);
		}

	    }
	});

	
    }

    private void createDrawerEditBlocForm(Group group) {
	Image browseIcon = new Image(null,getClass().getResourceAsStream("../icons/browseIcon.png"));
	groupDrawerEdit = DgtsGlobalPage.createGroup(group, "");
	
	gridLayoutDrawerEdit = new GridData();
	
	groupDrawerEdit.setLayoutData(gridLayoutDrawerEdit);
	// Drawer Name
	labelDrawerName = new Label(groupDrawerEdit, SWT.NONE);
	labelDrawerName.setText("Drawer Name : ");
	drawerName = new Text(groupDrawerEdit, SWT.BORDER | SWT.SINGLE);
	drawerName.setText("");
	drawerName.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent e) {

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		getCurrentSelectedDrawer().setName(drawerName.getText());
		mainTreeBloc.refreshBloc(DgtsGlobalPage.getCurrentDiagram());
	    }

	});

	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	drawerName.setLayoutData(gd);

	
	
	GridLayout gridLayout = new GridLayout(2,false);
	Composite iconContainer = new Composite(groupDrawerEdit, SWT.NONE);
	iconContainer.setLayout(gridLayout);
	// Drawer Icon
	labelDrawerIcon = new Label(iconContainer, SWT.NONE);
	labelDrawerIcon.setText("Drawer Icon (absolute path) : ");
	// Browse Icon
		browseDrawerIcon = new Button(iconContainer, SWT.PUSH);
		browseDrawerIcon.setImage(browseIcon);
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
	
	drawerIcon = new Text(groupDrawerEdit, SWT.BORDER | SWT.SINGLE);
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
	
	drawerIcon.setLayoutData(gd);
	


	

    }


    protected void handleChangeDrawerIcon(String path) {
	if (path != "") {

	    if (currentSelectedDrawer.getIconReference() == null) {
		ElementRequests.addIconReference(currentSelectedDrawer);
	    }
	    if (currentSelectedDrawer.getIconReference() != null) {
		currentSelectedDrawer.getIconReference().setIconPath(path);
		mainTreeBloc.refreshBloc(DgtsGlobalPage.getCurrentDiagram());
	    }
	} else {
	    if (currentSelectedDrawer.getIconReference() != null) {
		ElementRequests.deleteIconReference(currentSelectedDrawer);
	    }
	}
    }

    protected void handleChangeToolIcon(String path) {
	if (path != "") {
	    if (currentSelectedTool.getIconReference() == null) {
		ElementRequests.addIconReference(currentSelectedTool);
	    }
	    if (currentSelectedTool.getIconReference() != null) {
		currentSelectedTool.getIconReference().setIconPath(path);
		mainTreeBloc.refreshBloc(DgtsGlobalPage.getCurrentDiagram());
	    }
	} else {
	    if (currentSelectedTool.getIconReference() != null) {
		ElementRequests.deleteIconReference(currentSelectedTool);
	    }
	}
    }
    
}
