package kr.namoosori.swt.widgetwindow.jface.tableviewer;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setSize(300, 100);
		
		// Set up the table layout
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(33, 75, true));
		layout.addColumnData(new ColumnWeightData(33, 75, true));
		layout.addColumnData(new ColumnWeightData(33, 75, true));
		Table table = new Table(shell, SWT.SINGLE);
		table.setLayout(layout);
		
		// Add columns to the table
		TableColumn column1 = new TableColumn(table, SWT.CENTER);
		TableColumn column2 = new TableColumn(table, SWT.CENTER);
		TableColumn column3 = new TableColumn(table, SWT.CENTER);
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "column 1", "column 2", "column 3" });
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "a", "b", "c" });

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
