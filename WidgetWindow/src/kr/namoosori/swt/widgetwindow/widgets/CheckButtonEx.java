package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CheckButtonEx {
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("üũ ��ư");
        shell.setLayout(new GridLayout(3, true));
        
        Button[] checks = new Button[3];
        
        checks[0] = new Button(shell, SWT.CHECK);
        checks[0].setLayoutData(new GridData(GridData.FILL_BOTH));
        checks[0].setText("���û���1");
        checks[0].setSelection(true);
        
        checks[1] = new Button(shell, SWT.CHECK);
        checks[1].setLayoutData(new GridData(GridData.FILL_BOTH));
        checks[1].setText("���û���2");
        
        checks[2] = new Button(shell, SWT.CHECK);
        checks[2].setLayoutData(new GridData(GridData.FILL_BOTH));
        checks[2].setText("���û���3");
        
        for (Button check : checks) {
			System.out.println(check.getText() + ":" + check.getSelection());
		}
        
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
