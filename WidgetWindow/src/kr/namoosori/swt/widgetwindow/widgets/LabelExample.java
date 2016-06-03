package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LabelExample {
	
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Label Example");
        
        Label label1 = new Label(shell, SWT.CENTER);
        label1.setText("구분선 SHADOW_IN");
        label1.setBounds(20, 30, 200, 15);
        
        Label shadowIn = new Label(shell, SWT.SEPARATOR | SWT.SHADOW_IN | SWT.HORIZONTAL);
        shadowIn.setBounds(20, 50, 200, 5);
        
        Label label2 = new Label(shell, SWT.CENTER);
        label2.setText("구분선 SHADOW_OUT");
        label2.setBounds(20, 70, 200, 15);
        
        Label shadowOut = new Label(shell, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
        shadowOut.setBounds(20, 90, 200, 5);
        
        shell.pack();
        shell.open();
        while(!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
