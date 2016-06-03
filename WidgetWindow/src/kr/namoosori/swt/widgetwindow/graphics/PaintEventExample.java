package kr.namoosori.swt.widgetwindow.graphics;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PaintEventExample {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Drawing Example");
        shell.setSize(200, 220);
        
        Canvas canvas = new Canvas(shell, SWT.NONE);
        canvas.setSize(150, 150);
        canvas.setLocation(20, 20);
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                System.out.println("paint...");
                GC gc = e.gc;
                gc.drawPolyline(new int[] {10,120,70,100,100,130,130,75});
            }
        });
        shell.open();
        
        while(!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
