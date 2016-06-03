package kr.namoosori.swt.widgetwindow.dialog.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class DirectoryPage extends WizardPage {
    public static final String PAGE_NAME = "Directory";
    private Button button;

    public DirectoryPage() {
        super(PAGE_NAME, "���丮 ������", null);
        setDescription("�⺻ ���丮 ��� ���θ� �����մϴ�.");
    }

    public void createControl(Composite parent) {
        Composite topLevel = new Composite(parent, SWT.NONE);
        topLevel.setLayout(new GridLayout(2, false));

        Label l = new Label(topLevel, SWT.CENTER);
        l.setText("�⺻ ���丮�� ����Ͻðڽ��ϱ�?");

        button = new Button(topLevel, SWT.CHECK);

        setControl(topLevel);
        setPageComplete(true);
    }

    public boolean useDefaultDirectory() {
        return button.getSelection();
    }
}
