package kr.namoosori.swt.widgetwindow.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class FillLayoutComposite extends Composite {

    public FillLayoutComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        FillLayout layout = new FillLayout(SWT.VERTICAL);
        setLayout(layout);
        for (int i = 0; i < 8; i++) {
            Button button = new Button(this, SWT.NONE);
            button.setText("Sample Text-"+i);
        }
    }

}
