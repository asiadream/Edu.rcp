package kr.namoosori.swt.widgetwindow.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.resource.ImageDescriptor;

public class StatusAction extends Action {
    private StatusLineManager manager;
    private int count;
    
    public StatusAction(StatusLineManager manager) {
        super("&Action@Ctrl+T");
        this.manager = manager;
        setToolTipText("액션 발생");
        setImageDescriptor(
                ImageDescriptor.createFromFile(this.getClass(), "sample.gif"));
    }

    @Override
    public void run() {
        count++;
        manager.setMessage("액션 실행... count:" + count);
    }
    
}
