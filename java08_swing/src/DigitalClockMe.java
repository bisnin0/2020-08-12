import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockMe extends JFrame {
	Dimension dim = new Dimension(300,100);
	Point p = new Point(800,500);
	Rectangle rect = new Rectangle(p, dim);
	Calendar now = Calendar.getInstance();
	public DigitalClockMe() {
		
		super("Clock");
		setLayout(new GridLayout());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("img/k2.jpg");
		super.setIconImage(icon);
				
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String today = sdf.format(now.getTime());
		
		JLabel lbl1 = new JLabel(today, JLabel.CENTER);
		add(lbl1);
		Font fnt = new Font("±Ã¼­Ã¼", Font.BOLD, 50);
		lbl1.setFont(fnt);

		
		setBounds(rect);
		setVisible(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		
//		setSize(300,100);
		
		
		
	}

	
	
	public static void main(String[] args) {
		new DigitalClockMe();
	}

}
