package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//////////WindowEventHandler2가 외부클래스로 이벤트처리
public class WindowEventTest2 extends JFrame{ //Frame을 상속받으면 Adapter를 상속받을 수 없다. 클래스니까. 클래스는 1개만 상속 가능하다.

	public WindowEventTest2() {
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//외부클래스에서 가져오기
		addWindowListener(new WindowEventHandler2(this));//이벤트가 생기면 WindowEventHandler2에서 오버라이딩 된 이벤트를 찾아 실행하라
											//WindowEventHandler2에 이벤트를 this 로 보냈다.
											//this = 현재클래스.. 여기서 this는 WindowEventTest2라는 이야기다.
		//아래 있는 내부클래스에서 처리하기. 이걸 활성화하고 위에껄 주석처리하면된다.
//		addWindowListener(new WindowEventInner());
		
	}

	public static void main(String[] args) {
		new WindowEventTest2();
	}
	
	
	///////////////////////여기까지 외부클래스로 이벤트 처리 했음
	//내부 클래스로 이벤트처리
	class WindowEventInner extends WindowAdapter{
		public void windowClosing(WindowEvent we) {
			System.out.println("프로그램이 종료되었습니다.");
			dispose(); //외부클래스랑 다르게 이 안에있는걸 쓰는거라 앞에 객체명안붙음
			System.exit(0);
		}
	}
}
