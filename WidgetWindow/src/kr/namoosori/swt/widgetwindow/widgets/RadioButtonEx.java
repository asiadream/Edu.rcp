package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RadioButtonEx {
	public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("라디오 버튼");
        shell.setLayout(new GridLayout(3, true));
        
        Button[] radios = new Button[3];
        
        radios[0] = new Button(shell, SWT.RADIO);
        radios[0].setLayoutData(new GridData(GridData.FILL_BOTH));
        radios[0].setText("선택사항1");
        radios[0].setSelection(true);
        
        radios[1] = new Button(shell, SWT.RADIO);
        radios[1].setLayoutData(new GridData(GridData.FILL_BOTH));
        radios[1].setText("선택사항2");
        
        radios[2] = new Button(shell, SWT.RADIO);
        radios[2].setLayoutData(new GridData(GridData.FILL_BOTH));
        radios[2].setText("선택사항3");
        
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
