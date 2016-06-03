package kr.namoosori.swt.widgetwindow.dialog.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class ChooseDirectoryPage extends WizardPage {
    public static final String PAGE_NAME = "Choose Directory";
    private Text text;

    public ChooseDirectoryPage() {
        super(PAGE_NAME, "���丮 ���� ������", null);
        setDescription("����� ���丮�� �Է��ϼ���.");
    }

    public void createControl(Composite parent) {
        Composite topLevel = new Composite(parent, SWT.NONE);
        topLevel.setLayout(new GridLayout(2, false));

        Label l = new Label(topLevel, SWT.CENTER);
        l.setText("����� ���丮 �Է�:");

        text = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
        text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Text source = (Text)e.widget;
                String str = source.getText();
                if (str.length() > 0) {
                    setPageComplete(true);
                } else {
                    setPageComplete(false);
                }
            }
        });

        setControl(topLevel);
        setPageComplete(false);
    }

    public String getDirectory() {
        return text.getText();
    }
}
