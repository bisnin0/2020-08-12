import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest2 {
	JFrame frm = new JFrame("창의 제목"); //기본 레이아웃 = BoderLayout (동,서,남,북,중앙)
	
	
	public JFrameTest2() {
		//레이아웃 없이 좌표를 이용해서 컴퍼넌트 배치하기

		//기본레이아웃(BoderLayout) 지우기
		frm.setLayout(null);
		
		JButton btn = new JButton("좌표로 레이아웃 설정");
		//버튼 크기 지정
		btn.setSize(200, 50);
		//버튼 어디에 표시할지 xy 좌표지정
		btn.setLocation(50, 100);
		
		frm.add(btn); //프레임에 버튼을 추가해라
		
		////////이것의단점은 창의 크기가 커져도 레이아웃이 고정사이즈로 뜨는것이다. 창의 크기를 고정해버리면 문제가 되지 않는다.
		frm.setResizable(false);  //창크기 조절 불가. 창의 크기 못바꾸게 만들기. true들어가면 크기변경 가능하다.
		
		///////자유롭게 창크기를 조절하려면 이거 말고 다른거 쓰는게 좋다고한다.
		
		
		frm.setSize(500,500);
		frm.setVisible(true);
		
	}

	public static void main(String[] args) {
		new JFrameTest2();
	}

}
