package kr.namoosori.swt.widgetwindow.action;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class ContributionWindow extends ApplicationWindow {
    private StatusLineManager statusLine = new StatusLineManager();
    private StatusAction statusAction = new StatusAction(statusLine);

    public ContributionWindow() {
        super(null);
        addStatusLine();
        addMenuBar();
        addToolBar(SWT.FLAT | SWT.WRAP);
    }

    @Override
    protected Control createContents(Composite parent) {
        getShell().setText("Action 抗力");
        parent.setSize(300, 200);
        ActionContributionItem item = new ActionContributionItem(statusAction);
        item.fill(parent);
        return parent;
    }
    
    @Override
    protected MenuManager createMenuManager() {
        MenuManager main = new MenuManager(null);
        MenuManager sub = new MenuManager("&Menu");
        main.add(sub);
        sub.add(statusAction);
        return main;
    }
    
    @Override
    protected ToolBarManager createToolBarManager(int style) {
        ToolBarManager toolbar = new ToolBarManager(style);
        // 咀记 眠啊 规过1
        //toolbar.add(statusAction);
        
        // 咀记 眠啊 规过2
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
        ContributionWindow win = new ContributionWindow();
        win.setBlockOnOpen(true);
        win.open();
        
        Display.getCurrent().dispose();
    }
}
