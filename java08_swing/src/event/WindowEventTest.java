package event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



//Adapter클래스 = 추상메소드가 2개 이상인것들은 오버라이딩 하기 쉽게 하려고 만들어논 클래스가 있다. ex)WindowAdapter
// WindowAdapterHandler클래스에서 확인
public class WindowEventTest extends JFrame implements WindowListener{
	JTextArea ta =new JTextArea();
	
	public WindowEventTest() {
		add(ta);
		
		
		setSize(500,500);
		setVisible(true);
	
		
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //윈도우창 X눌러도 종료되지않게 만들기
		//이벤트 등록
		addWindowListener(this); //
		
		
	}
	
	public void windowActivated(WindowEvent we) {
		System.out.println("Activated");
	}
	
	public void windowClosed(WindowEvent we) {
		System.out.println("Closed");
	}
	public void windowClosing(WindowEvent we) {
		int status = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?"); //창 닫을때 물어보는 창 띄우기
		if(status == JOptionPane.OK_OPTION) { //OK_OPTION말고 NO_OPTION이나 CANCEL_OPTION이 있다.
			dispose();
			System.exit(0); 
		}//윈도우 이벤트 처리하는 방식
	}
	
	public void windowDeactivated(WindowEvent we) {
		System.out.println("Deactivated");
	}
	
	public void windowDeiconified(WindowEvent we) {
		System.out.println("Deiconified");
	}
	
	public void windowIconified(WindowEvent we) {
		System.out.println("Iconified");
	}
	
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened");
	}
	
			

	public static void main(String[] args) {
		new WindowEventTest();
	}

}
