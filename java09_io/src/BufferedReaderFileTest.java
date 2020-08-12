import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderFileTest {

	public BufferedReaderFileTest() {
		try {
			File f = new File("D://javaDev/javaAPI", "CalendarTest.java");
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String txt = br.readLine();  // readLine은 엔터를 읽어오지 않는다. 엔터를 출력 내용을 인식하는데 쓰기때문에..
											 //그래서 줄바꾸기를 하지 않으면 한줄에 쭉 찍힌다.
				if(txt==null) break;
				System.out.println(txt); //readLine 줄바꾸기 프린트라인
			}//무한루프 언제까지 돌려야 하나? 줄단위로 읽으니까 한줄 읽었는데 데이터가 없다? 코드가 null이 찍히면 중단하면 된다.
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("The end...");
	}

	public static void main(String[] args) {
		new BufferedReaderFileTest();
	}

}
