import java.awt.event.ActionListener;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;

public class CalculatorEvent implements ActionListener {
	JTextField tf;
	String oper = "";//연산자 저장할 변수
	double result = 0.0; //첫번째 연산자이자 결과
	
	public CalculatorEvent() {
		
	}
	
	public CalculatorEvent(JTextField tf) {
		this.tf = tf; //tf의 주소를 같게 만들어준다. CalculatorSwing과... 같은 값이 나오게
	}
	public void actionPerformed(ActionEvent ae) {
		String eventTxt = ae.getActionCommand(); //9누르면 9 들어가있고, 7 누르면 7 들어가있는 상태
		switch(eventTxt){ 
			//방금 event가 생긴 애가 End냐?
			case "End":
				System.exit(0); break; //프로그램을 끝내라
			
				
			//BackSpace처리
			case "BackSpace":
				setBackSpace();
				break;
				
			//방금 이벤트가 생긴애가 .이면 소수점 처리를 해야함
			case ".":
				setPoint();
				break;
				
			//연산자처리   == 케이스가 여러개 같은거면 아래처럼 처리해도 된다.
			case "+":
			case "-":
			case "*":
			case "/":
				setOperator(eventTxt);
				break;
				
			//=이 들어갔을때
			case "=":
				setCalculator();
				break;
			
			case "Clear":
				setClear();
				break;
				
			//evetTxt에 들어있는 값이 혹시 숫자냐? 
			default://숫자버튼일경우
				setNumber(eventTxt);//숫자가 들어오면 setNumber를 호출해서 이벤트가 생긴 숫자를 넘겨준다.
				
		}
	}
	public void setClear() {
		result = 0.0;
		oper = "";
		tf.setText("0.0");
	}
	public void setCalculator() {
		//처음 계산할 데이터는 result에 있고 연산자는 oper에 들어있다.
		//나중에 입력한 데이터는 tf에 들어있다.
		double secondNum = Double.parseDouble(tf.getText());
		//tf에서 데이터를 가져와서 실수로 바꾸고 secondNum에 넣는다.
		switch(oper) {
			case "+": result = result + secondNum; break; //더하기
			case "-": result = result - secondNum; break; //빼기
			case "*": result = result * secondNum; break; //곱하기
			case "/": result = result / secondNum; break; //나누기
		//result에 결과를 넣어둠.
		
		}
		tf.setText(Double.toString(result));//계산결과 tf표시 double값 result를 문자열로 바꿔줌
		//		   String.valueOf(result)도 가능하다.
		
		//연산자 지우기
		oper = "";
	}
	
	public void setOperator(String eventTxt) {
		//방금 발생한 이벤트중 연산자가 들어간것.
		//결과값은 멤버변수에 저장한다.
		oper = eventTxt;//연산자 //' 789 + ' 를 입력하면 + 는 oper에 들어가있고
		result = Double.parseDouble(tf.getText()); //789는 result에 들어가있다.
		// tf초기화 .. 다음 숫자를 받아야 하니까
		tf.setText("");
	}
	
	public void setPoint() { //소수점이 있는지 없는지 확인먼저 해야한다.
		String txt = tf.getText(); //특정문자의 index위치를 구하는것. 
		if(txt.indexOf(".") == -1){//indexOf// -1이 나오면 찾는게 없단거고. 양수 숫자가 나오면 찾는게 있다는것.
			tf.setText(txt+"."); //소수점이 한개만 들어가게.
			//이렇게하면 소수점이 하나 찍히고 나서 더는 눌러도 찍히지 않는다.
		}
		
	}
	
	public void setNumber(String eventTxt) { //방금 이벤트가 생긴 버튼이 뭔지 전달 받는다.
		String tfTxt = tf.getText();
		if(tfTxt.equals("0.0")){
			tf.setText(eventTxt); //만약 방금 tf의 텍스트가 0.0이면 방금 이벤트 생긴걸 넣는다.
		}else {
			tf.setText(tfTxt+eventTxt); //0.0이 아니면 기존 값에 방금 받은 값을 추가해서 호출
		}
		
	}
	
	//BackSpace 기능구현.. 문자열에서 몇번째에 뭐가 있는지 찾는것. subString
	//52623
	//01234 ==subString(0,4) == 길이가 5개인데 4개까지 구하면 마지막 3번째가 사라지니까
	// sbuString(0, txt.length()-1); 

	public void setBackSpace() {
		try {
		String txt = tf.getText();
		String cutTxt = txt.substring(0, txt.length()-1); //시작은 0번째부터.(제일 앞) 글자의 길이에서 -1까지
		tf.setText(cutTxt);
		}catch(StringIndexOutOfBoundsException sioobe) {
			System.out.println("에러발생함. 문자열 길이 0인데 길이를 -1만큼 빼려고 했음");
		}
		//예외처리  StringIndexOutOfBoundsException .. 글자의 길이가 0인데("") -1만큼 빼려고 하니까 에러발생
		//String은 -1이라는 index가 없다.
		//글자 길이를 확인해서 글자길이가 0일때 더 안하는걸로 바꿔주면 되겠다.
		//이렇게 하면 실제로 에러는 있는거지만 예외처리로 메시지가 안뜨는거다.
	}
}
