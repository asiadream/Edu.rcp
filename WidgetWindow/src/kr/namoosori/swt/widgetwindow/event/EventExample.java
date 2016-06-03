package kr.namoosori.swt.widgetwindow.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class EventExample {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        final String title = "�̺�Ʈ ����:";
        Button button = new Button(shell, SWT.PUSH);
        button.setText("��ư1");
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseUp(MouseEvent e) {
                System.out.println(title + "���콺 UP");
            }

            @Override
            public void mouseDown(MouseEvent e) {
                System.out.println(title + "���콺 DOWN");
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                System.out.println(title + "���콺 ����Ŭ��");
            }
        });

        Button button2 = new Button(shell, SWT.PUSH);
        button2.setText("��ư2");
        button2.addMouseListener(new UserMouseListener());

        Button button3 = new Button(shell, SWT.PUSH);
        button3.setText("��ư3");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                System.out.println("double click.");
            }
        });

        Listener untyped = new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.widget instanceof Button) {
                    switch (event.type) {
                    case SWT.MouseEnter:
                        ((Button)event.widget).setText("Mouse Enter");
                        break;
                    case SWT.MouseExit:
                        ((Button)event.widget).setText("Mouse Exit");
                        break;
                    }
                } else if (event.widget instanceof Label) {
                    switch (event.type) {
                    case SWT.MouseEnter:
                        ((Label)event.widget).setText("Mouse Enter");
                        break;
                    case SWT.MouseExit:
                        ((Label)event.widget).setText("Mouse Exit");
                        break;
                    }
                }
            }
        };

        Button button4 = new Button(shell, SWT.PUSH);
        button4.setText("��ư4");
        button4.addListener(SWT.MouseEnter, untyped);
        button4.addListener(SWT.MouseExit, untyped);
        
        Label lable = new Label(shell, SWT.NONE);
        lable.setText("��");
        lable.addListener(SWT.MouseEnter, untyped);
        lable.addListener(SWT.MouseExit, untyped);

        shell.setSize(400, 80);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
