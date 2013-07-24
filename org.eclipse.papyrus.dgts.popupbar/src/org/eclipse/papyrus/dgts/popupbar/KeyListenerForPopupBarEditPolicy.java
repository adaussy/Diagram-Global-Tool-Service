package org.eclipse.papyrus.dgts.popupbar;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

public class KeyListenerForPopupBarEditPolicy extends GraphicalEditPolicy {

    
    private class PopupBarKeyListener implements KeyListener {

	public void keyPressed(KeyEvent event) {
	   System.out.println("blablab");
	}

	public void keyReleased(KeyEvent event) {
	
	}

    }
    
    
    private PopupBarKeyListener myPopupBarKeyListener = new PopupBarKeyListener();
    
    
    @Override
    public void activate() {
		super.activate();
	   getHost().getViewer().getControl().addKeyListener(this.myPopupBarKeyListener);
    }

    @Override
    public void deactivate() {

	   getHost().getViewer().getControl().removeKeyListener(this.myPopupBarKeyListener);
    }

   

}
