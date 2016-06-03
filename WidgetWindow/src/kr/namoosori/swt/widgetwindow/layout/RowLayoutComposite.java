package kr.namoosori.swt.widgetwindow.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class RowLayoutComposite extends Composite {

    public RowLayoutComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        layout.marginWidth = 10;
        layout.marginHeight = 20;
        layout.spacing = 5;
        //layout.wrap = false;
        //layout.justify = true;
        setLayout(layout);
        for (int i = 0; i < 8; i++) {
            Button button = new Button(this, SWT.NONE);
            button.setText("Sample Text-"+i);
            button.setLayoutData(new RowData(200 + (5*i), 20 + i));
        }
    }

}
