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
		Display display = new Display(); // GUI 작업을 위한 Display 객체를 생성한다.

		Shell shell = new Shell(display); // 위젯의 부모역할. Shell 인스턴스 생성
		shell.setText("Hello SWT"); // Shell(윈도우프레임)의 제목 설정
		shell.setBounds(100, 100, 200, 80); // Shell의 크기 설정 (좌상단 100,100 위치에 가로
											// 200, 세로 80의 프레임 설정)
		shell.setLayout(new FillLayout()); // Shell의 레이아웃 관리자를 지정

		Label label = new Label(shell, SWT.CENTER); // Label위젯 생성
		label.setText("Hello SWT !");
		
		Color red = new Color(display, 255, 0, 0);
		label.setForeground(red); // 레이블의 색상지정
		shell.open(); // 위에서 구성한 윈도우가 화면에 표시됨

		while (!shell.isDisposed()) { // 윈도우 프레임이 닫혔는지 계속 확인
			if (!display.readAndDispatch()) { // 플랫폼의 이벤트 큐에서 이벤트를 읽어 적절한 이벤트
												// 리시버에 전달. 처리할 이벤트가 있으면 true,
												// 큐가 비어 있우에는 flase 반환
				display.sleep();
			}
		}
		red.dispose();
		display.dispose(); // Display 인스턴트 폐기
	}
}
