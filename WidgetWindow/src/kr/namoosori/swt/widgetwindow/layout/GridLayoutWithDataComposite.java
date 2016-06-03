package kr.namoosori.swt.widgetwindow.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class GridLayoutWithDataComposite extends Composite {

    public GridLayoutWithDataComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        GridLayout layout = new GridLayout(3, false);
        setLayout(layout);
        
        Button button1 = new Button(this, SWT.PUSH);
        button1.setText("버튼 1");
        
        Button button2 = new Button(this, SWT.PUSH);
        GridData data2 = new GridData(GridData.FILL_HORIZONTAL);
        button2.setLayoutData(data2);
        button2.setText("버튼 2");
        
        Button button3 = new Button(this, SWT.PUSH);
        button3.setText("버튼 3");
        
        Text textArea = new Text(this, SWT.BORDER | SWT.WRAP | SWT.MULTI);
        GridData textData = new GridData(GridData.FILL_BOTH);
        textData.horizontalSpan = 2;
        textData.verticalSpan = 2;
        textArea.setLayoutData(textData);
        textArea.setText("텍스트 영역");
        
        Button button4 = new Button(this, SWT.PUSH);
        GridData data4 = new GridData(GridData.FILL_VERTICAL);
        button4.setLayoutData(data4);
        button4.setText("버튼 4");
        
        Button button5 = new Button(this, SWT.PUSH);
        GridData data5 = new GridData(GridData.FILL_VERTICAL);
        button5.setLayoutData(data5);
        button5.setText("버튼 5");
    }

}
