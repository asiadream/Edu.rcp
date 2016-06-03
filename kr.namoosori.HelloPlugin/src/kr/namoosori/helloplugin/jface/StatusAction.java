package kr.namoosori.helloplugin.jface;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.resource.ImageDescriptor;

public class StatusAction extends Action {
	//
	private StatusLineManager manager;
	private int count;
	
	public StatusAction(StatusLineManager statusLineManager) {
		super("&Action@Ctrl+T", AS_PUSH_BUTTON); // (&)���������� : Alt --> M --> A , (@)����Ű
		this.manager = statusLineManager;
		setToolTipText("�׼� �߻�");
		//setText("�׼�");
		setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(), "sample.gif"));
	}

	@Override
	public void run() {
		count++;
		manager.setMessage("�׼� ����...count:"+count);
	}
}
