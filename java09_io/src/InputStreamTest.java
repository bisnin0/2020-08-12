import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		try {
		//input, output : byte 단위로 작업을 하는 클래스
		//reader, writer : char.. 문자단위로 작업을 하는 클래스
		
		//byte단위로 콘솔에서 데이터 입력받는 클래스
		InputStream in = System.in;  //시스템 클래스에있는 in이라는 객체가 이미 가지고 있기때문에
		
		System.out.print("입력=");

//		int data = in.read();  ////////예외처리 반드시 있어야한다.
//		System.out.println(data);

		//////////실행결과는 ABCD를 썼을때 65가나온다. 이건 A의 아스키코드값. 여러문자를 써도 제일 앞에만 읽어낸거다.
		//////////그래서 반복을 해줘야함.
//문자를 입력하면 문자의 아스키코드와 어떤문자가 입력되었는지 출력해서 보여주는것. 여러문자라도 가능		
		while(true) { //바이트로 쪼개는거라 한글 입력하면 반절씩 쪼개져서 글자 깨진다.
			int data = in.read();  ////////예외처리 반드시 있어야한다.
			if(data==13)break; //13이 들어오면 엔터를 쳤다는 말이니까 엔터 안보이게 하려면 이렇게
			System.out.println("data="+data);
			System.out.println("data="+(char)data); //이렇게하면 숫자 아니라 문자로 나옴
			
			
		} //ABCDE를 치면 각각의 아스키보드값이 나오고 13, 10이 출력되는데 이건 엔터로인해 나온것
 		
		//byte 배열을 이용한 데이터 입력
		
/*		byte data[] = new byte[10];
		int cnt = in.read(data);
		System.out.println(cnt+"-->"+ new String(data)+"===");//바이트를문자로 바꾸기 
		//출력결과는 asdfe 치면 7(줄바꿈)-->asdfe 라고 나온다. 7인 이유는 엔터값 13과 10이 들어가있어서.
		System.out.println(cnt+"-->"+ new String(data,0,cnt-2)+"==="); //엔터(줄바꿈)없이 출력하려면 엔터값을 제외
*/		//asdfe 7-->asdfe

/*		
		//입력받은것의 바이트 수를 정하고 몇번째 인덱스에 넣을건지 정하기.
		byte data[] = new byte[10];
		int cnt = in.read(data,3,5); //입력한 숫자만큼 읽어서 3번째 인덱스에 집어넣는다. 5바이트만 읽어라.
		System.out.println(cnt+"==>"+ new String(data)+"---");
*/		
		
		
		System.out.println("end...");
		
		
		}catch(IOException io) {
			io.printStackTrace(); //에러가 생기면 에러 메시지를 찍으라는것 io뿐만 아니라 다른 예외처리에 다 있다.
		}
	}

	public static void main(String[] args) {
		new InputStreamTest();
	}

}
