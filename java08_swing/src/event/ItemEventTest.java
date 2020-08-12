package event;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


public class ItemEventTest extends JFrame implements ActionListener, ItemListener{ //추상클래스 추가 
	JTextArea ta = new JTextArea("10일 기상청에 따르면 장마가 가장 늦게 끝난 해는 1987년 8월 10일이었다.\n 올해 장마는 중부지방 기준으로 지난 6월 24일 시작해 이날까지 이어지면서 \n33년 만에 장마가 가장 늦게까지 이어진 해 '공동 1위'에 올랐다.");
	JScrollPane sp = new JScrollPane(ta);
	
	JToolBar tb = new JToolBar();
		JComboBox<String> fontCombo = new JComboBox<String>();
			DefaultComboBoxModel<String> modelFont = new DefaultComboBoxModel<String>();
										//현재 컴퓨터에 있는 글꼴 정보를 읽어서.. (윈도우에있는 글꼴)
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> modelSize = new DefaultComboBoxModel<Integer>();
		JToggleButton plainBtn = new JToggleButton("가"); //한번 누르면 들어가있고 다시 누르면 나오는것
		JToggleButton boldBtn = new JToggleButton("가");
		JToggleButton italicBtn = new JToggleButton("가");
		
	
	Font fnt = new Font("돋움", Font.PLAIN, 10);
	String selectFontName = "바탕체"; //기본글꼴 저장을 위한 변수
	Integer selectFontSize = 13; //글꼴 크기 저장을 위한 변수.. 13은 Int이지만 Integer로 오토박싱된다. 
//	int fontStyle=0; //0이면 보통이고 1이면 진하게, 2면 기울임꼴, 3이면 진하게+기울임꼴이다.
	//다른방법으로 하면
	int styleBold=0; //진하게 저장할 변수
	int styleItalic=0; //이탤릭 기울임꼴 저장할 변수
	
	public ItemEventTest() {
		//텍스트박스를 프레임의 센터에 넣는 작업
		add(sp);
		//윈도우의 글꼴을 구해주는 클래스.. 시스템의 글꼴 얻어오기    //API에서 abstract 붙은건 = 추상메소드
		String fontList[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
		for(String f : fontList) { //왼쪽 데이터타입 변수 오른쪽 배열명
			modelFont.addElement(f);
		}
		fontCombo.setModel(modelFont); //여기까지 글꼴을 만든것
		fontCombo.setSelectedItem("바탕체"); //기본으로 이 폰트를 쓰겠다.
		

		//글자크기조절
		for(int i=7; i<100; i+=3) {
			modelSize.addElement(i);
			
		}
		fontSize.setModel(modelSize);
		fontSize.setSelectedItem(13); //기본으로 이 크기를 하겠다.
		
		//글자 유형
		plainBtn.setFont(fnt);
		boldBtn.setFont(new Font("돋움", Font.BOLD, 10));
		italicBtn.setFont(new Font("돋움", Font.ITALIC, 10));
		
		tb.add(fontCombo); //글꼴
		tb.add(fontSize); //글자크기
		tb.add(plainBtn); tb.add(boldBtn); tb.add(italicBtn); //글자 유형
		
		add("North", tb); //툴바 추가
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		plainBtn.addActionListener(this); //현재 클래스에서 할거면 this
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		
		//추상클래스 등록 하고 
		fontCombo.addItemListener(this);
		fontSize.addItemListener(this);
		
		
		////////이 툴바는 창 실행하고 왼쪽에 점찍힌거 클릭해서 드래그하면 옴겨지기도한다.
		
		JButton btn = new JButton ("eeeeeeeeeeeeeeeeee");
		add("South", btn);
		
	}
	public void actionPerformed(ActionEvent ae) {
		//버튼 누르면 실행되게 해야하는데 버튼 내용이 다 같다. 그렇기때문에 객체명으로 버튼이 인식되게 해야한다.
		//버튼 눌렀을때 글꼴 보통 진하게기울임 적용되게 등록
		JToggleButton event = (JToggleButton)ae.getSource(); 
		if(event.equals(plainBtn)) { //방금 이벤트가 생긴 버튼과 화면에 있는 플레인 버튼하고 같으면 
			if(plainBtn.isSelected()) {
				styleBold = 0;
				styleItalic = 0;
			}
		}else if(event.equals(boldBtn)) {
			if(boldBtn.isSelected()) {
				styleBold = Font.BOLD; //1 써도 되는데 폰트에 있는 볼드가 가지고 있는 변수로 쓰는게 더 정확
				
			}else {
				styleBold = 0;
			}
		}else if(event.equals(italicBtn)) {
			if(italicBtn.isSelected()) {
				styleItalic = Font.ITALIC; //2로 써도 되는데 위와 마찬가지
			}else {
				styleItalic = 0;
			}
		}
		fnt = new Font(selectFontName, styleBold+styleItalic, selectFontSize);
		ta.setFont(fnt);
		
	}
	//ItemEvent 추상메소드 오버라이딩
	public void itemStateChanged(ItemEvent ie) {
		JComboBox event = (JComboBox)ie.getSource();
		if(event==fontCombo) {
			selectFontName = (String)fontCombo.getSelectedItem();
			
		}else if(event == fontSize) {
			selectFontSize = (Integer)fontSize.getSelectedItem();
		}
		fnt = new Font(selectFontName, styleBold+styleItalic, selectFontSize);
		ta.setFont(fnt);
	}

	public static void main(String[] args) {
		new ItemEventTest();
	}

}
