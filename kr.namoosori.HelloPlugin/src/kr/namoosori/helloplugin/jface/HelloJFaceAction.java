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
		addStatusLine(); // 상태표시줄 
		addMenuBar(); // 메뉴
		addToolBar(SWT.FLAT | SWT.WRAP); // 툴바
	}

	@Override
	protected Control createContents(Composite parent) {
		getShell().setText("JFace Action 예제");
		parent.setSize(300, 200);
		ActionContributionItem actionItem = new ActionContributionItem(statusAction);
		actionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		actionItem.fill(parent); // 윈도우 내의 버튼
		return parent;
	}
	
	@Override
	protected MenuManager createMenuManager() {
		MenuManager main = new MenuManager(null);
		MenuManager sub = new MenuManager("&Menu");// (&)단축키 가능 : Alt --> M
		main.add(sub);
		sub.add(statusAction); // 메뉴에 할당
		return main;
	}

	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolbar = new ToolBarManager(style);
		// 툴바에 할당(방법1)
		//toolbar.add(statusAction);
		
		// 툴바에 할당(방법2)
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
