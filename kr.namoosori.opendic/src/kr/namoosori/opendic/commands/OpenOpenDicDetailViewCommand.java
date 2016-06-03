package kr.namoosori.opendic.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import kr.namoosori.opendic.views.OpenDicDetailView;

public class OpenOpenDicDetailViewCommand extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try {
            activePage.showView(OpenDicDetailView.ID);
        }
        catch (PartInitException e) {
            e.printStackTrace();
        }
        return null;
    }

}
