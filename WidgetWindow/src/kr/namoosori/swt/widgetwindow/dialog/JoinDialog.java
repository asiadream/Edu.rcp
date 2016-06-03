package kr.namoosori.swt.widgetwindow.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class JoinDialog extends TitleAreaDialog {
	private Text nameText;
	private Text emailText;
	private Text passwordText;
	private Button dupButton;

	public JoinDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		getShell().setText("ȸ������");
		setTitle("ȸ������");
		setMessage("ȸ�������� ���Ͽ� �Ʒ� �Է»����� �Է��� �ּ���.");
		Composite area = (Composite) super.createDialogArea(parent);
		
		Composite composite = new Composite(area, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout(1, false));
		
		Group memberInfoGrp = new Group(composite, SWT.NONE);
		memberInfoGrp.setText("�ű� ȸ������");
		memberInfoGrp.setLayout(new GridLayout(3, false));
		memberInfoGrp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		Label nameLabel = new Label(memberInfoGrp, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("�̸� :");
		
		nameText = new Text(memberInfoGrp, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(memberInfoGrp, SWT.NONE);
		
		Label emailLabel = new Label(memberInfoGrp, SWT.NONE);
		emailLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		emailLabel.setText("�̸��� :");
		
		emailText = new Text(memberInfoGrp, SWT.BORDER);
		emailText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		dupButton = new Button(memberInfoGrp, SWT.NONE);
		dupButton.setText("�ߺ�üũ");
		
		Label passwordLabel = new Label(memberInfoGrp, SWT.NONE);
		passwordLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		passwordLabel.setText("�н����� :");
		
		passwordText = new Text(memberInfoGrp, SWT.BORDER);
		passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(memberInfoGrp, SWT.NONE);
		
		return area;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "ȸ������", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "���", false);
	}

}
