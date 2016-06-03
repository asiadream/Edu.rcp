package kr.namoosori.helloplugin.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWTGridLayout {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setBounds(100, 100, 400, 160);

		// ---------------------------------------------------------------------
		GridLayout layout = new GridLayout(4, false);
		shell.setLayout(layout);
		
		Button button1 = new Button(shell, SWT.NONE);
		GridData gd1 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		button1.setLayoutData(gd1);
		button1.setText("Sample Text1");
		
		Button button2 = new Button(shell, SWT.NONE);
		GridData gd2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		button2.setLayoutData(gd2);
		button2.setText("Sample Text2");
		
		Button button3 = new Button(shell, SWT.NONE);
		GridData gd3 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		button3.setLayoutData(gd3);
		button3.setText("Sample Text3");
		
		Button button4 = new Button(shell, SWT.NONE);
		GridData gd4 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		button4.setLayoutData(gd4);
		button4.setText("Sample Text4");
		
		Button button5 = new Button(shell, SWT.NONE);
		GridData gd5 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		button5.setLayoutData(gd5);
		button5.setText("Sample Text5");
		
		Button button6 = new Button(shell, SWT.NONE);
		GridData gd6 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		button6.setLayoutData(gd6);
		button6.setText("Sample Text6");
		// ---------------------------------------------------------------------

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
}
