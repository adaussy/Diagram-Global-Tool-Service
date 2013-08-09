/**
 */
package DiagramGlobalToolService.provider;

import DiagramGlobalToolService.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;

/**
 * This is the item provider adapter for a {@link DiagramGlobalToolService.Tool}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ToolItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ToolItemProvider(AdapterFactory adapterFactory) {
	super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
	if (itemPropertyDescriptors == null) {
	    super.getPropertyDescriptors(object);

	    addIsEdgePropertyDescriptor(object);
	    addNamePropertyDescriptor(object);
	    addSetPalettePropertyDescriptor(object);
	    addSetPopupPropertyDescriptor(object);
	    addSetMenuPropertyDescriptor(object);
	}
	return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Is Edge feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIsEdgePropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tool_isEdge_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Tool_isEdge_feature", "_UI_Tool_type"), DiagramGlobalToolServicePackage.Literals.TOOL__IS_EDGE, true, false, false,
		ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tool_name_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Tool_name_feature", "_UI_Tool_type"), DiagramGlobalToolServicePackage.Literals.TOOL__NAME, true, false, false,
		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Set Palette feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSetPalettePropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tool_setPalette_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Tool_setPalette_feature", "_UI_Tool_type"), DiagramGlobalToolServicePackage.Literals.TOOL__SET_PALETTE, true, false, false,
		ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Set Popup feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSetPopupPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tool_setPopup_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Tool_setPopup_feature", "_UI_Tool_type"), DiagramGlobalToolServicePackage.Literals.TOOL__SET_POPUP, true, false, false,
		ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Set Menu feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSetMenuPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tool_setMenu_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Tool_setMenu_feature", "_UI_Tool_type"), DiagramGlobalToolServicePackage.Literals.TOOL__SET_MENU, true, false, false,
		ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in
     * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
	if (childrenFeatures == null) {
	    super.getChildrenFeatures(object);
	    // childrenFeatures.add(DiagramGlobalToolServicePackage.Literals.TOOL__ELEMENT_TYPES);
	    // childrenFeatures.add(DiagramGlobalToolServicePackage.Literals.TOOL__ICON_REFERENCE);
	}
	return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
	// Check the type of the specified child object and return the proper
	// feature to use for
	// adding (see {@link AddCommand}) it as a child.

	return super.getChildFeature(object, child);
    }

    /**
     * This returns Tool.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public Object getImage(Object object) {
	if (object instanceof Tool) {
	    Tool tool = (Tool) object;
	    if (tool.getIconReference() != null) {
		try {
		    Image img = new Image(null, tool.getIconReference().getIconPath());
		    return img;
		} catch (Exception e) {
		    // DO nothing
		}

	    }

	    if (tool.getElementTypes() != null) {
		if (!tool.getElementTypes().equals(Collections.emptyList())) {
		    if (tool.getElementTypes().get(0) instanceof DiagramGlobalToolService.ElementType) {
			ElementType element = (ElementType) tool.getElementTypes().get(0);
			IElementType i = ElementTypeRegistry.getInstance().getType(element.getElementType());
			if (i != null) {
			    return IconService.getInstance().getIcon(i);

			}

		    }
		}
	    }

	}

	return overlayImage(object, getResourceLocator().getImage("full/obj16/Tool"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
	String label = ((Tool) object).getName();
	return label == null || label.length() == 0 ? "" : label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached children and by creating a viewer notification, which
     * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
	updateChildren(notification);

	switch (notification.getFeatureID(Tool.class)) {
	case DiagramGlobalToolServicePackage.TOOL__IS_EDGE:
	case DiagramGlobalToolServicePackage.TOOL__NAME:
	case DiagramGlobalToolServicePackage.TOOL__SET_PALETTE:
	case DiagramGlobalToolServicePackage.TOOL__SET_POPUP:
	case DiagramGlobalToolServicePackage.TOOL__SET_MENU:
	    fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
	    return;
	case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
	case DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE:
	    fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
	    return;
	}
	super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children that can be created under this object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
	super.collectNewChildDescriptors(newChildDescriptors, object);

	newChildDescriptors.add(createChildParameter(DiagramGlobalToolServicePackage.Literals.TOOL__ELEMENT_TYPES, DiagramGlobalToolServiceFactory.eINSTANCE.createElementType()));

	newChildDescriptors.add(createChildParameter(DiagramGlobalToolServicePackage.Literals.TOOL__ICON_REFERENCE, DiagramGlobalToolServiceFactory.eINSTANCE.createIcon()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
	return DgtsEditPlugin.INSTANCE;
    }

}
