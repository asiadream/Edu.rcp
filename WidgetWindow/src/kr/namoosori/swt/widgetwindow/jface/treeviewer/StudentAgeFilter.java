package kr.namoosori.swt.widgetwindow.jface.treeviewer;

import kr.namoosori.swt.widgetwindow.jface.Student;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class StudentAgeFilter extends ViewerFilter {
    private int minimumAge;
    
    public StudentAgeFilter(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if (element instanceof Student) {
            Student student = (Student) element;
            return student.getAge() >= minimumAge;
        }
        return true;
    }
}
