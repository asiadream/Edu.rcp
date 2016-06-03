package kr.namoosori.swt.widgetwindow.dialog.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class DirectoryPage extends WizardPage {
    public static final String PAGE_NAME = "Directory";
    private Button button;

    public DirectoryPage() {
        super(PAGE_NAME, "디렉토리 페이지", null);
        setDescription("기본 디렉토리 사용 여부를 결정합니다.");
    }

    public void createControl(Composite parent) {
        Composite topLevel = new Composite(parent, SWT.NONE);
        topLevel.setLayout(new GridLayout(2, false));

        Label l = new Label(topLevel, SWT.CENTER);
        l.setText("기본 디렉토리를 사용하시겠습니까?");

        button = new Button(topLevel, SWT.CHECK);

        setControl(topLevel);
        setPageComplete(true);
    }

    public boolean useDefaultDirectory() {
        return button.getSelection();
    }
}
