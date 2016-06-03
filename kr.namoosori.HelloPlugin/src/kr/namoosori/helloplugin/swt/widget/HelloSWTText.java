package kr.namoosori.helloplugin.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSWTText {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setBounds(100, 100, 200, 160);
		shell.setLayout(new FillLayout());

		// ---------------------------------------------------------------------
		final Text text = new Text(shell, SWT.MULTI);
		text.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				if (event.text.charAt(0) == SWT.CR) {
					event.doit = true;
					return;
				}
				event.doit = event.text.length() == 0
						|| Character.isDigit(event.text.charAt(0));
			}
		});
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
