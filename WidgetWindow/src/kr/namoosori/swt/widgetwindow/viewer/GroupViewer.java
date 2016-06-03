package kr.namoosori.swt.widgetwindow.viewer;

import kr.namoosori.swt.widgetwindow.containers.GroupComposite;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class GroupViewer extends ApplicationWindow {

    public GroupViewer() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        new GroupComposite(parent);
        return parent;
    }
    
    public static void main(String[] args) {
        GroupViewer win = new GroupViewer();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }

}
