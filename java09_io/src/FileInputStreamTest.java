import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public FileInputStreamTest() {
		//파일의 내용을 byte단위로 읽기
		try{   //예외처리 미리 해놓기
			
			File file = new File("D:/javaDev/javaAPI/CalendarTest.java");
			
			FileInputStream fis = new FileInputStream(file);
			
			while(true) {
				int inData = fis.read();
				if(inData==-1) {System.out.println(inData);break;} //읽었는데 데이터가 없으면 -1이 나오기 때문에 조건을 걸어 멈출 수 있다. //End Of File : EOF
				System.out.print((char)inData); //파일의 내용을 byte형으로 출력한다.
			}
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileInputStreamTest();
	}

}
