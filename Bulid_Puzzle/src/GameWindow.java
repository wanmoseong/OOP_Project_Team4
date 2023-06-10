package TeamProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameWindow extends JFrame {
    private TimerLabel timerPanel; // 타이머
    public JPanel p_right, p_left; // 좌측 우측 Panel
    public Game start; //Game 객체
    private BgMusic bgmusic; //음악 객체

    public GameWindow(int A, String ImagePath, StartWindow p, int level, BgMusic bgmusic) {
        this.bgmusic = bgmusic;

        if (bgmusic != null) {
            bgmusic.play();
        }
        
        //기본적인 요소 생성
        setTitle("Team4 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        JPanel p_body = new JPanel();
        timerPanel = new TimerLabel();

        //좌측
        p_left = new JPanel();
        p_left.setPreferredSize(new Dimension(400, 400));
        //경로 받기
        String imagePath = ImagePath;
        //게임 생성하기
        start = new Game(450, A, imagePath, timerPanel, level, p, GameWindow.this);
        p_left.add(start);
        
        //우측
        addImageToPanel(imagePath);
        p_right = new JPanel();
        p_right.setPreferredSize(new Dimension(390, 390));
        p_right.setBackground(Color.WHITE);
        p_right.setLayout(null);
        
        //위치 설정하기
        p_body.add(p_left, BorderLayout.WEST);
        p_body.add(p_right, BorderLayout.EAST);
        p_body.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        c.add(p_body, BorderLayout.CENTER);
        setVisible(true);
        p_body.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        //뒤로가기 버튼
        JButton back = new JButton("뒤로가기");
        back.setBounds(230, 450, 80, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bgmusic != null) {
                    bgmusic.stop();
                }
                dispose();
                StartWindow startpage = new StartWindow();
                startpage.setVisible(true);
            }
        });
        p_body.add(back);
        
        
        //종료 버튼
        JButton exitButton = new JButton("종료");
        exitButton.setBounds(350, 450, 80, 30);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        p_body.add(exitButton);
        
        
        //초기화 버튼(시간 및 게임)
        JButton resetButton = new JButton("초기화");
        resetButton.setBounds(100, 450, 80, 30);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p_left.removeAll();
                start = new Game(450, A, imagePath, timerPanel, level, p, GameWindow.this);
                p_left.add(start);
                timerPanel.resetTimer();
                p_left.revalidate();
                p_left.repaint();
            }
        });
        p_body.add(resetButton);
        p_body.add(timerPanel);
    }

    private void addImageToPanel(String imagePath) { //우측 이미지 추가 메소드
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(390, 390, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        imageLabel.setLayout(null);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setBounds(0, 0, 390, 390);
        p_right.removeAll();
        p_right.add(imageLabel);
        p_right.revalidate();
    }

    public BgMusic getBgMusic() {
        return bgmusic;
    }
}
