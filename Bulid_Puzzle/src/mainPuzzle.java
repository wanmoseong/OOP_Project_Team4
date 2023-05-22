import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainPuzzle extends JFrame {
    public JPanel p_right;
    ImageIcon icon_p_body, iconleft, iconright;

    public mainPuzzle() {
    	
    	icon_p_body = new ImageIcon("Body.png"); //이미지 끌고오기
		 
		 JPanel p_body = new JPanel() { 
			 
			 protected void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.drawImage(icon_p_body.getImage(), 0, 0, getWidth(), getHeight(), null);
			
	         }
		 };
    	
        setTitle("Team4 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setSize(900, 500);
        setLocationRelativeTo(null); //실행하면 중앙에 위치 함 
        Container c = getContentPane();

        
        
        // 가운데
        p_right = new JPanel(); // p_right = 힌트 사진
        JPanel p_left = new JPanel(); // p_left = 실행화면
        
        p_right.setPreferredSize(new Dimension(400, 400));
        p_right.setBackground(Color.WHITE);
        p_left.setPreferredSize(new Dimension(400, 400));
        p_left.setBackground(Color.WHITE);

        p_body.add(p_left, BorderLayout.WEST);
        p_body.add(p_right, BorderLayout.EAST);
        
        c.add(p_body, BorderLayout.CENTER);
        
        setVisible(true);
        
        
        String imagePath = "./pic/poo.jpg"; // 실제 이미지 파일
        addImageToPanel(imagePath);
        

        p_body.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
	
		
		JButton back = new JButton("뒤로가기");
		back.setBounds(230, 450, 80, 30);

		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartPage();
			}
		});
		p_body.add(back);
		
		JButton resetButton = new JButton("초기화");
		resetButton.setBounds(100, 450, 80, 30);

		resetButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 초기화 작업을 수행하는 코드를 여기에 작성하세요.
		    }
		});

		p_body.add(resetButton);
		
		JButton exitButton = new JButton("종료");
		exitButton.setBounds(350, 450, 80, 30);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		p_body.add(exitButton);
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

