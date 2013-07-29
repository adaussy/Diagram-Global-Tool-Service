package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import java.util.List;

public final class HandleRegistry {

    
    private static volatile HandleRegistry instance = null;
    
    
    private List<CustomConnectionHandle> handles = null;
    
    
    private boolean showConnectionHandle = false;
    
    public void setShouldShowConnectionHandles(){
	showConnectionHandle = true;
    }
    
    public void setShouldHideConnectionHandles(){
	showConnectionHandle = false;
    }
    
    public boolean shouldShowConnectionHandles(){
	return showConnectionHandle;
    }
    
    
    public void setHandles(List<CustomConnectionHandle> listHandles){
	handles = listHandles;
    }
    
    public void addHandle(CustomConnectionHandle aHandle) {
	handles.add(aHandle);
    }
    public void removeHandles(){
	handles = null;
    }
    
    public boolean isHandles() {
	return handles != null;
    }

    public List<CustomConnectionHandle> getHandles(){
	return handles;
    }
    
    private HandleRegistry(){
	super();
    }
    
    static public HandleRegistry getInstance(){
	       if(instance == null){
		  
		   synchronized(HandleRegistry.class) {
		              if (HandleRegistry.instance == null) {
		                HandleRegistry.instance = new HandleRegistry();
		              }
		            }
	       }
	       return instance;

    }
}
