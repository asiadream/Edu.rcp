package kr.namoosori.swt.widgetwindow.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LoginDialog extends Dialog {
    private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;
    private Text idText;
    private Text passwordText;

    public LoginDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout layout = (GridLayout) composite.getLayout();
        layout.numColumns = 2;
        
        Label idLabel = new Label(composite, SWT.RIGHT);
        idLabel.setText("아이디: ");
        
        idText = new Text(composite, SWT.SINGLE | SWT.BORDER);
        idText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        Label passwordLabel = new Label(composite, SWT.RIGHT);
        passwordLabel.setText("비밀번호: ");
        
        passwordText = new Text(composite, SWT.SINGLE | SWT.PASSWORD | SWT.BORDER);
        passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        return composite;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        createButton(parent, RESET_ID, "Reset All", false);
    }
    
    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == RESET_ID) {
            idText.setText("");
            passwordText.setText("");
        } else {
            super.buttonPressed(buttonId);
        }
    }
}
