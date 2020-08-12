import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStreamTest {

	public FileOutputStreamTest() {
	
		
		//파일의 내용을 읽어서 다른 파일로 저장하기
		File source = new File("D://javaDev/javaAPI/CalendarTest.java");//원본파일 객체
		
		//타겟(저장할)파일 객체
		File target = new File("D://javaFolder/CalendarTestCopy2.java");//타겟파일객체
								//****아래 FileInputStream으로 만든건 CalendarTestCopy로 만들어놨음
	
	
		try {
//			FileInputStream fis = new FileInputStream(source);
//			FileOutputStream fos = new FileOutputStream(target);    ////기본적으로 이 byte형으로 하는게 좋다.
			
			FileReader fis = new FileReader(source);     //파일 복사는 결과가 같지만 reader보다 byte형(input, output)으로 하는게 좋다.
			FileWriter fos = new FileWriter(target);
			
			
			while(true) {
				int inData = fis.read();
				if(inData==-1) {break;}
				fos.write(inData);
			}
			System.out.println(source.getPath()+"파일이 "+target.getPath()+"로 복사되었습니다.");
			fis.close();
			fos.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	
	
	
	
	}

	public static void main(String[] args) {
		new FileOutputStreamTest();
	}

}
