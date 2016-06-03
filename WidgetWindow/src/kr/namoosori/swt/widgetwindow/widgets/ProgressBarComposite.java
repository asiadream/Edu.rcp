package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

public class ProgressBarComposite extends Composite {

    public ProgressBarComposite(Composite parent) {
        super(parent, SWT.NONE);
        // setLayout(new FillLayout());
        // SMOOTH,HORIZONTAL,VERTICAL
        final ProgressBar bar = new ProgressBar(this, SWT.SMOOTH);
        bar.setMaximum(100);
        // bar.setBounds(10, 10, 200, 32);
        Rectangle clientArea = this.getClientArea();
        bar.setBounds(clientArea.x, clientArea.y, 200, 20);

        final Display display = getShell().getDisplay();
        /*
        display.timerExec(100, new Runnable() {
            int i = 0;
            @Override
            public void run() {
                if (bar.isDisposed()) return;
                bar.setSelection(i++);
                if (i <= bar.getMaximum()) display.timerExec(100, this);
            }
        });
        */
        
        final int maximum = bar.getMaximum();
        
        new Thread() {
            @Override
            public void run() {
                for (final int[] i = new int[1]; i[0] <= maximum; i[0]++) {
                    System.out.println("Thread:"+i[0]);
                    try {
                        Thread.sleep(100);
                    } catch (Throwable th) {
                    }
                    if (display.isDisposed())
                        return;
                    display.asyncExec(new Runnable() {
                        @Override
                        public void run() {
                            if (bar.isDisposed())
                                return;
                            bar.setSelection(i[0]);
                            System.out.println("Display:"+i[0]);
                        }
                    });
                }
            }
        }.start();
        
        
        
        /*
        final Label label = new Label(this, SWT.NONE);
        label.setText("1");
        label.setBounds(clientArea.x, clientArea.y + 30, 200, 20);
        new Thread() {
            @Override
            public void run() {
                for (final int[] i = new int[1]; i[0] <= maximum; i[0]++) {
                    try {
                        Thread.sleep(100);
                    } catch (Throwable th) {
                    }
                    System.out.println(""+i[0]);
                    if (display.isDisposed())
                        return;
                    display.syncExec(new Runnable() {
                        @Override
                        public void run() {
                            if (label.isDisposed()){
                                System.out.println("dispose");
                                return;
                            }
                            System.out.println("label:"+i[0]);
                            label.setText("" + i[0]);
                        }
                    });
                }
            }
        }.start();
        */
    }

}
