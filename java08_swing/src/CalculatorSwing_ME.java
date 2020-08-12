import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorSwing_ME extends JFrame implements ActionListener {
	
	JPanel pane = new JPanel();
	JLabel lbl = new JLabel("0.0", JLabel.RIGHT);
	JLabel lbl2 = new JLabel("", JLabel.RIGHT);
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		JButton btn10 = new JButton("0");
		JButton btn11 = new JButton("BackSpace");
		JButton btn12 = new JButton("Clear");
		JButton btn13 = new JButton("End");
		JButton btn14 = new JButton("+");
		JButton btn15 = new JButton("-");
		JButton btn16 = new JButton("*");
		JButton btn17 = new JButton("/");
		JButton btn18 = new JButton(".");
		JButton btn19 = new JButton("=");
	Font ftn1 = new Font("굴림체", Font.BOLD, 25);
	double result = 0;
	double result2 = 0;
	double result3 = 0;
	double result4 = 0;
	int count=0;
	
	int back = 0;
	
	int aa=0;
	int ab=0;
	int ac=0;
	int ad=0;
	
	public CalculatorSwing_ME() {

		setBackground(Color.GRAY);
		lbl.setBackground(Color.WHITE);
		lbl.setOpaque(true);
		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(4,4,2,2));
		
		pane2.add(btn7); pane2.add(btn8); pane2.add(btn9); pane2.add(btn14);
		pane2.add(btn4); pane2.add(btn5); pane2.add(btn6); pane2.add(btn15);
		pane2.add(btn1); pane2.add(btn2); pane2.add(btn3); pane2.add(btn16);
		pane2.add(btn10); pane2.add(btn18); pane2.add(btn19); pane2.add(btn17);
		
		JPanel pane3 = new JPanel();
		pane3.setLayout(new GridLayout(1,3,2,2));
		pane3.add(btn11); pane3.add(btn12); pane3.add(btn13);
		
		pane.setLayout(new BorderLayout());
		pane.add(pane3, BorderLayout.NORTH);
		pane.add(pane2, BorderLayout.SOUTH);
		
		getContentPane().add(lbl, BorderLayout.NORTH);
		getContentPane().add(pane, BorderLayout.SOUTH);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);
		btn17.addActionListener(this);
		btn18.addActionListener(this);
		btn19.addActionListener(this);
		
		
		
		setTitle("계산기");
//		setSize(300,210);
		pack();
		setVisible(true);
		setResizable(false);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {

		
		String event = ae.getActionCommand();
		if(event.equals("1")) {
			addNumber(1);
			addNumber2(1);
		}else if(event.equals("2")) {
			addNumber(2);
			addNumber2(2);
		}else if(event.equals("3")) {
			addNumber(3);
			addNumber2(3);
		}else if(event.equals("4")) {
			addNumber(4);
			addNumber2(4);
		}else if(event.equals("5")) {
			addNumber(5);
			addNumber2(5);
		}else if(event.equals("6")) {
			addNumber(6);
			addNumber2(6);
		}else if(event.equals("7")) {
			addNumber(7);
			addNumber2(7);
		}else if(event.equals("8")) {
			addNumber(8);
			addNumber2(8);
		}else if(event.equals("9")) {
			addNumber(9);
			addNumber2(9);
		}else if(event.equals("0")) {
			addNumber(0);
			addNumber2(0);
		}else if(event.equals("+")) {
			aa=1;
			ab=0;
			ac=0;
			ad=0;
			addSymbol("+");
		}else if(event.equals("-")) {
			aa=0;
			ab=1;
			ac=0;
			ad=0;
			addSymbol("-");
		}else if(event.equals("*")) {
			aa=0;
			ab=0;
			ac=0;
			ad=1;
			addSymbol("*");
		}else if(event.equals("/")) {
			aa=0;
			ab=0;
			ac=1;
			ad=0;
			addSymbol("/");
		}else if(event.equals(".")) {
//			addNumber(0.0);
//			addNumber2(0.0);
			addSymbol(".");
		}else if(event.equals("=")) {
			equal();
			String z = String.valueOf(result);
			aa=0;
			ab=0;
			ac=0;
			ad=0;
			lbl.setText(z); 
			back=1;
	
		}else if(event.equals("BackSpace")) {
			if(back!=1) {
				backSpace();
			}
			
			
			
		}else if(event.equals("Clear")) {
			count=0;
			lbl.setText("0.0");
			lbl2.setText("0");
			result=0;
			result4=0;
			result2=0;
			result3=0;
			aa=0;
			ab=0;
			ac=0;
			ad=0;
			back=0;
		}else if(event.equals("End")) {
			System.exit(0);
			setVisible(false);
		}
		
		
	}
	
	
	public void setLabel(String msg) {
		lbl.setText(msg);
	}
	
	public void setLabel2(String msg) {
		lbl2.setText(msg);
	}
	
	public void addNumber(int a) {
		if(back!=1) {
			String b = lbl.getText();
			if("0.0".equals(b)) {
				lbl.setText("");
			}
			String number = getNumber();
			setLabel(number + a);
		}
	}
	public void addNumber2(int a) {
		if(back!=1) {
			String b = lbl2.getText();
			if("0.0".equals(b)) {
				lbl2.setText("");
			}
			String number = getNumber2();
			setLabel2(number + a);
		}
	}
	
	public void addSymbol(String c) {
		count++;
		back=0;
		if(c.equals(".")) {
			String number = lbl2.getText();
			setLabel2(number + ".");
		}

		String number = getNumber();
		setLabel(number + c);
		try {
		String input2 = lbl2.getText();

		
		if(c.equals("+")) {

			if(count==1) {
				result = Double.parseDouble(input2);
			}else {
				result4 = Double.parseDouble(input2);
			}

			result = result + result4;

			lbl2.setText("");
		}else if(c.equals("-")) {
			if(count==1) {
				result = Double.parseDouble(input2);
			}else {
				result4 = Double.parseDouble(input2);
			}
			result = result - result4;
			lbl2.setText("");
		}else if(c.equals("/")) {
			if(count==1) {
				result = Double.parseDouble(input2);
			}else {
				result4 = Double.parseDouble(input2);
			}
			if(result4==0) {
				
			}else {
			result = result / result4;
			}
			lbl2.setText("");
		}else if(c.equals("*")) {
			if(count==1) {
				result = Double.parseDouble(input2);
			}else {
				result4 = Double.parseDouble(input2);
			}
			if(result4==0) {
				
			}else {
			result = result * result4;
			}
			
			lbl2.setText("");
		}
		}catch(NumberFormatException ad) {
			String input2 = lbl.getText();
		}
		 
	}
	
	
	public String getNumber() {
		return lbl.getText();
	}
	
	public String getNumber2() {
		return lbl2.getText();	
	}

	public void backSpace() {
		String a = lbl.getText();
		String e = a.substring(0, a.length()-1);
		
		setLabel(e);
		
		String g = lbl2.getText();
		String f = g.substring(0, g.length()-1);
		
		setLabel2(f);
	}
	
	public void equal() {
		
		if(aa==1) {
			addSymbol("+");
		}else if(ab==1) {
			addSymbol("-");
		}else if(ac==1) {
			addSymbol("/");
		}else if(ad==1) {
			addSymbol("*");
		}
		
	}
	
	
	public static void main(String[] args) {
		new CalculatorSwing_ME();
		
		

		
		
	}

}
	
		
		
		

