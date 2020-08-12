import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferedInputStreamTest {

	public BufferedInputStreamTest() {
		try {
			//콘솔에서 문자단위 입력하여 버퍼에 저장후 줄단위로 읽어오기
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while(true) {
				System.out.print("입력=");
				String inData = br.readLine();
				System.out.println(inData);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new BufferedInputStreamTest();
	}
	

}
/*
BufferedInputStream과 BufferedOutputStream은 FilterStream을 상속하여 실제 필터 기능을 제공하는 클래스이다.



[JAVA] ByteStream : FilterInputStream / FilterOutputStream





FileInputStream /FileOutputStream 에서 이야기한 것처럼, 1 Byte 단위로 입/출력이 이루어지면 기계적인 동작이 많아지므로 효율이 떨어지게 된다.

또한, 사용자가 일일이 버퍼와 크기를 지정하여 입출력을 하게 되는 것도 정적이고 불편하다.



[JAVA] ByteStream : FileInputStream / FileOutputStream





이때 BufferedInputStream / BufferedOutputStream을 사용하면 편리하고 효율적인 입출력을 할 수 있다.



BufferedInputStream을 통하여 원하는 자료를 1바이트 단위로 읽는 read() 메소드를 수행하면 시스템 내부적으로 버퍼를 준비하고 이 버퍼를 이용하여 지정된 파일로부터 버퍼의 크기만큼 한꺼번에 많은 데이터를 가져온다.

이렇게 채워진 버퍼로부터 1 바이트씩 읽어들여 프로그램으로 전달하게 된다.

이때, 1 바이트씩 읽어들이는 작업은 파일로부터 읽어오는 것이 아닌 준비된 시스템 버퍼에서 읽어오게 되므로, 파일 입력으로 인한 성능 저하를 최소화 할 수 있다.



BufferedOutputStream 역시 마찬가지로 데이터를 1 바이트씩 출력하면 파일이 아닌 준비된 시스템 버퍼에 출력을 쌓는다.

버퍼가 모두 채워지거나 close(), flush() 명령을 만나면 버퍼의 모든 내용을 하드 디스크 파일에 출력한다.

따라서, BufferedOutputStream 역시 하드 디스크 파일에 대한 출력을 최소화 하여 효율을 향상 시킬 수 있다.



결론적으로 사용자가 BufferedInputStream과 BufferedOutputStream을 이용하여 프로그램을 작성하면 1 바이트씩 읽고 쓰는 모든 작업이 하드 디스크 파일이 아닌 내부적인 버퍼를 대상으로 발생하며, 필요에 따라 버퍼와 하드 디스크 파일간에 입출력이 간헐적으로 발생하므로 전체적인 입출력 성능이 동적으로 향상될 수 있다.



출처: https://hyeonstorage.tistory.com/238 [개발이 하고 싶어요]
*/
