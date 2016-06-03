package kr.namoosori.swt.widgetwindow.containers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class GroupSashComposite extends Composite {

    public GroupSashComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        GroupComposite group = new GroupComposite(this);
        group.setLocation(0,0);
        group.pack();
        
        SashFormComposite sash = new SashFormComposite(this);
        sash.setLocation(125, 7);
        sash.pack();
        
        pack();
    }

}
