package kr.namoosori.opendic.editors;

import kr.namoosori.opendic.object.Word;
import kr.namoosori.opendic.views.OpenDicView;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class WordEditor extends EditorPart {
	
	public static final String ID = WordEditor.class.getName();
	
	private WordEditorInput input;
	private Word word;
	
	private Text nameText;
	private Text descText;
	
	private boolean isPageModified;

	public WordEditor() {
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		this.input = (WordEditorInput) input;
		this.word = this.input.getWord();
		setSite(site);
		setInput(input);
		setPartName(this.input.getName());
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
		nameText.setText(word.getName());
		nameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (word.getName().equals(nameText.getText())) {
					isPageModified = false;
				} else {
					isPageModified = true;
				}
				firePropertyChange(IEditorPart.PROP_DIRTY);
			}
		});
		
		Label descLabel = new Label(composite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		descLabel.setText("내용");
		
		descText = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		layoutData.heightHint = 80;
		descText.setLayoutData(layoutData);
		descText.setText(word.getDescription());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		this.word.setName(nameText.getText());
		isPageModified = false;
		firePropertyChange(IEditorPart.PROP_DIRTY);
		
		IViewPart view = getSite().getPage().findView(OpenDicView.ID);
		if (view != null) {
			((OpenDicView)view).refresh();
		}
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public boolean isDirty() {
		return isPageModified;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
