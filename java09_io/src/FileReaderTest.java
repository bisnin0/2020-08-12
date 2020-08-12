import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		try {
			File f = new File("D:/javaDev/javaAPI", "CalendarTest.java");
			
			//글꼴단위 파일의 내용 읽어오기
			FileReader fr = new FileReader(f);
			
			while(true) { //한문자씩 읽어서 출력을 해야하니까 반복문을 돌린다.
				int inData = fr.read(); //오른쪽을 먼저 완성하면 int형인지 Strig인지 나온다.
				if(inData==-1) {
					break;
				}
				System.out.print((char)inData);
			}
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static void main(String[] args) {
		new FileReaderTest();
		
	}

}
