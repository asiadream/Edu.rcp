package kr.namoosori.helloplugin.jface.tableviewer;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class PersonTableLabelProvider extends LabelProvider implements
		ITableLabelProvider {
	//
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		//
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		//
		Person person = (Person) element;

		switch (columnIndex) {
		case 0:
			return person.firstName;
		case 1:
			return person.lastName;
		case 2:
			return Integer.toString(person.age);
		case 3:
			return Integer.toString(person.children.length);
		default:
			return "unknown " + columnIndex;
		}
	}

}
