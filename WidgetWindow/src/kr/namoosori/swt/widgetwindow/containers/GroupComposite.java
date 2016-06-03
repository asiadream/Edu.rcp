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
        group.setText("�׷� Ÿ��Ʋ");
        
        Label label = new Label(group, SWT.NONE);
        label.setText("�����ϼ���");
        label.setLocation(20, 20);
        label.pack();
        
        Button button1 = new Button(group, SWT.PUSH);
        button1.setText("PUSH ��ư");
        button1.setLocation(20, 45);
        button1.pack();
        
        Button button2 = new Button(group, SWT.CHECK);
        button2.setText("CHECK ��ư");
        button2.setLocation(20, 75);
        button2.pack();
        
        group.pack();
    }

}
