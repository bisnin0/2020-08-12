package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


//////////익명의 내부 클래스를 이용한 이벤트 처리 방법
//////////익명의 내부 클래스는 재사용하기 힘들다. 여기서만 사용 가능함

//////////완전히 다른 클래스에서 이벤트 처리 하는 방법은 WindowEventTest2로 
public class WindowAdapterHandler extends JFrame{
	JFrame frm;
	public WindowAdapterHandler() {
		frm = this;
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//추상메소드가 오버라이딩 되어있는 Adapter클래스를 재오버라이딩한다.
		//익명의 내부 클래스
		addWindowListener(new WindowAdapter() { //Adapter는 객체생성이 가능하다.
			public void windowClosing(WindowEvent we) {
				int status = JOptionPane.showConfirmDialog(frm,"정말 종료하시겠습니까?"); //여기선 rhis가 안된다. 프레임 객체로 만들어서 해야한다.
													//내부클래스에서 외부클래스에있는 멤버변수는 쓸 수 있기때문에 멤버변수에서 frm객체 만들어서 놓은것.
				if(status==JOptionPane.OK_OPTION){
					dispose(); //자원 해제시키기
					System.exit(0);
				}
			}
		}); //이게 정상
		
	}

	public static void main(String[] args) {
		new WindowAdapterHandler();
	}

}
