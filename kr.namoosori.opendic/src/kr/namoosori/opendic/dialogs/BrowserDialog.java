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
	 * 대화창에서 버튼바 위에 있는 컨텐츠 영역을 생성하고 반환한다. 하위 클래스는 일반적으로 상위 클래스 메소드를 호출한 다음에 반환된
	 * 컴포지트에 컨트롤 을 추가한다.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = new Composite(parent, SWT.NONE);
		GridLayout dialogAreaLayout = new GridLayout();
		dialogArea.setLayout(dialogAreaLayout);
		dialogArea.setLayoutData(new GridData(GridData.FILL_BOTH));

		// 다이얼로그 내용
		Composite dialogAreaContents = new Composite(dialogArea, SWT.NONE);
		dialogAreaContents.setLayoutData(new GridData(GridData.FILL_BOTH));
		fillDialogAreaContents(dialogAreaContents);

		// 구분선
		Label separator = new Label(dialogArea, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return dialogArea;
	}

	/**
	 * 다이얼로그 내용을 채운다.
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
		createButton(parent, CANCEL, "닫기", false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(1024, 768);
	}

}
