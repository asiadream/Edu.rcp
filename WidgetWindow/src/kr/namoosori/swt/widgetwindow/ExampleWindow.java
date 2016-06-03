package kr.namoosori.swt.widgetwindow;

import kr.namoosori.swt.widgetwindow.containers.GroupSashComposite;
import kr.namoosori.swt.widgetwindow.dialog.CallDialogComposite;
import kr.namoosori.swt.widgetwindow.graphics.ImageComposite;
import kr.namoosori.swt.widgetwindow.jface.listviewer.ListViewerComposite;
import kr.namoosori.swt.widgetwindow.jface.tableviewer.TableViewerComposite;
import kr.namoosori.swt.widgetwindow.jface.treeviewer.TreeViewerComposite;
import kr.namoosori.swt.widgetwindow.layout.FillLayoutComposite;
import kr.namoosori.swt.widgetwindow.layout.GridLayoutComposite;
import kr.namoosori.swt.widgetwindow.layout.GridLayoutWithDataComposite;
import kr.namoosori.swt.widgetwindow.layout.GridLayoutWithGrapComposite;
import kr.namoosori.swt.widgetwindow.text.TextComposite;
import kr.namoosori.swt.widgetwindow.text.UndoComposite;
import kr.namoosori.swt.widgetwindow.widgets.ComboComposite;
import kr.namoosori.swt.widgetwindow.widgets.SliderComposite;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class ExampleWindow extends ApplicationWindow {

    public ExampleWindow() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {
        getShell().setText("예제 윈도우");
        //parent.setSize(400, 250);
        
        TabFolder folder = new TabFolder(parent, SWT.NONE);
        
        TabItem item1 = new TabItem(folder, SWT.NONE);
        item1.setText("그룹과Sash");
        item1.setControl(new GroupSashComposite(folder));
        
        TabItem item2 = new TabItem(folder, SWT.NONE);
        item2.setText("Text");
        item2.setControl(new TextComposite(folder));
        
        TabItem item3 = new TabItem(folder, SWT.NONE);
        item3.setText("Undo");
        item3.setControl(new UndoComposite(folder));
        
        TabItem item4 = new TabItem(folder, SWT.NONE);
        item4.setText("Combo");
        item4.setControl(new ComboComposite(folder));
        
        TabItem item5 = new TabItem(folder, SWT.NONE);
        item5.setText("Slider");
        item5.setControl(new SliderComposite(folder));
        
//        TabItem item6 = new TabItem(folder, SWT.NONE);
//        item6.setText("Progress");
//        item6.setControl(new ProgressBarComposite(folder));
        
        TabItem item7 = new TabItem(folder, SWT.NONE);
        item7.setText("FillLayout");
        item7.setControl(new FillLayoutComposite(folder));
        
//        TabItem item8 = new TabItem(folder, SWT.NONE);
//        item8.setText("RowLayout");
//        item8.setControl(new RowLayoutComposite(folder));
        
        TabItem item9 = new TabItem(folder, SWT.NONE);
        item9.setText("GridLayout");
        item9.setControl(new GridLayoutComposite(folder));
        
        TabItem item10 = new TabItem(folder, SWT.NONE);
        item10.setText("GridData");
        item10.setControl(new GridLayoutWithDataComposite(folder));
        
        TabItem item11 = new TabItem(folder, SWT.NONE);
        item11.setText("GrapEx");
        item11.setControl(new GridLayoutWithGrapComposite(folder));
        
        TabItem item12 = new TabItem(folder, SWT.NONE);
        item12.setText("Image");
        item12.setControl(new ImageComposite(folder));
        
        TabItem item13 = new TabItem(folder, SWT.NONE);
        item13.setText("Tree");
        item13.setControl(new TreeViewerComposite(folder));
        
        TabItem item14 = new TabItem(folder, SWT.NONE);
        item14.setText("List");
        item14.setControl(new ListViewerComposite(folder));
        
        TabItem item15 = new TabItem(folder, SWT.NONE);
        item15.setText("Table");
        item15.setControl(new TableViewerComposite(folder));
        
        TabItem item16 = new TabItem(folder, SWT.NONE);
        item16.setText("Dialog");
        item16.setControl(new CallDialogComposite(folder));
        
        folder.setSelection(item16);
        return parent;
    }
    
	public static void main(String[] args) {
        ExampleWindow win = new ExampleWindow();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }

}
