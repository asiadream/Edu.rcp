package kr.namoosori.helloplugin.swt.widget;

import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWTRadioButton {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setBounds(100, 100, 200, 160);
		shell.setLayout(new FillLayout());

		// ---------------------------------------------------------------------
		new RadioGroupFieldEditor("Choice", "Choose an option:", 1,
				new String[][] { { "Choice1", "ch1" }, { "Choice2", "ch2" },
						{ "Choice3", "ch3" } }, shell, true);
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
