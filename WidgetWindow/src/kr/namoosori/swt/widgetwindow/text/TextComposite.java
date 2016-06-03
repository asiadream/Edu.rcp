package kr.namoosori.swt.widgetwindow.text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextComposite extends Composite {
    public TextComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        this.setLayout(new FillLayout());
        Text text = new Text(this, SWT.MULTI | SWT.V_SCROLL);
        text.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent e) {
                if (e.text.startsWith("1")) {
                    e.doit = false;
                } else {
                    e.text = e.text.toUpperCase();
                }
            }
        });
    }
}
