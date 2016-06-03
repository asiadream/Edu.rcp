package kr.namoosori.helloplugin.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWTFillLayout {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setBounds(100, 100, 200, 160);

		// ---------------------------------------------------------------------
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		shell.setLayout(layout);
		for (int i = 0; i < 8; i++) {
			Button button = new Button(shell, SWT.NONE);
			button.setText("Sample Text");
		}
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
