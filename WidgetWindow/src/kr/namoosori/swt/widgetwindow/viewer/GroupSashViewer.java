package kr.namoosori.swt.widgetwindow.viewer;

import kr.namoosori.swt.widgetwindow.containers.GroupSashComposite;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class GroupSashViewer extends ApplicationWindow {
	public GroupSashViewer() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        new GroupSashComposite(parent);
        return parent;
    }
    
    public static void main(String[] args) {
    	GroupSashViewer win = new GroupSashViewer();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }
}
