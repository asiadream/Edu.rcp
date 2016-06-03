package kr.namoosori.helloplugin.swt.exercise;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FirstExercise {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setText("첫번째 실습");
		shell.setBounds(100, 100, 300, 200);

		// ---------------------------------------------------------------------
		GridLayout layout = new GridLayout(1, false);
		shell.setLayout(layout);
		
		final Text topText = new Text(shell, SWT.MULTI | SWT.BORDER);
		topText.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Button moveButton = new Button(shell, SWT.PUSH);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.heightHint = 30;
		moveButton.setLayoutData(gd);
		moveButton.setText("이동");
		
		final Text bottomText = new Text(shell, SWT.MULTI | SWT.BORDER);
		bottomText.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		moveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//
				String text = topText.getText();
				bottomText.setText(text);
				topText.setText("");
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
