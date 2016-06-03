package kr.namoosori.helloplugin.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWTCheckButton {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setBounds(100, 100, 200, 80);
		shell.setLayout(new FillLayout());

		// ---------------------------------------------------------------------
		Button[] checks = new Button[2];
		checks[0] = new Button(shell, SWT.CHECK);
		checks[0].setText("Choice 1");
		checks[0].setLocation(10, 5);
		checks[1] = new Button(shell, SWT.CHECK);
		checks[1].setText("Choice 2");
		checks[1].setLocation(10, 30);
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
