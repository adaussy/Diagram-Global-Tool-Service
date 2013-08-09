/**
 */
package ElementRegistry.provider;

import ElementRegistry.ElementRegistryPackage;
import ElementRegistry.ElementType;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
 * This is the item provider adapter for a {@link ElementRegistry.ElementType}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ElementTypeItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ElementTypeItemProvider(AdapterFactory adapterFactory) {
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

	    addElementTypeIDPropertyDescriptor(object);
	    addDescriptionPropertyDescriptor(object);
	    addContextPropertyDescriptor(object);
	}
	return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Element Type ID feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addElementTypeIDPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ElementType_elementTypeID_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ElementType_elementTypeID_feature", "_UI_ElementType_type"), ElementRegistryPackage.Literals.ELEMENT_TYPE__ELEMENT_TYPE_ID, true, false,
		false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Description feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ElementType_description_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ElementType_description_feature", "_UI_ElementType_type"), ElementRegistryPackage.Literals.ELEMENT_TYPE__DESCRIPTION, true, false, false,
		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Context feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addContextPropertyDescriptor(Object object) {
	itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ElementType_context_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ElementType_context_feature", "_UI_ElementType_type"), ElementRegistryPackage.Literals.ELEMENT_TYPE__CONTEXT, true, false, false,
		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns ElementType.gif. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated not
     */
    @Override
    public Object getImage(Object object) {
	if (object instanceof ElementType) {
	    ElementType element = (ElementType) object;
	    IElementType i = ElementTypeRegistry.getInstance().getType(element.getElementTypeID());
	    if (i != null) {
		return IconService.getInstance().getIcon(i);

	    }
	    
	}

	return null;
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
	String label = ((ElementType) object).getElementTypeID();
	if (label == null || label.length() == 0) {
	    return getString("_UI_ElementType_type");
	} else {
	    String extension = "";

	    int i = label.lastIndexOf('.');
	    if (i > 0) {
		extension = label.substring(i + 1);
	    }
	    return extension;
	}

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

	switch (notification.getFeatureID(ElementType.class)) {
	case ElementRegistryPackage.ELEMENT_TYPE__ELEMENT_TYPE_ID:
	case ElementRegistryPackage.ELEMENT_TYPE__DESCRIPTION:
	case ElementRegistryPackage.ELEMENT_TYPE__CONTEXT:
	    fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
	return ElementRegistryEditPlugin.INSTANCE;
    }

}
