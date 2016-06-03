package kr.namoosori.helloplugin.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SampleGrabExcess {
	//
	public static void main(String[] args) {
		//
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(2, false));
		
		Label nameLabel = new Label(shell, SWT.NONE);
		nameLabel.setText("이름:");
		
		Text nameText = new Text(shell, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		nameText.setLayoutData(gridData);
		nameText.setText("Text grows horizontally");
		
		Label addressLabel = new Label(shell, SWT.NONE);
		addressLabel.setText("주소:");
		gridData = new GridData();
		gridData.verticalAlignment = SWT.TOP;
		addressLabel.setLayoutData(gridData);
		
		Text addressText = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
		addressText.setLayoutData(gridData);
		addressText.setText("첫번째 문장\n두번째 문장");

		Label sportsLabel = new Label(shell, SWT.NONE);
		sportsLabel.setText("좋아하는 스포츠:");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		sportsLabel.setLayoutData(gridData);
		
		List sportsList = new List(shell, SWT.BORDER | SWT.MULTI);
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
		sportsList.setLayoutData(gridData);
		sportsList.add("축구");
		sportsList.add("야구");
				
		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
