import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;

public class mainPuzzle extends JFrame {
    private JPanel p_right;

    public mainPuzzle() {
        setTitle("Team4 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);

        Container c = getContentPane();

        JPanel p_body = new JPanel();  // 가운데
        p_right = new JPanel(); // p_right = 힌트 사진
        JPanel p_left = new JPanel(); // p_left = 실행화면
        p_right.setPreferredSize(new Dimension(400, 400));
        p_right.setBackground(Color.DARK_GRAY);
        p_left.setPreferredSize(new Dimension(400, 400));
        p_left.setBackground(Color.DARK_GRAY);

        p_body.add(p_left, BorderLayout.WEST);
        p_body.add(p_right, BorderLayout.EAST);
        p_body.setBackground(Color.GRAY);

        c.add(p_body, BorderLayout.CENTER);
        setVisible(true);
        
        
        String imagePath = "./pic/poo.jpg"; // 실제 이미지 파일
        addImageToPanel(imagePath);
        

		setLayout(null); 
		
		JButton exitButton = new JButton("종료");
		exitButton.setBounds(450, 420, 80, 30);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
			
		});
		add(exitButton);
		
		JButton btn3x3 = new JButton("뒤로가기");
		btn3x3.setBounds(300, 420, 100, 30);

		btn3x3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartPage();
			}
		});
		add(btn3x3);
		
		JButton resetButton = new JButton("초기화");
		resetButton.setBounds(150, 420, 100, 30);

		resetButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 초기화 작업을 수행하는 코드를 여기에 작성하세요.
		    }
		});

		add(resetButton);
		
			
		
	
    }
    
     //우측 Panel 힌트 추가를 위한 메소드
    private void addImageToPanel(String imagePath) {
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        
        // 패널 크기에 맞게 이미지 크기 조절
        Image resizedImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        p_right.removeAll();
        p_right.add(imageLabel);
        p_right.revalidate();
    }
    
    //좌측 Panel 퍼즐을 위한 클래스 생성과 메소드 추가를 위한 부분
    /*************************************************/
    /*                                               */
    /*      이 부분에서 시간 카운트와 퍼즐구현이 이뤄짐 (아마도..)*/
    /*                                               */
    /*************************************************/
    
}
