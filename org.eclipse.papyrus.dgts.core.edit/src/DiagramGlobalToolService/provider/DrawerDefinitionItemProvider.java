/**
 */
package DiagramGlobalToolService.provider;


import DiagramGlobalToolService.DiagramGlobalToolServiceFactory;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.DrawerDefinition;

import java.util.Collection;
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
import org.eclipse.swt.graphics.Image;

/**
 * This is the item provider adapter for a {@link DiagramGlobalToolService.DrawerDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DrawerDefinitionItemProvider
        extends ItemProviderAdapter
        implements
                IEditingDomainItemProvider,
                IStructuredItemContentProvider,
                ITreeItemContentProvider,
                IItemLabelProvider,
                IItemPropertySource {
        /**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public DrawerDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

        /**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

        /**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DrawerDefinition_Name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DrawerDefinition_Name_feature", "_UI_DrawerDefinition_type"),
				 DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

        /**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated not
	 */
        @Override
        public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__TOOL_REF);
			//childrenFeatures.add(DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__ICON_REFERENCE);
		}
		return childrenFeatures;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

        /**
	 * This returns DrawerDefinition.gif.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated not
	 */
        @Override
        public Object getImage(Object object) {
            
            	if (object instanceof DrawerDefinition) {
		    DrawerDefinition drawer = (DrawerDefinition) object;
		    if (drawer.getIconReference() != null){
			try {
			    Image img = new Image(null,drawer.getIconReference().getIconPath());
				return img;
			} catch (Exception e) {
			//DO nothing
			}

		    }
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DrawerDefinition"));
	}

        /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated not
	 */
        @Override
        public String getText(Object object) {
		String label = ((DrawerDefinition)object).getName();
		return label == null || label.length() == 0 ?
			"" :
			 label;
	}

        /**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DrawerDefinition.class)) {
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF:
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

        /**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__TOOL_REF,
				 DiagramGlobalToolServiceFactory.eINSTANCE.createTool()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__ICON_REFERENCE,
				 DiagramGlobalToolServiceFactory.eINSTANCE.createIcon()));
	}

        /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public ResourceLocator getResourceLocator() {
		return DgtsEditPlugin.INSTANCE;
	}

}
