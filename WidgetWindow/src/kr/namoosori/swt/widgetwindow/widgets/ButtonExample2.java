package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonExample2 {
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Arrow Buttons");
        shell.setLayout(new GridLayout(4, true));
        
        Button left = new Button(shell, SWT.ARROW | SWT.LEFT);
        left.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Button top = new Button(shell, SWT.ARROW | SWT.TOP);
        top.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Button bottom = new Button(shell, SWT.ARROW | SWT.BOTTOM);
        bottom.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Button right = new Button(shell, SWT.ARROW | SWT.RIGHT);
        right.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        shell.pack();
        shell.open();
        while(!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
