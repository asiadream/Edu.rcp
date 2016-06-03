package kr.namoosori.opendic.actions;

import kr.namoosori.opendic.views.OpenDicView;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

public class AddToOpenDicActionDelegate implements IObjectActionDelegate {
	private IWorkbenchPart targetPart;

	public AddToOpenDicActionDelegate() {
	}
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	@Override
	public void run(IAction action) {
		MessageDialog.openInformation(targetPart.getSite().getShell(), "컨텍스트메뉴", "ADD실행:"+getClass().getName());
		
		try {
			targetPart.getSite().getPage().showView(OpenDicView.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}


}
