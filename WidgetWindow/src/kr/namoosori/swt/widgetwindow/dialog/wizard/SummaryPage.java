package kr.namoosori.swt.widgetwindow.dialog.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SummaryPage extends WizardPage {
    public static final String PAGE_NAME = "Summary";

    private Label textLabel;

    public SummaryPage() {
        super(PAGE_NAME, "���� ��� ������", null);
        setDescription("������ ����� ������ �����ϴ�.");
    }

    public void createControl(Composite parent) {
        Composite topLevel = new Composite(parent, SWT.NONE);
        topLevel.setLayout(new FillLayout());

        textLabel = new Label(topLevel, SWT.CENTER);
        textLabel.setText("");

        setControl(topLevel);
        setPageComplete(true);
    }

    public void updateText(String newText) {
        textLabel.setText(newText);
    }
}
