package kr.namoosori.swt.widgetwindow.dialog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import kr.namoosori.swt.widgetwindow.dialog.wizard.ProjectWizard;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;

public class CallDialogComposite extends Composite {

    public CallDialogComposite(Composite parent) {
        super(parent, SWT.NONE);
        this.setLayout(new GridLayout(2, false));
        
        Composite swtGroup = createSWTDialogs(this);
        swtGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Composite jfaceGroup = createJFaceDialogs(this);
        jfaceGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    private Composite createJFaceDialogs(Composite parent) {
        final Group group = new Group(parent, SWT.NONE);
        group.setLayout(new GridLayout(4, false));
        group.setText("JFace Dialogs");
        
        Button msgButton = new Button(group, SWT.PUSH);
        msgButton.setText("Message");
        msgButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                MessageDialog dialog = new MessageDialog(getShell(), 
                        "메시지 다이얼로그", null, 
                        "안녕하십니까?", 
                        MessageDialog.QUESTION, 
                        new String[]{"안녕함", "안녕하지 못함"}, 
                        0);
                int result = dialog.open();
                System.out.println(result);
            }
        });
        
        Button errorButton = new Button(group, SWT.PUSH);
        errorButton.setText("Error");
        errorButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                someProcess();
            }
        });
        
        Button inputButton = new Button(group, SWT.PUSH);
        inputButton.setText("Input");
        inputButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                createInputDialog();
            }
        });
        
        Button progressButton = new Button(group, SWT.PUSH);
        progressButton.setText("Progress");
        progressButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                createProgressDialog();
            }
        });
        
        Button indicatorButton = new Button(group, SWT.PUSH);
        indicatorButton.setText("Indicator");
        indicatorButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                createProgressIndicator(group);
            }
        });
        
        Button loginButton = new Button(group, SWT.PUSH);
        loginButton.setText("Login");
        loginButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                LoginDialog dialog = new LoginDialog(getShell());
                dialog.open();
            }
        });
        
        Button joinButton = new Button(group, SWT.PUSH);
        joinButton.setText("Join");
        joinButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                JoinDialog dialog = new JoinDialog(getShell());
                dialog.open();
            }
        });
        
        Button wizardButton = new Button(group, SWT.PUSH);
        wizardButton.setText("Wizard");
        wizardButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                ProjectWizard wizard = new ProjectWizard();
                WizardDialog wizardDialog = new WizardDialog(getShell(), wizard);
                wizardDialog.create();
                wizardDialog.open();
            }
        });
        
        return group;
    }
    
    private void createProgressIndicator(Composite parent) {
        final ProgressIndicator indicator = new ProgressIndicator(parent, SWT.SMOOTH);
        GridData data = new GridData(SWT.FILL, SWT.TOP, true, false, 4, 1);
        indicator.setLayoutData(data);
        parent.layout();
        indicator.beginTask(10);
        Display.getCurrent().syncExec(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    indicator.worked(1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        indicator.dispose();
        parent.layout();
    }

    private void createProgressDialog() {
        ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
        
        IRunnableWithProgress runnable = new IRunnableWithProgress() {
            private int jobAmount;
            
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException,
                    InterruptedException {
                monitor.beginTask("작업 시작...", 100);
                
                while(!taskCompleted()) {
                    if (monitor.isCanceled()) {
                        throw new InterruptedException();
                    }
                    
                    int amount = 10;
                    doTask(amount);
                    monitor.worked(amount);
                }
                monitor.done();
            }

            private void doTask(int amount) {
                jobAmount = jobAmount + amount;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private boolean taskCompleted() {
                return jobAmount >= 100;
            }
        };
        
        try {
            dialog.run(true, true, runnable);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createInputDialog() {
        IInputValidator validator = new IInputValidator() {
            @Override
            public String isValid(String text) {
                if (text.length() < 5) {
                    return "5자리 이상 입력하세요.";
                } else if (text.length() > 12) {
                    return "12자리가 넘습니다.";
                }
                return null;
            }
        };
        
        InputDialog inputDialog = new InputDialog(getShell(),
                "문자열을 입력하세요.", "입력 문자열:",
                "defalut 문자열", validator);
        inputDialog.open();
    }

    @SuppressWarnings("null")
    private void someProcess() {
        try {
            String str = null;
            str.substring(3);
        } catch (Throwable t) {
            createErrorDialog(t);
        }
    }
    
    private void createErrorDialog(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);

        final String trace = sw.toString();

        List<Status> childStatuses = new ArrayList<Status>();
        for (String line : trace.split(System.getProperty("line.separator"))) {
            childStatuses.add(new Status(IStatus.ERROR, "some plugin id", line));
        }
        System.out.println("msg:"+t.getMessage());
        MultiStatus multiStatus = new MultiStatus("some plugin id",
                IStatus.OK,
                childStatuses.toArray(new Status[]{}),
                t.getClass().getSimpleName(),
                t);

        ErrorDialog dialog = new ErrorDialog(getShell(), 
                "에러 다이얼로그",
                "에러가 발생하였습니다.", 
                multiStatus, 
                IStatus.ERROR);
        dialog.open();
    }

    private Composite createSWTDialogs(Composite parent) {
        Group group = new Group(parent, SWT.NONE);
        group.setLayout(new GridLayout(4, false));
        group.setText("SWT Dialogs");
        
        Button colorButton = new Button(group, SWT.PUSH);
        colorButton.setText("Color");
        colorButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ColorDialog dialog = new ColorDialog(getShell());
                RGB rgb = dialog.open();
                System.out.println(rgb);
            }
        });
        
        Button dirButton = new Button(group, SWT.PUSH);
        dirButton.setText("Directory");
        dirButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(getShell());
                dialog.setMessage("디렉토리를 선택하세요.");
                String dir = dialog.open();
                System.out.println(dir);
            }
        });
        
        Button fileButton = new Button(group, SWT.PUSH);
        fileButton.setText("File");
        fileButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // SWT.SAVE, SWT.OPEN, SWT.MULTI
                FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
                dialog.setFileName("default.txt");
                dialog.setFilterNames(new String[]{"PDF파일", "모든파일"});
                dialog.setFilterExtensions(new String[]{"*.pdf", "*.*"});
                String file = dialog.open();
                System.out.println(file);
            }
        });
        
        Button multiFileButton = new Button(group, SWT.PUSH);
        multiFileButton.setText("MultiFile");
        multiFileButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell(), SWT.MULTI);
                dialog.open();
                String[] files = dialog.getFileNames();
                for (String file : files) {
                    System.out.println(file);
                }
            }
        });
        
        Button fontButton = new Button(group, SWT.PUSH);
        fontButton.setText("Font");
        fontButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FontDialog dialog = new FontDialog(getShell());
                FontData fontData = dialog.open();
                System.out.println(fontData);
            }
        });
        
        Button msgButton = new Button(group, SWT.PUSH);
        msgButton.setText("MessageBox");
        msgButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                MessageBox dialog = new MessageBox(getShell(),
                        //SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION
                        SWT.YES | SWT.NO | SWT.ICON_WORKING
                        //SWT.ABORT | SWT.RETRY | SWT.IGNORE | SWT.ICON_WARNING
                        );
                dialog.setMessage("계속 진행하겠습니까?");
                int returnVal = dialog.open();
                System.out.println(returnVal);
            }
        });
        return group;
    }
    
}
