package kr.namoosori.helloplugin.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class HelloSWTList {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setBounds(100, 100, 200, 160);
		shell.setLayout(new FillLayout());

		// ---------------------------------------------------------------------
		final List list = new List(shell, SWT.SINGLE);
		list.setItems(new String[] { "First", "Second", "Third" });
		list.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selected = list.getSelection();
				if (selected.length > 0) {
					System.out.println("Selected : " + selected[0]);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selected = list.getSelection();
				if (selected.length > 0) {
					System.out.println("Default Selected: " + selected[0]);
				}
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
