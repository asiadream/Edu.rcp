package kr.namoosori.swt.widgetwindow.jface.tableviewer;

import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableViewerComposite extends Composite {
    public TableViewerComposite(Composite parent) {
        super(parent, SWT.NONE);
        this.setLayout(new FillLayout());
        
        TableViewer tableViewer = new TableViewer(this, SWT.SINGLE
                | SWT.FULL_SELECTION);
        Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        TableColumn nameColumn = new TableColumn(table, SWT.LEFT);
        nameColumn.setText("이름");
        nameColumn.setWidth(100);
        nameColumn.setMoveable(true);
        
        TableColumn lectureColumn = new TableColumn(table, SWT.LEFT);
        lectureColumn.setText("과목");
        lectureColumn.setWidth(150);
        
        TableColumn studentColumn = new TableColumn(table, SWT.CENTER);
        studentColumn.setText("학생수");
        studentColumn.setWidth(50);
        studentColumn.setResizable(false);
        
        tableViewer.setContentProvider(new ArrayContentProvider());
        tableViewer.setLabelProvider(new TeacherTableLabelProvider(getDisplay()));
        
        tableViewer.setColumnProperties(new String[]{"name", "lecture"});
        tableViewer.setCellEditors(new CellEditor[]{new TextCellEditor(table),new TextCellEditor(table)});
        tableViewer.setCellModifier(new TeacherCellModifier(tableViewer));
        
        tableViewer.setInput(Teacher.example());
    }
}
