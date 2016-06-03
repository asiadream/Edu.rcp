package kr.namoosori.helloplugin.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HelloSWT {
	//
	public static void main(String[] args) {
		//
		Display display = new Display(); // GUI �۾��� ���� Display ��ü�� �����Ѵ�.

		Shell shell = new Shell(display); // ������ �θ���. Shell �ν��Ͻ� ����
		shell.setText("Hello SWT"); // Shell(������������)�� ���� ����
		shell.setBounds(100, 100, 200, 80); // Shell�� ũ�� ���� (�»�� 100,100 ��ġ�� ����
											// 200, ���� 80�� ������ ����)
		shell.setLayout(new FillLayout()); // Shell�� ���̾ƿ� �����ڸ� ����

		Label label = new Label(shell, SWT.CENTER); // Label���� ����
		label.setText("Hello SWT !");
		
		Color red = new Color(display, 255, 0, 0);
		label.setForeground(red); // ���̺��� ��������
		shell.open(); // ������ ������ �����찡 ȭ�鿡 ǥ�õ�

		while (!shell.isDisposed()) { // ������ �������� �������� ��� Ȯ��
			if (!display.readAndDispatch()) { // �÷����� �̺�Ʈ ť���� �̺�Ʈ�� �о� ������ �̺�Ʈ
												// ���ù��� ����. ó���� �̺�Ʈ�� ������ true,
												// ť�� ��� �ֿ쿡�� flase ��ȯ
				display.sleep();
			}
		}
		red.dispose();
		display.dispose(); // Display �ν���Ʈ ���
	}
}
