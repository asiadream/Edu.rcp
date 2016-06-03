package kr.namoosori.swt.widgetwindow.jface.listviewer;

import kr.namoosori.swt.widgetwindow.jface.Teacher;
import kr.namoosori.swt.widgetwindow.jface.treeviewer.StudentLabelProvider;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ListViewerComposite extends Composite {

    public ListViewerComposite(Composite parent) {
        super(parent, SWT.NONE);
        this.setLayout(new FillLayout());
        
        ListViewer listViewer = new ListViewer(this, SWT.SINGLE);
        listViewer.setLabelProvider(new StudentLabelProvider(getDisplay()));
        listViewer.setContentProvider(new ArrayContentProvider());
        listViewer.setInput(Teacher.example());
    }

}
