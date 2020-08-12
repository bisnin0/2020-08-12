import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//public class CalculatorSwing extends JFrame implements ActionListener {
										//다른 클래스에서 이벤트 처리를 할때는 여기서 인터페이스 상속받을 필요가없다.
	public class CalculatorSwing extends JFrame {
	Font fnt = new Font("Arial", Font.PLAIN, 30);
	JTextField tf = new JTextField("0.0");
	
	
	//Button의 라벨로 쓰여지는 텍스트를 배열로 만들기
	String btnLbl[] = {"BackSpace", "Clear", "End", 
						"7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", ".", "=", "/"};
	
	//centerbtn은 frmcenter의 센터에, centernorth를 frmcenter의 북쪽에. frmcenter를 JFrame창 중앙에 넣는다. 
	JPanel frmCenter = new JPanel(new BorderLayout()); //위에 버튼 들어갈 전체패널 프레임
		JPanel centerNorth = new JPanel(new GridLayout(1,3));//백스페이스, 클리어, 엔드 들어갈 패널
		JPanel centerBtn = new JPanel(new GridLayout(4,4,5,5)); //숫자, 연산자 들어갈 자리
		
	CalculatorEvent event = new CalculatorEvent(tf); //버튼 18개가 동작할때마다 이벤트 만들어지게 할게 아니라 그냥 이거 하나로 해결하자.
											//여기의 tf와 CalculatorEvent의 tf가 같아야 하니까 CalculatorEvent에 생성자 메소드를 통해 같은값을 가지도록 만들어줌
	
	public CalculatorSwing() {
		super("계산기");
		tf.setFont(fnt);
		tf.setHorizontalAlignment(JTextField.RIGHT); //오른쪽으로 "0.0" 이동
		add("North", tf);
		
		//버튼을
		add("Center", frmCenter); //프레임에 frmCenter를 중앙에 추가한다.
			frmCenter.add("North", centerNorth); //centerNorth를 frmCenter 북쪽에 추가한ㄷ,
			frmCenter.add("Center" ,centerBtn); // centerBtn을 frmCenter 중앙에 추가한ㄷ,
			
			//버튼 추가
			for(int i=0; i<btnLbl.length; i++) {//0,1,2,3,4,...... 18
				JButton btn = new JButton(btnLbl[i]);//버튼 생성
				btn.setFont(fnt);//글자 크기 설정
				btn.setBackground(Color.lightGray); //배경색칠하기
				
//				btn.addActionListener(this);//버튼 이벤트 등록 .. 이게 this이기때문에 아래 actionPerForme로 가는것. 
											//다른 클래스에도 만들 수 있다. 만들어보기로함.
				
				btn.addActionListener(event); //위에 객체 만들어놈이렇게 CaculatorEvent 클래스를 만든걸 가져올수도있다.
				//버튼을 JPanel에 추가
				if(i<=2) { //index가 0~2까지면 센터 노스에 버튼 추가해라
					centerNorth.add(btn);
				}else {
					centerBtn.add(btn);//3이상이면 센터버튼에 추가해라.
				}
				
			}
	
				
		
		
		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
//	public void actionPerformed(ActionEvent ae) { //API가면 뭐를 오버라이딩 해야 하는지 나온다.
//		다른 클래스에서 만들었다.
//	}

	public static void main(String[] args) {
		new CalculatorSwing();
	}

}
//계산기 풀이
//숫자 출력칸에 Jtextfield나 Jlabel을 넣으면 된다. Jlabel은 값이 없으면 칸이 없어지기때문에 값을 넣어줘야한다.
//Jtextfield
//백스페이스, 클리어, 엔드
//7 8 9 +
//4 5 6 -
//1 2 3 *
//0 . = /

//프레임 제일 위에 텍스트필드
//보더레이아웃 북쪽은 백스페이스 클리어 엔드
//보더레이아웃 센터에는 그리드레이아웃으로 숫자창 넣기.
//창을 보더레이아웃 프레임에 집어넣으면 된다.