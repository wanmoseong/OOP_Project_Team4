
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private int frameSize=500;
	private int initCount=3;
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("puzzle");
		setSize(frameSize, frameSize);
		JPanel mainPanel=new JPanel(new FlowLayout());
		mainPanel.add(new PicPanel(frameSize,initCount));
		add(mainPanel);
		Dimension layoutSize=getSize();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width-layoutSize.width)/2, (screenSize.height-layoutSize.height)/2);
		setVisible(true);
	}

}
