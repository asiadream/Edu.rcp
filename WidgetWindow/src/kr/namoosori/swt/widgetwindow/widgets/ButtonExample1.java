package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonExample1 {
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Button Example");
        shell.setLayout(new GridLayout(4, true));
        
        Button left = new Button(shell, SWT.LEFT);
        left.setLayoutData(new GridData(GridData.FILL_BOTH));
        left.setText("LEFT");
        
        Button center = new Button(shell, SWT.CENTER);
        center.setLayoutData(new GridData(GridData.FILL_BOTH));
        center.setText("CENTER");
        
        Button right = new Button(shell, SWT.RIGHT);
        right.setLayoutData(new GridData(GridData.FILL_BOTH));
        right.setText("RIGHT");
        
        Button flat = new Button(shell, SWT.FLAT);
        flat.setLayoutData(new GridData(GridData.FILL_BOTH));
        flat.setText("FLAT");
        
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
