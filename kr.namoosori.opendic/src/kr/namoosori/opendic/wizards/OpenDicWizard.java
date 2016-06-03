package kr.namoosori.opendic.wizards;

import org.eclipse.jface.wizard.Wizard;

public class OpenDicWizard extends Wizard {
	
	private OpenDicStep1 step1;
	private OpenDicStep2 step2;
	private OpenDicStep3 step3;

	public OpenDicWizard() {
		super();
		setWindowTitle("���µ� ������");
	}
	
	@Override
	public void addPages() {
		addPage(step1 = new OpenDicStep1());
		addPage(step2 = new OpenDicStep2());
		addPage(step3 = new OpenDicStep3());
	}

	@Override
	public boolean canFinish() {
		if (getContainer() == null) return false;
		if (getContainer().getCurrentPage() == step3) return true;
		return super.canFinish();
	}

	@Override
	public boolean performFinish() {
		System.out.println("�����縦 ������.");
		return true;
	}

}
