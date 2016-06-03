package kr.namoosori.swt.widgetwindow.jface.tableviewer;

import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class TeacherTableLabelProvider extends LabelProvider implements
        ITableLabelProvider {
    private Image teacherImage;
    
    public TeacherTableLabelProvider(Display display) {
        teacherImage = new Image(display, 
                getClass().getResourceAsStream("user_gray.png"));
    }
    
    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof Teacher) {
            if (columnIndex == 0) {
                return teacherImage;
            }
        }
        return null;
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof Teacher) {
            Teacher teacher = (Teacher) element;
    
            switch (columnIndex) {
            case 0:
                return teacher.getName();
            case 1:
                return teacher.getLectureTitle();
            case 2:
                return ""+teacher.getStudentsSize();
            default:
                return "unknown " + columnIndex;
            }
        }
        return "";
    }
    
    @Override
    public void dispose() {
        teacherImage.dispose();
        super.dispose();
    }
}
