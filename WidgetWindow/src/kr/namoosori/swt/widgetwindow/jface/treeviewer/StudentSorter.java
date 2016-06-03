package kr.namoosori.swt.widgetwindow.jface.treeviewer;

import kr.namoosori.swt.widgetwindow.jface.Student;
import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class StudentSorter extends ViewerSorter {

    @Override
    public int category(Object element) {
        //
        if (element instanceof Teacher) {
            return 1;
        }
        if (element instanceof Student) {
            return 2;
        }
        return 0;
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        int cat1 = category(e1);
        int cat2 = category(e2);
        if (cat1 != cat2) {
            return cat1 - cat2;
        }
        if (e1 instanceof Teacher && e2 instanceof Teacher) {
            Teacher t1 = (Teacher) e1;
            Teacher t2 = (Teacher) e2;
            return compareTo(t1.getName(), t2.getName());
        }
        if (e1 instanceof Student && e2 instanceof Student) {
            Student t1 = (Student) e1;
            Student t2 = (Student) e2;
            return compareTo(t1.getName(), t2.getName());
        }
        return 0;
    }
    
    protected int compareTo(String arg1, String arg2) {
        if (arg1 == null && arg2 == null) {
            return 0;
        }
        if (arg1 == null) {
            return -1;
        }
        if (arg2 == null) {
            return 1;
        }
        return arg1.compareTo(arg2);
    }

}
