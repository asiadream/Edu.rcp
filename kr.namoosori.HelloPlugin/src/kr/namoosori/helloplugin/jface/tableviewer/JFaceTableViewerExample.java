package kr.namoosori.helloplugin.jface.tableviewer;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class JFaceTableViewerExample {
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("JFace Example");
		shell.setBounds(100, 100, 325, 200);
		shell.setLayout(new FillLayout());
		
		TableViewer tableViewer = new TableViewer(shell, SWT.SINGLE | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		String[] columnNames = new String[] {"FirstName", "LastName", "Age", "Num Children"};
		int[] columnWidths = new int[] {90,90,35,90};
		int[] columnAlignments = new int[]{SWT.LEFT, SWT.LEFT, SWT.CENTER, SWT.CENTER};
		
		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = new TableColumn(table, columnAlignments[i]);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}
		
		tableViewer.setLabelProvider(new PersonTableLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		
		// table sort
		new TableColumnsSelectionListener(new TableSorter(), tableViewer);
		
		tableViewer.setInput(Person.example());
		
		shell.open();
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
