package kr.namoosori.swt.widgetwindow.hello;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ControlLocation {
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        Button button = new Button(shell, SWT.PUSH);
        button.setText("Button Control");
        button.setLocation(30, 20);
        button.pack();
        
        shell.setLocation(100, 50);
        shell.setSize(200, 100);
        shell.open();
        while(!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
