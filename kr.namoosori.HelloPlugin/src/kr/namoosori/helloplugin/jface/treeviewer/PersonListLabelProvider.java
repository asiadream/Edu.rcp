package kr.namoosori.helloplugin.jface.treeviewer;

import kr.namoosori.helloplugin.jface.tableviewer.Person;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class PersonListLabelProvider extends LabelProvider {
	//
	@Override
	public Image getImage(Object element) {
		//
		return null;
	}
	
	@Override
	public String getText(Object element) {
		//
		Person person = (Person) element;
		return person.firstName + " " + person.lastName + "("+person.age+")";
	}

}
