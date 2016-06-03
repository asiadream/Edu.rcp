package kr.namoosori.opendic.views;

import java.util.Collection;
import java.util.List;

import kr.namoosori.opendic.editors.WordEditor;
import kr.namoosori.opendic.editors.WordEditorInput;
import kr.namoosori.opendic.object.SearchType;
import kr.namoosori.opendic.object.Word;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public class OpenDicView extends ViewPart {
	public static final String ID = OpenDicView.class.getName();
	
	private ComboViewer comboViewer;
	private Text text;
	private Button searchButton;
	private TableViewer tableViewer;
	private Browser browser;

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		
		createInputArea(composite);
		createOutputArea(composite);
		
		addActionListener();
		
		// 이벤트 Provider 등록
		getSite().setSelectionProvider(tableViewer);
	}

	private void addActionListener() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				Object firstElement = selection.getFirstElement();
				if (firstElement instanceof Word) {
					openEditor((Word)firstElement);
				}
			}
		});
		
		searchButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchWord();
			}
		});
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR) {
					searchWord();
				}
			}
		});
		
		// 이벤트를 뷰에 직접 전달하는 방법
		/*
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				OpenDicDetailView detailView = (OpenDicDetailView) getSite().getPage().findView(OpenDicDetailView.ID);
				if (detailView != null) {
					ISelection selection = event.getSelection();
					Object element = ((IStructuredSelection)selection).getFirstElement();
					detailView.setWord((Word)element);
				}
			}
		});
		*/
	}
	
	protected void openEditor(Word word) {
		WordEditorInput input = new WordEditorInput(word);
		IEditorPart editor = getSite().getPage().findEditor(input);
		try {
			if (editor != null) {
				getSite().getPage().activate(editor);
			} else {
				getSite().getPage().openEditor(input, WordEditor.ID);
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	private void searchWord() {
		String keyword = text.getText();
		List<Word> result = Word.findWordList(keyword);
		tableViewer.setInput(result);
		browser.setUrl("http://dic.daum.net/search.do?q=" + keyword);
	}

	private void createInputArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);
		
		createComboViewer(composite);
		createText(composite);
		createButton(composite);
	}

	private void createComboViewer(Composite parent) {
		comboViewer = new ComboViewer(parent, SWT.READ_ONLY);
		comboViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		comboViewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				if (element instanceof SearchType) {
					return ((SearchType)element).getDescription();
				}
				return null;
			}
		});
		comboViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof Object[]) {
					return (Object[])inputElement;
				}
				return null;
			}
		});
		comboViewer.setInput(SearchType.values());
		comboViewer.setSelection(new StructuredSelection(SearchType.WORD));
	}

	private void createText(Composite parent) {
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	private void createButton(Composite parent) {
		searchButton = new Button(parent, SWT.PUSH);
		searchButton.setText("검색");
		searchButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	}

	private void createOutputArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		
		createTableViewer(composite);
		createBrowser(composite);
	}

	private void createTableViewer(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.SINGLE | SWT.BORDER);
		Table table = tableViewer.getTable();
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 100;
		table.setLayoutData(gd);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn column1 = new TableViewerColumn(tableViewer, SWT.NONE);
		column1.getColumn().setWidth(100);
		column1.getColumn().setText("단어");
		column1.getColumn().setAlignment(SWT.LEFT);
		
		TableViewerColumn column2 = new TableViewerColumn(tableViewer, SWT.NONE);
		column2.getColumn().setWidth(300);
		column2.getColumn().setText("내용");
		column2.getColumn().setAlignment(SWT.LEFT);
		
		tableViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof Collection<?>) {
					return ((Collection<?>)inputElement).toArray();
				}
				return null;
			}
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
		});
		tableViewer.setLabelProvider(new AbstractTableLabelProvider(){
			@Override
			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof Word) {
					Word word = (Word) element;
					String label = null;
					switch (columnIndex) {
					case 0: label = word.getName(); break;
					case 1: label = word.getDescription(); break;
					default: label = ""; break;
					}
					return label;
				}
				return null;
			}
		});
	}

	private void createBrowser(Composite parent) {
		browser = new Browser(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_BOTH);
		browser.setLayoutData(gd);
		browser.setUrl("www.naver.com");
	}

	@Override
	public void setFocus() {
		
	}
	
	//--------------------------------------------------
	public class AbstractTableLabelProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			return null;
		}
	}

	public void refresh() {
		tableViewer.refresh();
	}

}
