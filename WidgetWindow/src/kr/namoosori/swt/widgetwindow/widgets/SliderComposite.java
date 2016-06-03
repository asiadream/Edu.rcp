package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;

public class SliderComposite extends Composite {

    public SliderComposite(Composite parent) {
        super(parent, SWT.NONE);
        setLayout(new FillLayout());
        final Slider slider = new Slider(this, SWT.HORIZONTAL);
        slider.setValues(1000, 400, 1600, 200, 10, 100);
        slider.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println("selection:"+slider.getSelection());
            }
        });
    }

}
