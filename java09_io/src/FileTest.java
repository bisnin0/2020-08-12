import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
//		File f= new File("D:\javaDev\javaAPI\ArraysTest.java"); //이 경로에 있는 파일로 작업을 할거다... 인데 에러가 발생 \백슬레시는 제어문자를 의미하기때문에 자바에서는 /를쓴다. 
		File f1 = new File("D:/javaDev/javaAPI/ArraysTest.java"); //절대주소지정방식
		File f2 = new File("D:/javaDev/javaAPI","CalendarTest.java");
		File f3 = new File("\"D:/javaDev/javaAPI"); //폴더 경로만 넣는것. 폴더만 가지고 객체 생성도 가능하다.
		File f4 = new File(f3, "RandomTest.java"); //f3에서 이미 경로가 객체로 만들어져 있으니 객체를 이용해서 파일을 지정
		
		File f5 = new File("D:/javaFolder/a/b/c"); //없는 폴더를 만드는방법.. 아래 메소드를 이용해서 있는지 없는지 확인먼저 한다.
		//exists() : 폴더 혹은 파일이 존재하는지 확인해주는 메소드(있으면 true, 없으면 false가 돌아온다)
		if(!f5.exists()) { //없으면 false니까 false일때 실행되어야한다.그러니까 앞에 !부정을 써준다.
			if(f5.mkdirs()) {//폴더생성
				System.out.println("폴더가 생성되었습니다.");//폴더가 생성되었으면 여기가 실행
			}else {
				System.out.println("폴더생성 실패하였습니다.");//만들다가 에러가 발생하면 여기가 실행
			}
		}
		
		try {
		
		//파일생성하기
		File f6 = new File("D:/javaFolder/test.txt");
		if(!f6.exists()) {
			if(f6.createNewFile()) { //에러... 예외처리 필요. 
				System.out.println("파일이 생성되었습니다.");
			}else {
				System.out.println("파일생성 실패하였습니다.");
			}
		}
		//마지막 수정일 구하기
		long lastDate = f2.lastModified(); //왜 long이냐면 밀리초(ms 1/1000초)로 들어와서 값이 너무 크기 때문에
		System.out.println("lastDate="+lastDate); //밀리초로 수정된날짜를 구한다. 
		
		Calendar date = Calendar.getInstance();
		System.out.println("오늘 밀리초 = " + date.getTimeInMillis());
		
		//여기부터 구한 밀리초를 변환
		date.setTimeInMillis(lastDate);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String dateStr = format2.format(date.getTime());
		System.out.println("마지막 수정일 = " + dateStr);
		
		
		
		System.out.println("exe = "+ f2.canExecute()); //실행형파일인지 아닌지 확인해주는것?
		System.out.println("read="+ f2.canRead()); //읽기 가능한지 확인
		System.out.println("write="+ f2.canWrite()); // 쓰기 가능한지 확인
		
		//특정 폴더내의 모든 파일과 모든 폴더 정보를 얻어오기
		File f7 = new File("D://");
		File f8[] = f7.listFiles();
		for(File f : f8) {
			//getName():파일명만, getParent():폴더명만 , getPath():폴더+파일명
			if(f.isDirectory()) {
				System.out.println(f.getPath()+"[폴더]");
			}else if(f.isFile()) {
				System.out.println(f.getPath()+"[파일]");
			}
		}
		System.out.println("f2.length()="+f2.length()+"byte"); //업로드시 특정파일 선택해서 올릴때 확인하는 정보.. 파일의 byte크기
		
		//현재컴퓨터의 드라이브 목록 구하기
		File root[] = File.listRoots();
		for(File f:root) {
			System.out.println("드라이브->"+f.getPath());
		}
		
		//파일 삭제
		File f9 = new File("D:/demo 2.sql");
		if(f9.delete()) {
			System.out.println("파일이 삭제되었습니다.");
		}else {
			System.out.println("파일 삭제에 실패했습니다.");
		}
		
		
		}catch(IOException e) {
			System.out.println(e.getMessage()); //경로가 틀렸거나 하면 '지정한 경로를 찾을 수 없습니다' 같은 메시지를 띄워준다.
		}
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
