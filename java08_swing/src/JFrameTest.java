import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame {
	JButton btn1 = new JButton("11111");
	JButton btn2 = new JButton("22222");
	JButton btn3 = new JButton("33333");
	JButton btn4 = new JButton("44444");
	JButton btn5 = new JButton("55555");
	
	JPanel pane = new JPanel();
		JButton btn6 = new JButton("66666");
		JButton btn7 = new JButton("77777");
		JButton btn8 = new JButton("88888");
	public JFrameTest() {
/*
		setSize(500,500);
		setVisible(true);
		
		//이대로 창을 열면 X버튼으로 닫을수는 있지만 작업관리자에 세부정보 보면 javaw.exe가 남아있다. 계속 창을 열면 계속 추가된다. 이걸 방지해야함
		//컨테이너가 종료되면 자원해제한다.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //(operation) 치고 마우스 대고 아래로 내리다보면 change to~하면서 뜨는데 그중에서 하고싶은거 선택
								//창이 닫힐때 자원도 해제해라.
*/		
//------------------------------------------------------------
/*		
		//각 컨테이너마다 기본 레이아웃이 있다.
		//JFrame, JDailog : BorderLayout
		//JPanel : FlowLayout
		//GridLayout, CardLayout, GridbagLayout

		//BorderLayout: 동,서,남,북,가운데 이렇게 5구역으로 나누어져있다.
		//FlowLayout: 추가하는 컴포넌트 순서대로 배치
		//GridLayout: 바둑판식으로 가로세로 행열 크기가 같다.
		add(btn1); //버튼 추가
		add(BorderLayout.NORTH,btn2); //add("North", btn2); 필드변수인것과(소문자) FINAL변수인것(대문자) 구분하기. 
		add("West", btn3);   //BorderLayout이 import되어있으니 가능한건가?  //첫문자 대문자 안쓰니까 안열린다.
		add(BorderLayout.EAST, btn4);
		add("South", btn5);  
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		
*/		
//-------------------------------------------------------------
/*		
		//FlowLayout : 추가하는 컴포넌트 순으로 배치하는데 들어갈 자리(픽셀)가 있으면 옆으로 들어가고 없으면 자리있는곳으로 내려가 들어감
		//JPanel J패널 임포트함 
		add(btn1); 
		add(BorderLayout.NORTH,btn2);  
		add("West", btn3);   
		
		pane.add(btn6); //패널 버튼 추가
		pane.add(btn7);
		pane.add(btn8);
		
		add(BorderLayout.EAST, pane); //패널 버튼 들어갈 위치 지정
		
		
		add("South", btn5);  
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
*/
//--------------------------------------------------------------
		//패널을 GridLayout으로 변경하기.
		//JPanel J패널 임포트함 
		add(btn1); 
		add(BorderLayout.NORTH,btn2);  
		add("West", btn3);   
		
		//FlowLayout을 GridLayout으로 변경하기(바둑판식)
		pane.setLayout(new GridLayout(2,0, 10,5)); //(행 수,열 수) (3,1)= 3행1열.. 안넣으면 1행에 다들어감 
							//(행,열,버튼 좌우간격, 버튼위아래간격)
							//행에 0을 넣으면 행 수는 유동적이라는것이다.
		pane.add(btn6); //패널 버튼 추가
		pane.add(btn7);
		pane.add(btn8);
		pane.add(new JButton("AAAA"));
		pane.add(new JButton("BBBB")); //(0,2, 10,5)위에서 행을 0으로 해놨기때문에 행은 유동적이고 열은 2개씩이다.
									   // 반대로 (2, 0, 10,5)도 가능하다. 행은 2개행으로 고정이고 열이 유동적이다.
		
		
		
		add(BorderLayout.EAST, pane); //패널 버튼 들어갈 위치 지정
		
		
		add("South", btn5);  
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 		
		
	}

	public static void main(String[] args) {
		new JFrameTest();
	}

}
