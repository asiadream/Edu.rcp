package kr.namoosori.swt.widgetwindow.jface.treeviewer;

import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class TreeViewerComposite extends Composite {
    private ViewerFilter studentAgeFilter = new StudentAgeFilter(40);
    
    public TreeViewerComposite(Composite parent) {
        super(parent, SWT.NONE);
        this.setLayout(new GridLayout(2, false));
        
        final TreeViewer treeViewer = new TreeViewer(this, SWT.BORDER | SWT.SINGLE | SWT.CHECK);
        GridData treeData = new GridData(GridData.FILL_BOTH);
        treeData.verticalSpan = 2;
        treeViewer.getTree().setLayoutData(treeData);
        treeViewer.setLabelProvider(new StudentLabelProvider(getShell().getDisplay()));
        treeViewer.setContentProvider(new StudentTreeContentProvider());
        treeViewer.setInput(Teacher.example());
        
        Button chkFilter = new Button(this, SWT.CHECK);
        chkFilter.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        chkFilter.setText("40세 이상만");
        chkFilter.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button btn = (Button) e.widget;
                if (btn.getSelection()) {
                    treeViewer.addFilter(studentAgeFilter);
                } else {
                    treeViewer.removeFilter(studentAgeFilter);
                }
            }
        });
        
        Button chkSort = new Button(this, SWT.CHECK);
        chkSort.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        chkSort.setText("정렬");
        chkSort.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button btn = (Button) e.widget;
                if (btn.getSelection()) {
                    treeViewer.setSorter(new StudentSorter());
                } else {
                    treeViewer.setSorter(null);
                }
            }
        });
    }
}
