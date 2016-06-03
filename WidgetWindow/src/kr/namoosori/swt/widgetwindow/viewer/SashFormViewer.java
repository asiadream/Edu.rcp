package kr.namoosori.swt.widgetwindow.viewer;

import kr.namoosori.swt.widgetwindow.containers.SashFormComposite;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class SashFormViewer extends ApplicationWindow {
	public SashFormViewer() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
    	getShell().setSize(200, 300);
        new SashFormComposite(parent);
        return parent;
    }
    
    public static void main(String[] args) {
    	SashFormViewer win = new SashFormViewer();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }
}
