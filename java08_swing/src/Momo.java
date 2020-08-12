import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Momo extends JFrame implements ActionListener{ //JFrame 상속받는순간 프레임이 하나 생기는것.
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	//어떤 클래스로 만들었는지 알아야 이벤트를 찾아낼 수 있다. JMenuItem을 클릭하는거니까 
	
	//메뉴 생성
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenu = new JMenuItem("새문서"); //서브메뉴가 없으면 JMenuItem
			JMenuItem openMenu = new JMenuItem("열기");
			JMenu saveMenu = new JMenu("저장"); //서브메뉴가 있으면JMenu
				JMenuItem save = new JMenuItem("save");
				JMenuItem saveAs = new JMenuItem("save as");
			JMenuItem endMenu = new JMenuItem("종료");
			
		JMenu editMenu = new JMenu("편집");
			JMenuItem copyMenu = new JMenuItem("복사하기");
			JMenuItem cutMenu = new JMenuItem("오려두기");
			JMenuItem pasteMenu = new JMenuItem("붙여넣기");
			
		JMenu runMenu = new JMenu("실행");
			JMenuItem memoMenu = new JMenuItem("메모장");
			JMenuItem editplusMenu = new JMenuItem("에디트플러스");
			JMenu browserMenu = new JMenu("웹브라우저");
				JMenuItem chromeMenu = new JMenuItem("크롬");
				JMenuItem expMenu = new JMenuItem("익스플로러");
			JMenuItem compileMenu = new JMenuItem("컴파일");
			
			String buffer;
			
			
	
	public Momo() {
		super("메모장");
		add(sp);
		
		//메뉴
		mb.add(fileMenu); mb.add(editMenu); mb.add(runMenu);
		
		fileMenu.add(newMenu); fileMenu.add(openMenu); fileMenu.add(saveMenu); fileMenu.add(endMenu);
		saveMenu.add(save); saveMenu.add(saveAs);
		
		editMenu.add(copyMenu); editMenu.add(cutMenu); editMenu.add(pasteMenu);
		
		runMenu.add(memoMenu); runMenu.add(editplusMenu); runMenu.add(browserMenu);runMenu. add(compileMenu);
		browserMenu.add(chromeMenu); browserMenu.add(expMenu);
		
		setJMenuBar(mb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//이벤트 등록
		newMenu.addActionListener(this);
		openMenu.addActionListener(this);
		save.addActionListener(this);
		saveAs.addActionListener(this);
		endMenu.addActionListener(this);
		
		copyMenu.addActionListener(this);
		cutMenu.addActionListener(this);
		pasteMenu.addActionListener(this);
		
		memoMenu.addActionListener(this);
		editplusMenu.addActionListener(this);
		chromeMenu.addActionListener(this);
		expMenu.addActionListener(this);
		compileMenu.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {  //ae에는 이벤트가 발생한 객체가 담긴다. 
//		String eventMenu = ae.getActionCommand();
		Object event = ae.getSource();
		if(event == endMenu) {
			dispose(); //자원해제.. 프레임이 닫히면 자원해제
			System.exit(0);
		}else if(event == newMenu) { //새문서
			ta.setText(""); 
			setTitle("메모장"); //새문서 열면 메모장으로 제목 다시 고치기
		}else if(event == openMenu) { //열기메뉴 선택
			openMenu(); //길어서 메소드 따로 만듬
		}else if(event == save) { //저장메뉴
			saveMenu();
		}else if(event == copyMenu) {
			copyMenu();
		}else if(event == pasteMenu) {
			pasteMenu();
		}else if(event == cutMenu) {
			cutMenu();
		}
	}
	public void cutMenu() {
//		buffer = ta.getSelectedText(); //버퍼에 선택한 내용 담는다.
		copyMenu(); //주석과 같은 내용 //버퍼에 선택한 내용 담는다.
		ta.replaceSelection("");//지운다.
	
	}
	
	public void pasteMenu() {
		ta.replaceSelection(buffer); //버퍼에 담긴 내용을 넣는다.
	}
	
	public void copyMenu() {
		buffer = ta.getSelectedText(); //버퍼에 선택한 내용을 담는다.
		System.out.println(buffer);
	}
	
	
	/////////저장하기
	public void saveMenu() {
		JFileChooser fc = new JFileChooser(); //어디에 저장할건지 창이 떠야하니까 탐색기 호출
		int result = fc.showSaveDialog(this); //버튼을 뭘 선택했는지. 열기 닫기
		if(result == 0) { //0:저장, 1:취소
			try {
			File f = fc.getSelectedFile();//선택한 경로와 파일명 얻어오기 .. 입력해놓은 파일명이 파일객체로 들어온다.
			FileWriter fw = new FileWriter(f);//예외처리
			
			String txt = ta.getText();
			fw.write(txt); 
			fw.close();
			
			setTitle(f.getPath());
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/////////열기
	public void openMenu() {
		File f = new File("D://javaDev"); //처음 실행할때 보일 위치 지정. 안하면 문서창으로 기본지정 
		JFileChooser fc = new JFileChooser(f); //파일 초이스.. 파일 탐색기
		
		//Filter생성 //파일형식 고르는창
		FileFilter f1= new FileNameExtensionFilter("자바(.java)", "java", "JAVA", "Java"); //FileFilter는 스윙 파일초이스로 omport 해야한다.
		fc.addChoosableFileFilter(f1); //필터링적용
		
		FileFilter f2 = new FileNameExtensionFilter("자바(.class)", "class"); //화면에 보이는 문자는 자바(.class)고 실제로는 class만 선택된다.
		fc.addChoosableFileFilter(f2);
		
		FileFilter f3 = new FileNameExtensionFilter("이미지", "jpg", "gif", "png"); //화면에 보이는건 이미지로. jpg와 gif, png파일을 선택한다.
		fc.addChoosableFileFilter(f3);
		
		int result = fc.showOpenDialog(this); //열려진 다이얼로그박스에 새로운 파일을 보여준다. 파일열기창
		////result가 0이면 열기를 누른거다. 1이면 취소버튼 누른거다.
		////열기 버튼을 눌렀는지 확인하려면 result의 값을 확인하면 된다.
		if(result ==0) {//열기버튼 누른경우
			try {
			
			File selectFile = fc.getSelectedFile();//선택한 파일명과 경로를 객체로 만들기
			
			FileInputStream fis = new FileInputStream(selectFile); //예외처리 필요
			byte data[] = new byte[(int)selectFile.length()]; //선택한 파일의 길이를 구하면 크기가 구해진다. 에러나서 형변환
			int cnt = fis.read(data);
			
			if(cnt>0) {
				ta.setText(new String(data)); //선택한 파일에서 읽어온 정보를 텍스트필드에 집어넣는다.(출력)
			}
			
			setTitle(selectFile.getPath()); //파일명과 폴더명 다 구하는것 getPath. 파일 선택해서 열면 제목을 파일경로와 파일명으로 바꿔준다.
			
			
			}catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	public static void main(String[] args) {
		new Momo();
		
	}

}















