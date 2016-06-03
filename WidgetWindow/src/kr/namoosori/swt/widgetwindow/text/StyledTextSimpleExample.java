package kr.namoosori.swt.widgetwindow.text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class StyledTextSimpleExample {
	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		final StyledText text = new StyledText(shell, SWT.BORDER | SWT.MULTI);
		text.setText("This is kosta swt/jface Examples."
				+ "\nEnjoy study.");
		TextStyle textStyle = new TextStyle(new Font(display, "Courier", 16,
				SWT.BOLD), display.getSystemColor(SWT.COLOR_BLUE), null);
		textStyle.strikeout = true;
		textStyle.underline = true;
		textStyle.underlineStyle = SWT.UNDERLINE_SINGLE;
		text.setStyleRanges(new int[] { 8, 5 },
				new StyleRange[] { new StyleRange(textStyle) });

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
