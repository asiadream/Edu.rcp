package kr.namoosori.swt.widgetwindow.graphics;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PaintListenerExample {
    private Shell shell;
    
    public PaintListenerExample(Display display) {
        this.shell = new Shell(display);
    }
    
    public void open() {
        shell.setText("PaintListener Example");
        shell.setSize(590, 120);
        shell.setLocation(300, 300);
        shell.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                Color blue = new Color(e.display, 0, 0, 255);
                e.gc.setBackground(blue);
                for (int i = 1; i < 11; i++) {
                    e.gc.setAlpha(i * 25);
                    e.gc.fillRectangle(50 * i, 20, 40, 40);
                }
                blue.dispose();
                e.gc.dispose();
            }
        });
        shell.open();
    }
    
    public Shell getShell() {
        return shell;
    }
    
    public static void main(String[] args) {
        Display display = new Display();
        PaintListenerExample example = new PaintListenerExample(display);
        example.open();
        
        while (!example.getShell().isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        example.getShell().dispose();
    }
}
