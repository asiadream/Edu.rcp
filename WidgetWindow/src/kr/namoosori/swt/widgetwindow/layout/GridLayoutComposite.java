package kr.namoosori.swt.widgetwindow.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class GridLayoutComposite extends Composite {

    public GridLayoutComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        GridLayout layout = new GridLayout(4, false);
        setLayout(layout);
        for (int i = 0; i < 16; i++) {
            Button button = new Button(this, SWT.NONE);
            button.setText("Sample Text-"+i);
        }
    }

}
