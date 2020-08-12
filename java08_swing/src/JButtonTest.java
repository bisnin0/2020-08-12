import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame {
	ImageIcon ii1 = new ImageIcon("img/k1.jpg"); /////이미지 넣기
	ImageIcon ii2 = new ImageIcon("img/k2.jpg");
	ImageIcon ii3 = new ImageIcon("img/k3.jpg");
	ImageIcon ii4 = new ImageIcon("img/k4.jpg");
	ImageIcon ii5 = new ImageIcon("img/k5.jpg");
	public JButtonTest() {
		super("JButton");
		setLayout(new GridLayout(0,3,10,10));
		
		JButton btn1 = new JButton("첫번째 버튼"); //문장만 넣기
		add(btn1); //Grid는 추가되는 순서대로 들어간다.
		
		//버튼 비활성화방법
		btn1.setEnabled(true); //true면 활성화 false면 비활성화
		
		
		
		JButton btn2 = new JButton(ii1);  //버튼에 이미지 넣기
		add(btn2);
		
		JButton btn3 = new JButton("세번째", ii2); //문장과 이미지가 함께있는 버튼 //이미지가 큰거라 텍스트가 가려서 안보임..창크기 키우면 오른쪽에 보인다.
		add(btn3);
		
		btn3.setRolloverIcon(ii3); //마우스가 올라가면 롤 오버다.. 이미지를 바꾸는 작업을 할거다.
								   //마우스 오버시 icon변경
		
		btn3.setPressedIcon(ii4);  //버튼을 누른상태일때 icon이 바뀐다.
		
		
		
		
		//RadioButton //체크박스(사각형에 체크하는것)과 달리 동그란 모양의 박스. 체크박스와 달리 하나를 선택하면 나머지를 선택할 수 없게된다.
					  //하나를 선택하면 나머지가 해제되는것. Ex)윈도우 설치시 여러개의 윈도우버전중 어떤걸 설치할거냐 선택하는 창을 만들때 사용되는것
		
		JPanel pane = new JPanel(new GridLayout(3,1));
		JRadioButton rb1 = new JRadioButton("ONE");
		JRadioButton rb2 = new JRadioButton("TWO");
		JRadioButton rb3 = new JRadioButton("THREE");
		//우선 이 버튼 3개를 하나로 묶어줘야한다. 그래야 하나를 선택하면 나머지가 해제된다.
		//이때 사용하는 클래스 ButtonGroup
		ButtonGroup bg = new ButtonGroup(); //라디오버튼 동작하기 위해서 그룹을 생성해야한다.
		bg.add(rb1); bg.add(rb2); bg.add(rb3);
		//3개가 한 셋트가 되었다.
		//이것을 패널에 담아야한다.
		pane.add(rb1); pane.add(rb2); pane.add(rb3);
		
		//패널을 프레임에 추가
		add(pane);
		
		
		//ToggleButton  //이 버튼은 클릭하면 들어가있다. 다시 누르면 나온다.
		JToggleButton tBtn = new JToggleButton(ii5);
		add(tBtn);
		tBtn.setSelectedIcon(ii1); // 버튼이 선택상태일때 아이콘... 버튼이 눌렸을때 ii1아이콘으로 하겠다
		
		//JLabel
		JLabel lbl1 = new JLabel("라벨", JLabel.CENTER);  //라벨은 버튼과 달리 클릭이 안되는거다.
		JLabel lbl2 = new JLabel("라벨", ii2, JLabel.RIGHT);  //LEFT, RIGHT, CENTER
		add(lbl1);
		add(lbl2);
		
		
/*
		//배경색
		lbl1.setBackground(Color.YELLOW);
		pane.setBackground(Color.GREEN); //이미지에 가려서 안보이지만 적용된거다. //왜냐면 라벨은 배경이 투명으로 적용되어있다.
		btn1.setBackground(Color.ORANGE); //버튼은 배경이 투명이 아니다.
*/
		
		//투명 처리 해제
		lbl1.setOpaque(true);
		pane.setOpaque(true);  //확인필요
		
		//배경색
		lbl1.setBackground(Color.YELLOW); // 적용 되었지만 라디오버튼에 가려서 보이지 않음 그래서 아래에 rb1(라디오버튼1)에 색 넣음
		pane.setBackground(Color.GREEN); //
		btn1.setBackground(Color.ORANGE); //
		
		rb1.setBackground(Color.RED); //라디오버튼1에 배경색을 넣었다. 위에 가려져서 안보이는것대신
		
		JPanel pane2 = new JPanel();
		add(pane2);
		pane2.setOpaque(true);
		pane2.setBackground(Color.cyan);
		
		
		//글자색
		Color clr = new Color(100,100,200); //빨강 초록 블루  r g b ->0~255
		lbl1.setForeground(clr); //라벨 1 색을 변경해라. clr객체 색으로
		
		//글꼴 -> 글꼴(돋움체, 굴림, arial...), 글자유형(진하게, 기울임꼴, 보통), 글자크기(정수:pixel)
		//이것을 처리해주는 클래스 = Font
		//Font 클래스
		Font fnt = new Font("궁서체", Font.BOLD+Font.ITALIC , 40); //윈도우에서 제공하는 폰트 (c:)->windows->Font.. 
		lbl1.setFont(fnt); //궁서체로 진하게+기울임 40포인트 크기로. // 글자유형을 2가지로 하고싶으면 +로 폰트를 더하면된다.
		

//		setSize(500,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		

		
		///////////////////////////JComboBox //버튼누르면 아래 목록 선택하는게 나오는것
		
		Vector<String> vec = new Vector<String>();
		vec.add("JAVA");
		vec.add("스트링");
		vec.add("HTML");
		vec.add("CSS");
		
		//먼저 vector에 값을 집어넣고 이걸로 JComboBox를 만든다
		JComboBox box1 = new JComboBox(vec);
		add(box1);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Red");
		model.addElement("Green");
		model.addElement("Blue");
		model.addElement("Yellow");
		
		// JComboBox에 들어갈 수있는 모델을 만든것
		
		JComboBox box2 = new JComboBox(model);
		add(box2);
		
		//JList
		DefaultListModel<String> model2 = new DefaultListModel<String>();
//		model2.add(index, element); 몇번째 index에서 값을 추가
//		model2.addElement(element); 가장 마지막 위치에 값을 추가
		for(int i=100; i<=1000; i+=100) {
			model2.addElement(String.valueOf(i));  //인트를 String으로 바꾸는법.. 이런걸 API가서 찾으면 된다. String 가서 검색해보자.
									//String.valueOf(data)
		}
		JList<String> list = new JList<String>(model2); 
		JScrollPane sp = new JScrollPane(list); //API에서 찾은 스크롤pane... 스크롤바 기능이다.
		add(sp);
		
		
		
		//TextField: 1줄의 문자열을 입력
		JTextField tf = new JTextField();
		add(tf);
		
		
		//JTextArea : 여러줄의 문자열입력
		JTextArea ta = new JTextArea();
		//이렇게만하면 그냥 한정된 박스 안에 글만쓸수있다.
		JScrollPane sp2 = new JScrollPane(ta); //이걸 추가하면 스크롤 기능이 생겨서 스크롤 내리면서 내용 추가 가능하다.
		add(sp2);
		
		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JButtonTest();
	}

}
