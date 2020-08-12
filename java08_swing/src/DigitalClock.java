import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame {
	
//////////왜 맴버변수에 설정되었는지 숙지하기.
//////////아래 setTime메소드에서 변경된 값이 계속해서 여기에 들어오고 이 데이터가 digitalclock메소드에서 사용되니까
	//////메소드를 나눠서 실행되는 메소드의 값을 실시간으로 계속해서 변경시켜줄 수 있다.
	
	JLabel lbl = new JLabel("11:50:10");
	Font ftn = new Font("Arial", Font.BOLD, 50);
	
	
	
	public DigitalClock() {
		super("Clock");
		//setTitle("Clock");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("img/k2.jpg");
		setIconImage(icon);  //아이콘이 셋팅
	
		
		
		//JLabel 문자열 가운데 정렬.. 
		lbl.setHorizontalAlignment(JLabel.CENTER);  //위치를 따로 안잡으면 센터로 들어간다. 
		lbl.setFont(ftn);
		add(lbl);
		
		pack();//컨텐츠 내용 만큼 창의 크기가 정해진다. // setSize(400, 200); // setBounds(x,y,w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setTime(); //아래 시간 갱신 가져오기
	}
	//시간 갱신 설정
	public void setTime() {
		do {
			//현재 시간 구하기
			Calendar now = Calendar.getInstance();
			
			//문자열 구하기
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String clock = sdf.format(now.getTime()); //Calendar를 Date로 리턴해주는게 getTime이다.
			
			
			//라벨에 셋팅
			//디스플레이 되어있는 글자를 변경시켜주는 작업 setText
			lbl.setText(clock); //swing API에 있음
			
			//일시정지
			try { //Thread는 무조건 예외처리를 해야함.
			Thread.sleep(500);
			}catch(Exception e) {}
			
			
			
			
		}while(true);
	}
	
	

	public static void main(String[] args) {
		new DigitalClock();
	}

}
