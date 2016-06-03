package kr.namoosori.swt.widgetwindow.dialog.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class ProjectWizard extends Wizard {
    public ProjectWizard() {
        super();
    }

    public void addPages() {
        addPage(new DirectoryPage());
        addPage(new ChooseDirectoryPage());
        addPage(new SummaryPage());
    }

    public boolean performFinish() {
        DirectoryPage dirPage = getDirectoryPage();
        if (dirPage.useDefaultDirectory()) {
            System.out.println("�⺻ ���丮 �����");
        } else {
            ChooseDirectoryPage choosePage = getChoosePage();
            System.out.println("������� ���丮: " + choosePage.getDirectory());
        }
        return true;
    }

    private ChooseDirectoryPage getChoosePage() {
        return (ChooseDirectoryPage) getPage(ChooseDirectoryPage.PAGE_NAME);
    }

    private DirectoryPage getDirectoryPage() {
        return (DirectoryPage) getPage(DirectoryPage.PAGE_NAME);
    }

    public boolean performCancel() {
        System.out.println("Perform Cancel called");
        return true;
    }

    public IWizardPage getNextPage(IWizardPage page) {
        if (page instanceof DirectoryPage) {
            DirectoryPage dirPage = (DirectoryPage) page;
            if (dirPage.useDefaultDirectory()) {
                SummaryPage summaryPage = (SummaryPage) getPage(SummaryPage.PAGE_NAME);
                summaryPage.updateText("�⺻ ���丮 �����");
                return summaryPage;
            }
        }

        IWizardPage nextPage = super.getNextPage(page);
        if (nextPage instanceof SummaryPage) {
            SummaryPage summary = (SummaryPage) nextPage;
            DirectoryPage dirPage = getDirectoryPage();
            summary.updateText(dirPage.useDefaultDirectory() ? "�⺻ ���丮 �����"
                    : "������� ���丮:" + getChoosePage().getDirectory());
        }
        return nextPage;
    }
}
