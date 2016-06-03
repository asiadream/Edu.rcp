package kr.namoosori.swt.widgetwindow.jface.treeviewer;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FilterExample {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		StructuredViewer viewer = new TableViewer(shell);
		StudentAgeFilter filter = new StudentAgeFilter(40);
		viewer.addFilter(filter);
		
		viewer.removeFilter(filter);
		filter = new StudentAgeFilter(30);
		viewer.addFilter(filter);
	}
}
