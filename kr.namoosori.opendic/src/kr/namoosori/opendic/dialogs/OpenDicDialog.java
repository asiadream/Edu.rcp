package kr.namoosori.opendic.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class OpenDicDialog extends TitleAreaDialog {

	public OpenDicDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("오픈딕 다이얼로그");
		setMessage("오픈딕 다이얼로그입니다.");

		Composite composite = (Composite) super.createDialogArea(parent);
		createForm(composite);

		return composite;
	}

	private void createForm(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("다이얼로그:");
		Text text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 350);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		switch (buttonId) {
		case IDialogConstants.OK_ID:
			setReturnCode(Window.OK);
			// ok 액션정의
			close();
			break;
		case IDialogConstants.CLOSE_ID:
			setReturnCode(Window.CANCEL);
			close();
			break;
		default:
			break;
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "확인", true);
		createButton(parent, IDialogConstants.CLOSE_ID, "닫기", false);
	}

}
