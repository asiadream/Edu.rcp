package kr.namoosori.swt.widgetwindow.jface.tableviewer;

import kr.namoosori.swt.widgetwindow.jface.Teacher;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

public class TeacherCellModifier implements ICellModifier {
    private TableViewer viewer;
    public TeacherCellModifier(TableViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public boolean canModify(Object element, String property) {
        if (element instanceof Teacher) {
            if ("name".equals(property) || "lecture".equals(property)) return true;
        }
        return false;
    }

    @Override
    public Object getValue(Object element, String property) {
        if (element instanceof Teacher) {
            if ("name".equals(property)) return ((Teacher)element).getName();
            if ("lecture".equals(property)) return ((Teacher)element).getLectureTitle();
        }
        return null;
    }

    @Override
    public void modify(Object element, String property, Object value) {
        TableItem tableItem = (TableItem) element;
        Teacher teacher = (Teacher) tableItem.getData();
        if ("name".equals(property)) {
            teacher.setName(value.toString());
        } else if ("lecture".equals(property)) {
            teacher.setLectureTitle(value.toString());
        }
        viewer.refresh();
    }
}
