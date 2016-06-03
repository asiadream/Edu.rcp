package kr.namoosori.swt.widgetwindow.hello;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class HelloJFace extends ApplicationWindow {

    public HelloJFace() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        Text text = new Text(parent, SWT.CENTER);
        text.setText("Hello JFace!");
        parent.pack();
        return parent;
    }
    
    public static void main(String[] args) {
        HelloJFace win = new HelloJFace();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }

}
