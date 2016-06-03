package kr.namoosori.swt.widgetwindow.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class ComboComposite extends Composite {

    public ComboComposite(Composite parent) {
        super(parent, SWT.NONE);
        setLayout(new RowLayout());
        
        int[] comboStyles = {SWT.SIMPLE, SWT.DROP_DOWN, SWT.READ_ONLY};
        for (int i = 0; i < comboStyles.length; i++) {
            Combo combo = new Combo(this, comboStyles[i]);
            combo.add("Option #1");
            combo.add("Option #2");
            combo.add("Option #3");
        }
    }

}
