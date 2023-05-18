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
		
		Left.setLayout(null);
		
		JButton btn = new JButton("Test");
		btn.setBounds(100, 100, 100, 50);
		
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new mainPuzzle();
			}
		});
		Left.add(btn);
		
		
		setVisible(true);
		c.add(Body);
		c.setBackground(Color.red);

	}

	public static void main(String[] args) {
		new StartPage();
	}
}