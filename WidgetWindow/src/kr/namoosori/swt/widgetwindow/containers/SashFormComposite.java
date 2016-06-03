package kr.namoosori.swt.widgetwindow.containers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class SashFormComposite extends Composite {

    public SashFormComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        this.setLayout(new FillLayout());
        
        SashForm sf = new SashForm(this, SWT.VERTICAL);
        
        Button button1 = new Button(sf, SWT.PUSH);
        button1.setText("첫번째 버튼");
        
        Button button2 = new Button(sf, SWT.PUSH);
        button2.setText("두번째 버튼");
        
        sf.setWeights(new int[]{30,70});
    }

}
