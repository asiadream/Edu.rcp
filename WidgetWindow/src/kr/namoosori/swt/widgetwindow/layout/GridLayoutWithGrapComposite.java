package kr.namoosori.swt.widgetwindow.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class GridLayoutWithGrapComposite extends Composite {

    public GridLayoutWithGrapComposite(Composite parent) {
        super(parent, SWT.NONE);
        
        setLayout(new GridLayout(2, false));
        
        Label nameLabel = new Label(this, SWT.NONE);
        nameLabel.setText("�̸�:");
        
        Text nameText = new Text(this, SWT.BORDER);
        GridData nameTextData = new GridData();
        nameTextData.horizontalAlignment = SWT.FILL;
        nameTextData.grabExcessHorizontalSpace = true;
        nameTextData.widthHint = 150;
        nameText.setLayoutData(nameTextData);
        
        Label addressLable = new Label(this, SWT.NONE);
        GridData addressLableData = new GridData();
        addressLableData.verticalAlignment = SWT.TOP;
        addressLable.setLayoutData(addressLableData);
        addressLable.setText("�ּ�:");
        
        Text addressText = new Text(this, SWT.BORDER | SWT.MULTI | SWT.WRAP);
        GridData addressTextData = new GridData();
        addressTextData.horizontalAlignment = SWT.FILL;
        addressTextData.grabExcessHorizontalSpace = true;
        addressTextData.verticalAlignment = SWT.FILL;
        addressTextData.grabExcessVerticalSpace = true;
        addressTextData.heightHint = 50;
        addressText.setLayoutData(addressTextData);
        
        Label sportLabel = new Label(this, SWT.NONE);
        GridData sportData = new GridData();
        sportData.horizontalSpan = 2;
        sportLabel.setLayoutData(sportData);
        sportLabel.setText("�����ϴ� ������:");
        
        List sportList = new List(this, SWT.BORDER | SWT.MULTI);
        sportList.setItems(new String[]{"�౸", "�߱�"});
        GridData listData = new GridData();
        listData.horizontalSpan = 2;
        listData.horizontalAlignment = SWT.FILL;
        listData.grabExcessHorizontalSpace = true;
        listData.verticalAlignment = SWT.FILL;
        listData.grabExcessVerticalSpace = true;
        listData.heightHint = 50;
        sportList.setLayoutData(listData);
    }

}
