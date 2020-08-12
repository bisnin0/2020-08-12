import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing extends JFrame implements ActionListener, ItemListener {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);//2020;
		int month = now.get(Calendar.MONTH)+1;//8;

		JButton leftBtn = new JButton("◀");
		JButton rightBtn = new JButton("▶");
		JLabel topLbl1 = new JLabel("년", 10);
		JLabel topLbl2 = new JLabel("월", 10);
		
		JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //년도 선택 콤보박스
			DefaultComboBoxModel<Integer> ydcb = new DefaultComboBoxModel<Integer>(); 
		JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //월 선택 콤보박스
			DefaultComboBoxModel<Integer> mdcb = new DefaultComboBoxModel<Integer>();
				
		Font fontSize = new Font("굴림체", Font.BOLD, 20);
		
		JPanel frmTop = new JPanel(); //좌우 버튼과 콤보박스 들어갈위치
		JPanel frmCenter = new JPanel(new BorderLayout()); //요일과 날짜 들어갈부분(센터)
			JPanel centerNorth = new JPanel(new GridLayout(1,3, 2, 2)); //요일부분
			JPanel centerLbl = new JPanel(new GridLayout(0, 7, 5, 5)); //날짜 출력

		String weekLbl[] = {"일","월","화","수","목","금","토"};
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
public CalendarSwing() {
		super("달력 만들기");

		//콤보박스에 년월 넣기
		for(int i=1900; i<=2100; i++) { //년 
			ydcb.addElement(i);
		}
		yearCombo.setModel(ydcb);
		yearCombo.setSelectedItem(year); //현재 년도
		
		for(int i=1; i<=12; i++) {//월 
			mdcb.addElement(i);
		}
		monthCombo.setModel(mdcb);
		monthCombo.setSelectedItem(month); //현재 월
		
		//년월 선택 콤보박스 위치
		leftBtn.setPreferredSize(new Dimension(47, 22));
		rightBtn.setPreferredSize(new Dimension(47, 22));
		frmTop.add(leftBtn);
		frmTop.add(yearCombo);
		frmTop.add(topLbl1);
		frmTop.add(monthCombo);
		frmTop.add(topLbl2);
		frmTop.add(rightBtn);
		
		frmTop.setOpaque(true);
		frmTop.setBackground(Color.cyan);
		add(BorderLayout.NORTH, frmTop); //콤보박스 패널 배치
		
		/////////////////요일 패널 구현
		centerNorth.setOpaque(true);
		centerNorth.setBackground(Color.WHITE);
		for(int i=0; i<7; i++) {
			JLabel lbl = new JLabel(weekLbl[i]);
			lbl.setFont(fontSize);
			lbl.setBackground(Color.lightGray);
			lbl.setHorizontalAlignment(JLabel.CENTER);
			lbl.setOpaque(true);
			if(i==0){ //토, 일 폰트 색 지정
				lbl.setForeground(Color.blue);
			}else if(i==6) {
				lbl.setForeground(Color.red);
			}
			centerNorth.add(lbl);
		}
		/////////////////날짜 패널 등록
		frmCenter.add(BorderLayout.NORTH, centerNorth);
		frmCenter.add(BorderLayout.CENTER, centerLbl);
		add(BorderLayout.CENTER, frmCenter);
		
		//이벤트 등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		calendar();
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
		centerLbl.removeAll();
//		centerLbl.revalidate(); //렉걸림
		centerLbl.repaint(); //렉없음
		if(event.equals("◀")) {
			year--;
			yearCombo.setSelectedItem(year);
//			calendar();
		}else if(event.equals("▶")) {
			year++;
			yearCombo.setSelectedItem(year);
		}
		
	}
	public void itemStateChanged(ItemEvent ie) {
		centerLbl.removeAll(); ////왜 적용 안되나?
		centerLbl.revalidate(); ///////////이거 중요.. 
//		centerLbl.repaint();
		year = (Integer)yearCombo.getSelectedItem(); 
		month = (Integer)monthCombo.getSelectedItem();
		calendar();
	}

	public void calendar() { 
		now.set(year,month-1,1); //이걸로 선택한 달과 월을 결정
		int sDayNum = now.get(Calendar.DAY_OF_WEEK); // 1일의 요일 
		int endDate = now.getActualMaximum(Calendar.DATE); //달의 마지막날 
		int Size = sDayNum+endDate-1;
		String arr[] = new String[Size]; 
		
		//////// 배열에 공백, 날짜 넣기
		int j=1;
	     for (int i=0; i<sDayNum-1;i++){ //공백
	            arr[i]=" ";  
	        }
	     for (int i = sDayNum-1; i < Size ; i++) {  // 공백 이후 1부터 마지막일까지.        
	      	arr[i]=String.valueOf(j);
	       	j++;
	     }
	     

	     int k = 0; 	//배열에서 공백 패스
        Calendar now2 = Calendar.getInstance(); //요일 구하기 용도   

        for(int i=0; i<arr.length; i++) {
	    	JLabel dayLbl = new JLabel(arr[i]);//라벨 생성
	    	dayLbl.setFont(fontSize);
	    	if(!arr[i].equals(" ")) { //버튼에 색넣기
	    		k++;
	    		now2.set(year,month-1,k); //공백 아니면 1일부터 시작
	    		int dayNum = now2.get(Calendar.DAY_OF_WEEK); //요일 
	    		if(dayNum==1){ //일
	    			dayLbl.setForeground(Color.BLUE);
	    		}else if(dayNum==7) { //토
	    			dayLbl.setForeground(Color.RED);
	    		}
	    	}
	    	dayLbl.setHorizontalAlignment(JLabel.CENTER);
	    	centerLbl.setOpaque(true);
	    	centerLbl.setBackground(Color.WHITE);
	    	centerLbl.add(dayLbl);
	    	
	    }
	}
	

	public static void main(String[] args) {
		new CalendarSwing();
	}

}
