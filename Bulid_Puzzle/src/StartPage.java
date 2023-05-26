
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;


public class StartPage extends JFrame {
	JScrollPane scrollPane;
    ImageIcon iconbody, iconleft, iconright;
    String ImagePath;
    image im;

    
	public StartPage() {
		 
		 iconbody = new ImageIcon("Body.png"); //이미지 끌고오기
		 
		 JPanel Body = new JPanel() { 
			 
			 protected void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.drawImage(iconbody.getImage(), 0, 0, getWidth(), getHeight(), null);
			
	         }
		 };
		 
	
		setTitle("Team4 Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 450);
		setLocationRelativeTo(null); //실행하면 중앙에 위치 함 

		Container c = getContentPane();
		
		iconright = new ImageIcon("rightstartex.png"); //이미지 끌고오기
		
		JPanel Right = new JPanel() {
			 protected void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.drawImage(iconright.getImage(), 0, 0, getWidth(), getHeight(), null);;
	         }
		 };//사진만 넣어놨습니다 이미지 버튼 X
	
		 
		iconleft = new ImageIcon("startpageex.png"); //이미지 끌고오기
		JPanel Left = new JPanel() {
			protected void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.drawImage(iconleft.getImage(), 0, 0, getWidth(), getHeight(), null);;
		
	         }
		 };
		
		
		
		Body.add(Left, BorderLayout.WEST);
		Body.add(Right, BorderLayout.EAST);
		
		
		Left.setBackground(Color.WHITE); //패널 색상
		Left.setPreferredSize(new Dimension(400,400));	//패널 크기
		Left.setAlignmentY(JLabel.CENTER_ALIGNMENT); //패널이 항상 중앙맞춤
		
		
		
		Right.setBackground(Color.WHITE); //패널 색상
		Right.setPreferredSize(new Dimension(400,400)); //패널 크기
		Right.setAlignmentY(JLabel.CENTER_ALIGNMENT); //패널이 항상 중앙맞춤
		
		Font font = new Font("G마켓 산스 TTF Bold", Font.BOLD, 16); //폰트 모양 안돌아가면 Arial 로 일단 바꾸시면 됩니다
		Font font1 = new Font("G마켓 산스 TTF Bold", Font.BOLD, 30); //난이도 설정 폰트
		UIManager.put("Button.font", font);
		UIManager.put("Label.font", font);
		// 필요한 다른 컴포넌트에 대해서도 폰트 설
		
		//Left Part.
		Left.setLayout(null);
		
		
		//밑은 난이도 버튼 
		
		JButton btn3x3 = new JButton("3x3");
		btn3x3.setBackground(Color.WHITE);
		btn3x3.setBounds(100, 170, 200, 50);
		Left.add(btn3x3);
		
		
		JButton btn4x4 = new JButton("4x4");
		btn4x4.setBackground(Color.WHITE);
		btn4x4.setBounds(100, 240, 200, 50);
		Left.add(btn4x4);
		
		JButton btn5x5 = new JButton("5x5");
		btn5x5.setBackground(Color.WHITE);
		btn5x5.setBounds(100, 310, 200, 50);
		Left.add(btn5x5);

		
		setVisible(true);
		c.add(Body);
		c.setBackground(Color.red);
		
		im = new image(Right);			// 오른쪽 패널에 파일 선택 "열기" 버튼 추가 파일 열기 전에는 액션 추가 ㄴㄴ
		
		System.out.println("File path selected: " + im.AbsolutePath);		// 경로가 잘 들어갔는지 확인
		System.out.println("File path selected in main: " + im.AbsolutePath);
                
		btn3x3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new mainPuzzle(3,im.AbsolutePath);
			}
		});
                
		btn4x4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new mainPuzzle(4,im.AbsolutePath);
			}
		});
		
		btn5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new mainPuzzle(5,im.AbsolutePath);
			}
		});
                
		System.out.println("first time is sucess");		// 그냥 처음 시작했을 때, 성공은 하는데 뒤로가기 했을 때, 뭔가 꼬임;;
	   
	}

	public static void main(String[] args) {
		StartPage i = new StartPage();
		System.out.println(i.ImagePath);
	}
}
