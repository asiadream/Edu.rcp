package kr.namoosori.swt.widgetwindow.event;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;

public class UserMouseListener implements MouseListener {

    @Override
    public void mouseDoubleClick(MouseEvent event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getText() + ":double click");
    }

    @Override
    public void mouseDown(MouseEvent event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getText() + ":mouse down");
    }

    @Override
    public void mouseUp(MouseEvent event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getText() + ":mouse up");
    }

}
