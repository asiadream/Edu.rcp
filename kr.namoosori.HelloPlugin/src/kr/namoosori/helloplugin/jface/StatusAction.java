package kr.namoosori.helloplugin.jface;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.resource.ImageDescriptor;

public class StatusAction extends Action {
	//
	private StatusLineManager manager;
	private int count;
	
	public StatusAction(StatusLineManager statusLineManager) {
		super("&Action@Ctrl+T", AS_PUSH_BUTTON); // (&)엑셀레이터 : Alt --> M --> A , (@)단축키
		this.manager = statusLineManager;
		setToolTipText("액션 발생");
		//setText("액션");
		setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(), "sample.gif"));
	}

	@Override
	public void run() {
		count++;
		manager.setMessage("액션 실행...count:"+count);
	}
}
