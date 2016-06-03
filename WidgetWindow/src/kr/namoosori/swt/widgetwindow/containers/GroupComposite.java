package kr.namoosori.swt.widgetwindow.containers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class GroupComposite extends Composite {

    public GroupComposite(Composite parent) {
        super(parent, SWT.NONE);
        Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
        group.setText("그룹 타이틀");
        
        Label label = new Label(group, SWT.NONE);
        label.setText("선택하세요");
        label.setLocation(20, 20);
        label.pack();
        
        Button button1 = new Button(group, SWT.PUSH);
        button1.setText("PUSH 버튼");
        button1.setLocation(20, 45);
        button1.pack();
        
        Button button2 = new Button(group, SWT.CHECK);
        button2.setText("CHECK 버튼");
        button2.setLocation(20, 75);
        button2.pack();
        
        group.pack();
    }

}
