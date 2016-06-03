package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class ToolBarWindow extends ApplicationWindow {

	public ToolBarWindow() {
		super(null);
		addToolBar(SWT.FLAT | SWT.WRAP);
	}

	@Override
	protected Control createContents(Composite parent) {
		getShell().setText("ToolBar ¿¹Á¦");
		parent.setSize(300, 200);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		Label label = new Label(composite, SWT.CENTER);
		label.setText("ÄÁÅÙÃ÷ ¿µ¿ªÀÔ´Ï´Ù.");
		label.setBackground(new Color(getShell().getDisplay(), 255,255,255));
		return parent;
	}

	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolbarManager = new ToolBarManager(style);
		toolbarManager.add(new ControlContribution("custom") {
			@Override
			protected Control createControl(Composite parent) {
				SashForm sf = new SashForm(parent, SWT.NONE);
				Button b1 = new Button(sf, SWT.PUSH);
				b1.setText("Hello");
				Button b2 = new Button(sf, SWT.PUSH);
				b2.setText("World");
				b2.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						System.out.println("Selected:" + e);
					}
				});
				return sf;
			}
		});

		return toolbarManager;
	}
	
	public static void main(String[] args) {
		ToolBarWindow win = new ToolBarWindow();
        win.setBlockOnOpen(true);
        win.open();
        
        Display.getCurrent().dispose();
    }

}
