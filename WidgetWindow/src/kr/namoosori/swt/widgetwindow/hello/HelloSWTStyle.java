package kr.namoosori.swt.widgetwindow.hello;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSWTStyle {
	public static void main(String[] args) {
        Display display = new Display();
        //Shell shell = new Shell(display, SWT.SHELL_TRIM);
        //Shell shell = new Shell(display, SWT.NONE);
        //Shell shell = new Shell(display, SWT.TITLE);
        //Shell shell = new Shell(display, SWT.TITLE | SWT.BORDER | SWT.CLOSE);
        Shell shell = new Shell(display, SWT.DIALOG_TRIM);
        shell.setText("Hello");
        shell.setSize(200, 80);
        shell.setLayout(new FillLayout());
        
        Text text = new Text(shell, SWT.CENTER);
        text.setText("Hello SWT!");
        text.pack();
        
        //shell.pack();
        shell.open();
        while(!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
