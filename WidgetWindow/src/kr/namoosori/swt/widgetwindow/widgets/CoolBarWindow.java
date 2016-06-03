package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class CoolBarWindow extends ApplicationWindow {

	public CoolBarWindow() {
		super(null);
		addCoolBar(SWT.FLAT | SWT.WRAP);
	}

	@Override
	protected Control createContents(Composite parent) {
		getShell().setText("CoolBar Test");
		
		String asCoolItemSection[] = { "File", "Formatting", "Search" };
		CoolBar coolbar = new CoolBar(parent, SWT.NONE);
		for (int idxCoolItem = 0; idxCoolItem < 3; ++idxCoolItem) {
			CoolItem item = new CoolItem(coolbar, SWT.NONE);
			ToolBar tb = new ToolBar(coolbar, SWT.FLAT);
			for (int idxItem = 0; idxItem < 3; ++idxItem) {
				ToolItem ti = new ToolItem( tb, SWT.NONE );
				ti.setText( asCoolItemSection[ idxCoolItem ] + " Item #" + idxItem );
			}
			Point p = tb.computeSize( SWT.DEFAULT, SWT.DEFAULT );
			tb.setSize( p );
			Point p2 = item.computeSize( p.x, p.y);
			item.setControl(tb);
			item.setSize( p2);
		}
		
		return parent;
	}

	public static void main(String[] args) {
		CoolBarWindow win = new CoolBarWindow();
        win.setBlockOnOpen(true);
        win.open();
        
        Display.getCurrent().dispose();
    }

}
