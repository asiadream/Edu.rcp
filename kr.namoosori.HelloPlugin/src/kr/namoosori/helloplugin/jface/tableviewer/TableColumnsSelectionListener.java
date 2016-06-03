package kr.namoosori.helloplugin.jface.tableviewer;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableColumnsSelectionListener {
	//
	private TableSorter sorter;
	private TableViewer viewer;
	
	public TableColumnsSelectionListener(TableSorter sorter, TableViewer viewer) {
		this.sorter = sorter;
		this.viewer = viewer;
		viewer.setSorter(sorter);
		createColumsSortEvent();
	}

	private void createColumsSortEvent() {
		//
		Table table = viewer.getTable();
		TableColumn[] columns = table.getColumns();
		
		// 각 컬럼에 이벤트 추가
		for (int i = 0; i < columns.length; i++) {
			final int index = i;
			final TableColumn column = columns[i];
			column.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					sorter.setColumn(index);
					int dir = viewer.getTable().getSortDirection();
					if (viewer.getTable().getSortColumn() == column) {
						dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
					} else {
						dir = SWT.DOWN;
					}
					viewer.getTable().setSortDirection(dir);
					viewer.getTable().setSortColumn(column);
					viewer.refresh();
				}

			});
		}
	}
}
