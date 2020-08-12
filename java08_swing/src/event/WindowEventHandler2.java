package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class WindowEventHandler2 extends WindowAdapter {

	WindowEventTest2 w; //값을 없어지게하지 않기위해 선언하는 멤버변수
	
	public WindowEventHandler2() {	}
	
	public WindowEventHandler2(WindowEventTest2 w) {
		//저쪽에서 this로 보냈다. 받는 데이터 타입은? 
		//저기 this는 WindowEventTest2다. JFrame으로 받아도 된다.(JFrame이 상위클래스고 상속받고있으니까)
		//여기서 실행이 끝나면 지역변수는 사라지니까 이 값을 멤버변수로 넘겨준다.
		
		this.w = w; //지역변수 w를 멤버변수로 넘겨준다.
	}
	
	
	//재오버라이딩
	public void windowClosing(WindowEvent we) {
		int status = JOptionPane.showConfirmDialog(w, "종료할까요?"); //멤버변수w를 가져온다.
		if(status==JOptionPane.OK_OPTION) {
			w.dispose();
			System.exit(0);
		}
		
		
	}

}
