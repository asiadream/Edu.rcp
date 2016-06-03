package kr.namoosori.opendic.editors;

import kr.namoosori.opendic.object.Word;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;


public class WordEditorInput implements IEditorInput {
	
	private Word word;
	
	public WordEditorInput(Word word) {
		super();
		this.word = word;
	}

	public Word getWord() {
		return word;
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return word.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof WordEditorInput)) return false;
		if (this.word == null) return false;
		
		WordEditorInput other = (WordEditorInput) obj;
		return this.word.equals(other.word);
	}
	
}
