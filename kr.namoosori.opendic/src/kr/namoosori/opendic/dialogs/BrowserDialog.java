package kr.namoosori.opendic.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class BrowserDialog extends Dialog {
	private Browser browser;
	private String url;

	public BrowserDialog(Shell parentShell, String url) {
		super(parentShell);
		this.url = url;
	}

	/**
	 * ��ȭâ���� ��ư�� ���� �ִ� ������ ������ �����ϰ� ��ȯ�Ѵ�. ���� Ŭ������ �Ϲ������� ���� Ŭ���� �޼ҵ带 ȣ���� ������ ��ȯ��
	 * ������Ʈ�� ��Ʈ�� �� �߰��Ѵ�.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = new Composite(parent, SWT.NONE);
		GridLayout dialogAreaLayout = new GridLayout();
		dialogArea.setLayout(dialogAreaLayout);
		dialogArea.setLayoutData(new GridData(GridData.FILL_BOTH));

		// ���̾�α� ����
		Composite dialogAreaContents = new Composite(dialogArea, SWT.NONE);
		dialogAreaContents.setLayoutData(new GridData(GridData.FILL_BOTH));
		fillDialogAreaContents(dialogAreaContents);

		// ���м�
		Label separator = new Label(dialogArea, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return dialogArea;
	}

	/**
	 * ���̾�α� ������ ä���.
	 */
	private void fillDialogAreaContents(Composite dialogArea) {
		FillLayout dialogAreaLayout = new FillLayout();
		dialogAreaLayout.marginWidth = 2;
		dialogAreaLayout.marginHeight = 2;
		dialogArea.setLayout(dialogAreaLayout);
		GridData dialogAreaData = new GridData(GridData.FILL_BOTH);
		dialogArea.setLayoutData(dialogAreaData);

		this.browser = new Browser(dialogArea, SWT.NONE);
		this.browser.setUrl(url);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, CANCEL, "�ݱ�", false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(1024, 768);
	}

}
