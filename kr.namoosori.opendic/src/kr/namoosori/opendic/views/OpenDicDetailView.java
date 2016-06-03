package kr.namoosori.opendic.views;

import kr.namoosori.opendic.dialogs.BrowserDialog;
import kr.namoosori.opendic.dialogs.OpenDicDialog;
import kr.namoosori.opendic.object.Word;
import kr.namoosori.opendic.wizards.OpenDicWizard;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

public class OpenDicDetailView extends ViewPart implements ISelectionListener {
	public static final String ID = OpenDicDetailView.class.getName();
	
	private Text nameText;
	private Text descText;

	public OpenDicDetailView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		
		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		nameLabel.setText("단어");
		
		nameText = new Text(composite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label descLabel = new Label(composite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		descLabel.setText("내용");
		
		descText = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		layoutData.heightHint = 80;
		descText.setLayoutData(layoutData);
		
		// 다이얼로그 테스트
		createDialogArea(composite);
		
		// 이벤트 Listener 등록
		//getSite().getPage().addSelectionListener(this); // WorkbenchPage 의 모든 Selection 이벤트 수신
		//getSite().getPage().addSelectionListener("kr.namoosori.opendic.views.OpenDicView", this); // 선택적 이벤트 수신
		getSite().getPage().addPostSelectionListener("kr.namoosori.opendic.views.OpenDicView", this);
	}

	private void createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		GridLayout layout = new GridLayout(4, false);
		composite.setLayout(layout);
		
		Button btn1 = new Button(composite, SWT.NONE);
		btn1.setText("파일");
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(getSite().getShell(), SWT.SAVE);
				fileDialog.setFilterExtensions(new String[] { "*.jpg;*.gif;*.png;*.bmp", "*.*" });
				fileDialog.setFilterNames(new String[] { "Image Files", "All Files" });
				String selectedFile = fileDialog.open();
				System.out.println("selected file name:" + selectedFile);
			}
		});
		
		Button btn2 = new Button(composite, SWT.NONE);
		btn2.setText("타이틀");
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				OpenDicDialog dialog = new OpenDicDialog(getSite().getShell());
				dialog.open();
			}
		});
		
		Button btn3 = new Button(composite, SWT.NONE);
		btn3.setText("마법사");
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				OpenDicWizard wizard = new OpenDicWizard();
				WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
				dialog.create();
				dialog.getShell().setSize(520, 550);
				dialog.open();
				if (dialog.getReturnCode() == Window.OK) {
					System.out.println("마법사 OK");
				}
			}
		});
		
		Button btn4 = new Button(composite, SWT.NONE);
		btn4.setText("Browser");
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrowserDialog dialog = new BrowserDialog(getSite().getShell(), "http://edu.kosta.or.kr");
				dialog.open();
			}
		});
	}

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener("kr.namoosori.opendic.views.OpenDicView", this);
		super.dispose();
	}

	@Override
	public void setFocus() {
	}
	
	public void setWord(Word word) {
		this.nameText.setText(word.getName());
		this.descText.setText(word.getDescription());
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		Object firstElement = ((IStructuredSelection)selection).getFirstElement();
		if (firstElement instanceof Word) {
			Word word = (Word) firstElement;
			setWord(word);
		}
	}

}
