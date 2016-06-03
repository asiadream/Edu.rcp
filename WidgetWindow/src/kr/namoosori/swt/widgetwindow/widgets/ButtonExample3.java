package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonExample3 {
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("토글 버튼");
        shell.setLayout(new GridLayout(2, true));
        
        Button left = new Button(shell, SWT.TOGGLE);
        left.setLayoutData(new GridData(GridData.FILL_BOTH));
        left.setText("토글버튼1");
        
        Button right = new Button(shell, SWT.TOGGLE);
        right.setLayoutData(new GridData(GridData.FILL_BOTH));
        right.setText("토글버튼2");
        right.setSelection(true);
        
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
