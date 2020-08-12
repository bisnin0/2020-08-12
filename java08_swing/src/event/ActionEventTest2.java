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

public class ActionEventTest2 extends JFrame implements ActionListener{
											//버튼클릭 이벤트 위래 인터페이스 상속
	JPanel pane = new JPanel();
		JTextField tf = new JTextField(10); //10글자 들어가는 사이즈라지만 실제로는 더 들어가는 사이즈
		JButton btn1 = new JButton("구구단");
		JButton btn2 = new JButton("구구단(전체)");
	
	JTextArea ta = new JTextArea("a\nb\nc\n"); //inserText 기능 확인을 위해 텍스트 추가함
	JScrollPane sp = new JScrollPane(ta); //ta에 스크롤기능 
	
	public ActionEventTest2() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		//    ""NORTH"
		add(BorderLayout.NORTH, pane); //북쪽에  버튼과 텍스트필드를 놓는다.
		add(BorderLayout.CENTER, sp); //스크롤 추가?
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		btn1.addActionListener(this); //버튼1이 이벤트가 생기면 아래 메소드를 호출해서 실행하는것.
		btn2.addActionListener(this);
		tf.addActionListener(this); //이렇게 하면 textField에서 엔터를 치면 아래 actionperformed로 들어간다.
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) { //JButton, JTextField  어떻게 두가지이벤트를 구분하는지 알아두기.
											//JButton으로 생성된 이벤트인지 JTextField인지는 ae에 담겨 온다.
		//이벤트가 발생한 컴퍼넌트 알아내기
		Object obj = ae.getSource();//이벤트가 발생한 객체를 얻어온다. 오브젝은 상위클래스라 어떤값이든 넣을 수 있다.
									//객체 자체를 구한다.
		//어떤 클래스로 생성된 객체인지 확인한다.
		if(obj instanceof JButton) { //이 연산자 기억해두기. 비교연산자. 객체를 만든 클래스가 뭔지 알아낼 수 있는것.. obj가 JButton으로 생성된 객체가 맞는지 확인
		  //왼쪽은 객체           오른쪽은 클래스
			JButton btn = (JButton)obj; //상위클래스를 하위클래스로 형변환.
			if(btn.getText().equals("구구단")) {
				//구구단(한 단)
				oneDan();
			}else if(btn.getText().equals("구구단(전체)")) {
				//구구단 전체
				allDan();
			}
		}else if(obj instanceof JTextField) {//JTextField에서 이벤트가 생기면..
			//구구단(한 단)
			oneDan();
		}
		
	}
	
	public void allDan() {
		ta.setText("");
		for(int dan =  2; dan<=9; dan++) {
			for(int i=2; i<=9; i++) {
				ta.append(dan+"*"+i+"="+dan*i+"\n");
			}
		}
	}
	public void oneDan() {
		ta.setText("");
		int dan = Integer.parseInt(tf.getText());
		for(int i=2; i<=9; i++) {
			ta.append(dan + "*" + i +"="+ dan*i+"\n"); //append가 뭐였더라
		}
	}
	

	public static void main(String[] args) {
		new ActionEventTest2();
		
	}

}
