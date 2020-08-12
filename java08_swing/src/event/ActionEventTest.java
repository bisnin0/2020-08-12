package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionEventTest extends JFrame implements ActionListener{
											//버튼클릭 이벤트 위래 인터페이스 상속
	JPanel pane = new JPanel();
		JTextField tf = new JTextField(10); //10글자 들어가는 사이즈라지만 실제로는 더 들어가는 사이즈
		JButton btn1 = new JButton("구구단");
		JButton btn2 = new JButton("구구단(전체)");
	
	JTextArea ta = new JTextArea("a\nb\nc\n"); //inserText 기능 확인을 위해 텍스트 추가함
	JScrollPane sp = new JScrollPane(ta); //ta에 스크롤기능 
	
	//객체를 맴버에서 만드는 이유
	//화면이 뜨고나면 그 다음에 사용자가 뭔가 눌러서 작업한다.
	//그때 이것들이 사용이 되어야 한다. 
	//그런데 이것들을 지역변수에 만들어놓으면
	//메소드가 실행되고 끝나면 내부 변수들은 전부 사라지기때문에
	//맴버변수로 만들어놔야 메소드가 끝나도 변수가 사라지지 않는다.
	
	public ActionEventTest() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		//    ""NORTH"
		add(BorderLayout.NORTH, pane); //북쪽에  버튼과 텍스트필드를 놓는다.
		add(BorderLayout.CENTER, sp); //스크롤 추가?
		
		
		///////버튼을 클릭할때 동작하는것을 이벤트 처리라고 한다.
		
		////addChangeListener
		
		////addActionListener(버튼은 액션이벤트가생긴다. 마우스를 클릭했다 놓으면 액션이벤트)
		// 1. 해당이벤트의 interface상속
		// 2. 추상메소드 오버라이딩
		// 3. 컴퍼넌트를 이벤트 등록 (addActionListener)
		
		//1.interface상속 (위에 implements로 했음)
		//2.추상메소드 오버라이딩
		//3.컴퍼넌트 이벤트 등록
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		//3. 컴퍼넌트 이벤트 등록
		btn1.addActionListener(this); //버튼1이 이벤트가 생기면 아래 메소드를 호출해서 실행하는것.
							//this를 넣으면 현재 클래스에서 메소드를 찾아서 실행해라.가 된다.
		btn2.addActionListener(this);
		
		
		//////////////
		tf.addActionListener(this); //이렇게 하면 textField에서 엔터를 치면 아래 actionperformed로 들어간다.
		
		
		
		
		
		
		
		
		
	}
	
	
	//2. 추상메소드 오버라이딩  //API에서 ActionListener 인터페이스 찾아서 내부 메소드 반환형등 확인
	public void actionPerformed(ActionEvent ae) { //JButton, JTextField  어떻게 두가지이벤트를 구분하는지 알아두기.
		//엔터쳐서 들어오면 아무것도 실행 안된다. 이유는 ActionEventTest2 클래스에 정리되어 있다.
//		System.out.println(event);
		
		
//		System.out.println("이벤트 발생됨...");  //버튼을 누르면 콘솔에 내용이 출력된다.
		///////////버튼을 클릭하는순간 이벤트는 무조건 발생한다.
		//이벤트가 생기면 이 버튼을 액션이벤트변수(ae)에 넣어주고 메소드 안에 있는게 실행된다.
		
		//이벤트가 발생한 컴퍼넌트를 알아내는 방법
		String event = ae.getActionCommand(); //객체명.getActionCommand(); 객체명 다음에 오는건 이벤트 타입에 따라 다르다.
		//여기서 getActionCommand();하면 맴버변수에 선언된 btn1의 라벨을 구한다."구구단(5단)".. 원래 5단 있었지만 중간에 그냥 구구단으로 수정함
//		System.out.println(event);
		
		//이벤트에 뭐가들어있는지 if문으로 확인한다.
		if(event.equals("구구단")) {
			String gugudan = "";
			int dan = Integer.parseInt(tf.getText()); //컴퍼넌트에 있는 문자열을 읽어와서 정수로 바꾼다.
			for(int i=2; i<=9; i++) {
				gugudan+=dan + " *" + i + " = " + dan*i+"\n"; //줄바꿈 제어문자로 해야 다음줄로 넘어간다. 프린트라인은 콘솔에출력하는것
				
			}
			//기존에 있는 내용을 놔두고 추가로 출력할건가, 기존의 내용 지우고 새로 출력할건가
			//append() : 끝에 추가하는것
			//setTest() : 기존 내용을 지우고 새로 추가
			//insert() : 중간에(원하는 위치에) 추가 insertText?
//			ta.append(gugudan);
//			ta.insert(gugudan,1); //1행 바로 다음에 입력됨
			ta.setText(gugudan);
		}else if(event.equals("구구단(전체)")) {
			String gugudan="";
			for(int dan=2; dan<=9; dan++) {
				for(int i=2; i<=9; i++) {
					gugudan += dan+ " * " + i + "=" + dan*i + "\n";
				}
			}
			ta.setText(gugudan);
		}
		
		
		
	}
	

	public static void main(String[] args) {
		new ActionEventTest();
		
	}

}
