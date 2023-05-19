import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPage extends JFrame {
	
	public StartPage() {
		setTitle("Team4 Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 450);

		Container c = getContentPane();
		
		JPanel Body = new JPanel();
		JPanel Right = new JPanel();
		JPanel Left = new JPanel();
		
		Body.add(Left, BorderLayout.WEST);
		Body.add(Right, BorderLayout.EAST);
		
		Left.setBackground(Color.GRAY);
		Left.setPreferredSize(new Dimension(400,400));		
		Right.setBackground(Color.GRAY);
		Right.setPreferredSize(new Dimension(400,400));
		
		//Left Part.
		Left.setLayout(null);
		
		JLabel Text = new JLabel("난이도 설정");
		Text.setBounds(100, 50, 200, 50);
		Left.add(Text);
		
		JButton btn3x3 = new JButton("3x3");
		btn3x3.setBounds(100, 120, 200, 50);

		btn3x3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new mainPuzzle();
			}
		});
		Left.add(btn3x3);
		
		JButton btn4x4 = new JButton("4x4");
		btn4x4.setBounds(100, 195, 200, 50);
		
		btn4x4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new Puzzle();
			}
		});
		Left.add(btn4x4);
		
		JButton btn5x5 = new JButton("5x5");
		btn5x5.setBounds(100, 270, 200, 50);
		Left.add(btn5x5);
		
		//Right Part. 추후 추가 예정
		
		setVisible(true);
		c.add(Body);
		c.setBackground(Color.red);

	}

	public static void main(String[] args) {
		new StartPage();
	}
}
