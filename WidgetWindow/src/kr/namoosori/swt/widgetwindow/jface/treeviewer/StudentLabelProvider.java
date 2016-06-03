package kr.namoosori.swt.widgetwindow.jface.treeviewer;

import kr.namoosori.swt.widgetwindow.jface.Student;
import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class StudentLabelProvider extends LabelProvider {
    private Image teacherImage;
    private Image studentImage;
    
    public StudentLabelProvider(Display display) {
        teacherImage = new Image(display, 
                getClass().getResourceAsStream("user_gray.png"));
        studentImage = new Image(display, 
                getClass().getResourceAsStream("user.png"));
    }
    
    @Override
    public Image getImage(Object element) {
        if (element instanceof Teacher) {
            return teacherImage;
        }
        if (element instanceof Student) {
            return studentImage;
        }
        return null;
    }
    
    @Override
    public String getText(Object element) {
        if (element instanceof Teacher) {
            Teacher teacher = (Teacher) element;
            return teacher.getName() + "(" + teacher.getLectureTitle() + ")";
        }
        if (element instanceof Student) {
            Student student = (Student) element;
            return student.getName() + ":" + student.getEmail()+ ":" + student.getAge();
        }
        return "";
    }
    
    @Override
    public void dispose() {
        teacherImage.dispose();
        studentImage.dispose();
        super.dispose();
    }
}
