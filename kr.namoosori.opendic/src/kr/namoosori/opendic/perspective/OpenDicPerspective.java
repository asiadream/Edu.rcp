package kr.namoosori.opendic.perspective;

import kr.namoosori.opendic.views.OpenDicDetailView;
import kr.namoosori.opendic.views.OpenDicView;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class OpenDicPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		
		layout.addView(OpenDicView.ID, IPageLayout.LEFT, 0.5f, editorArea);
		layout.addView(OpenDicDetailView.ID, IPageLayout.BOTTOM, 0.7f, editorArea);
	}

}
