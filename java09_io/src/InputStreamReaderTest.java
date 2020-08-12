import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		try {
		
		InputStreamReader isr = new InputStreamReader(System.in); //안에 추상메소드가 있어서 new InputStreamreader 할수없다.

		
		//문자단위 콘솔에서 데이터 입력받기
/*		
		System.out.println("입력=");
		while(true) {
			int code = isr.read(); //예외처리 반드시 필요
			if(code==13)break;//엔터가 들어오면 프로그램 종료
			System.out.println(code+"==>"+(char)code); //인트를 문자로
		}
*/		
		
		//char배열로 입력받기
		System.out.println("입력=");
		char data[] = new char[10];
		int cnt = isr.read(data);
		System.out.println(cnt+"==>"+String.valueOf(data));
		
		
		
		
		}catch(IOException e) {
			e.printStackTrace(); //에러나면 어디서 에러나는지 확인하기위해 개발자들이 찍는 코드. 
		}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();
	}

}
