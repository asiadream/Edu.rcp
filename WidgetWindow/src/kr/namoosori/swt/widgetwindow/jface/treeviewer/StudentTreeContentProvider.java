package kr.namoosori.swt.widgetwindow.jface.treeviewer;

import kr.namoosori.swt.widgetwindow.jface.Student;
import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class StudentTreeContentProvider extends ArrayContentProvider implements ITreeContentProvider {
    @Override
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof Teacher) {
            Teacher teacher = (Teacher) parentElement;
            return teacher.getStudents().toArray();
        }
        return null;
    }
    @Override
    public Object getParent(Object element) {
        if (element instanceof Student) {
            Student student = (Student) element;
            return student.getTeacher();
        }
        return null;
    }
    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof Teacher) {
            Teacher teacher = (Teacher) element;
            return teacher.hasStudents();
        }
        return false;
    }
}
