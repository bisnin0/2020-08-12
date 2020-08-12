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

public class Momo extends JFrame implements ActionListener{ //JFrame ��ӹ޴¼��� �������� �ϳ� ����°�.
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	//� Ŭ������ ��������� �˾ƾ� �̺�Ʈ�� ã�Ƴ� �� �ִ�. JMenuItem�� Ŭ���ϴ°Ŵϱ� 
	
	//�޴� ����
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
			JMenuItem newMenu = new JMenuItem("������"); //����޴��� ������ JMenuItem
			JMenuItem openMenu = new JMenuItem("����");
			JMenu saveMenu = new JMenu("����"); //����޴��� ������JMenu
				JMenuItem save = new JMenuItem("save");
				JMenuItem saveAs = new JMenuItem("save as");
			JMenuItem endMenu = new JMenuItem("����");
			
		JMenu editMenu = new JMenu("����");
			JMenuItem copyMenu = new JMenuItem("�����ϱ�");
			JMenuItem cutMenu = new JMenuItem("�����α�");
			JMenuItem pasteMenu = new JMenuItem("�ٿ��ֱ�");
			
		JMenu runMenu = new JMenu("����");
			JMenuItem memoMenu = new JMenuItem("�޸���");
			JMenuItem editplusMenu = new JMenuItem("����Ʈ�÷���");
			JMenu browserMenu = new JMenu("��������");
				JMenuItem chromeMenu = new JMenuItem("ũ��");
				JMenuItem expMenu = new JMenuItem("�ͽ��÷η�");
			JMenuItem compileMenu = new JMenuItem("������");
			
			String buffer;
			
			
	
	public Momo() {
		super("�޸���");
		add(sp);
		
		//�޴�
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
		
		
		//�̺�Ʈ ���
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
	
	public void actionPerformed(ActionEvent ae) {  //ae���� �̺�Ʈ�� �߻��� ��ü�� ����. 
//		String eventMenu = ae.getActionCommand();
		Object event = ae.getSource();
		if(event == endMenu) {
			dispose(); //�ڿ�����.. �������� ������ �ڿ�����
			System.exit(0);
		}else if(event == newMenu) { //������
			ta.setText(""); 
			setTitle("�޸���"); //������ ���� �޸������� ���� �ٽ� ��ġ��
		}else if(event == openMenu) { //����޴� ����
			openMenu(); //�� �޼ҵ� ���� ����
		}else if(event == save) { //����޴�
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
//		buffer = ta.getSelectedText(); //���ۿ� ������ ���� ��´�.
		copyMenu(); //�ּ��� ���� ���� //���ۿ� ������ ���� ��´�.
		ta.replaceSelection("");//�����.
	
	}
	
	public void pasteMenu() {
		ta.replaceSelection(buffer); //���ۿ� ��� ������ �ִ´�.
	}
	
	public void copyMenu() {
		buffer = ta.getSelectedText(); //���ۿ� ������ ������ ��´�.
		System.out.println(buffer);
	}
	
	
	/////////�����ϱ�
	public void saveMenu() {
		JFileChooser fc = new JFileChooser(); //��� �����Ұ��� â�� �����ϴϱ� Ž���� ȣ��
		int result = fc.showSaveDialog(this); //��ư�� �� �����ߴ���. ���� �ݱ�
		if(result == 0) { //0:����, 1:���
			try {
			File f = fc.getSelectedFile();//������ ��ο� ���ϸ� ������ .. �Է��س��� ���ϸ��� ���ϰ�ü�� ���´�.
			FileWriter fw = new FileWriter(f);//����ó��
			
			String txt = ta.getText();
			fw.write(txt); 
			fw.close();
			
			setTitle(f.getPath());
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/////////����
	public void openMenu() {
		File f = new File("D://javaDev"); //ó�� �����Ҷ� ���� ��ġ ����. ���ϸ� ����â���� �⺻���� 
		JFileChooser fc = new JFileChooser(f); //���� ���̽�.. ���� Ž����
		
		//Filter���� //�������� ����â
		FileFilter f1= new FileNameExtensionFilter("�ڹ�(.java)", "java", "JAVA", "Java"); //FileFilter�� ���� �������̽��� omport �ؾ��Ѵ�.
		fc.addChoosableFileFilter(f1); //���͸�����
		
		FileFilter f2 = new FileNameExtensionFilter("�ڹ�(.class)", "class"); //ȭ�鿡 ���̴� ���ڴ� �ڹ�(.class)�� �����δ� class�� ���õȴ�.
		fc.addChoosableFileFilter(f2);
		
		FileFilter f3 = new FileNameExtensionFilter("�̹���", "jpg", "gif", "png"); //ȭ�鿡 ���̴°� �̹�����. jpg�� gif, png������ �����Ѵ�.
		fc.addChoosableFileFilter(f3);
		
		int result = fc.showOpenDialog(this); //������ ���̾�α׹ڽ��� ���ο� ������ �����ش�. ���Ͽ���â
		////result�� 0�̸� ���⸦ �����Ŵ�. 1�̸� ��ҹ�ư �����Ŵ�.
		////���� ��ư�� �������� Ȯ���Ϸ��� result�� ���� Ȯ���ϸ� �ȴ�.
		if(result ==0) {//�����ư �������
			try {
			
			File selectFile = fc.getSelectedFile();//������ ���ϸ�� ��θ� ��ü�� �����
			
			FileInputStream fis = new FileInputStream(selectFile); //����ó�� �ʿ�
			byte data[] = new byte[(int)selectFile.length()]; //������ ������ ���̸� ���ϸ� ũ�Ⱑ ��������. �������� ����ȯ
			int cnt = fis.read(data);
			
			if(cnt>0) {
				ta.setText(new String(data)); //������ ���Ͽ��� �о�� ������ �ؽ�Ʈ�ʵ忡 ����ִ´�.(���)
			}
			
			setTitle(selectFile.getPath()); //���ϸ�� ������ �� ���ϴ°� getPath. ���� �����ؼ� ���� ������ ���ϰ�ο� ���ϸ����� �ٲ��ش�.
			
			
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















