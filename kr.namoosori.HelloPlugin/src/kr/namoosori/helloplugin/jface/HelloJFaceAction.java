package kr.namoosori.helloplugin.jface;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class HelloJFaceAction extends ApplicationWindow {
	
	private StatusLineManager statusLine = new StatusLineManager();
	private StatusAction statusAction = new StatusAction(statusLine);

	public HelloJFaceAction() {
		super(null);
		addStatusLine(); // ����ǥ���� 
		addMenuBar(); // �޴�
		addToolBar(SWT.FLAT | SWT.WRAP); // ����
	}

	@Override
	protected Control createContents(Composite parent) {
		getShell().setText("JFace Action ����");
		parent.setSize(300, 200);
		ActionContributionItem actionItem = new ActionContributionItem(statusAction);
		actionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		actionItem.fill(parent); // ������ ���� ��ư
		return parent;
	}
	
	@Override
	protected MenuManager createMenuManager() {
		MenuManager main = new MenuManager(null);
		MenuManager sub = new MenuManager("&Menu");// (&)����Ű ���� : Alt --> M
		main.add(sub);
		sub.add(statusAction); // �޴��� �Ҵ�
		return main;
	}

	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolbar = new ToolBarManager(style);
		// ���ٿ� �Ҵ�(���1)
		//toolbar.add(statusAction);
		
		// ���ٿ� �Ҵ�(���2)
		ActionContributionItem item = new ActionContributionItem(statusAction);
		item.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		toolbar.add(item);
		
		return toolbar;
	}

	@Override
	protected StatusLineManager createStatusLineManager() {
		return statusLine;
	}

	public static void main(String[] args) {
		HelloJFaceAction win = new HelloJFaceAction();
		win.setBlockOnOpen(true);
		win.open();
		Display.getCurrent().dispose();
	}

}
