import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class mainPuzzle extends JFrame {
    public JPanel p_right;
    ImageIcon icon_p_body, iconleft, iconright;

    private JButton timerButton; // 타이머 버튼
    private Timer timer; // 타이머 객체
    private int count; // 타이머 카운트 변수

    public mainPuzzle(int A) {
        icon_p_body = new ImageIcon("Body.png"); // 이미지 끌고오기
        JPanel p_body = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(icon_p_body.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        setTitle("Team4 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        Container c = getContentPane();

        // 가운데
        p_right = new JPanel(); // p_right = 힌트 사진
        JPanel p_left = new JPanel(); // p_left = 실행화면
        p_right.setPreferredSize(new Dimension(400, 400));
        p_right.setBackground(Color.WHITE);

        p_body.add(new PicPanel(450, A), BorderLayout.WEST);
        p_body.add(p_right, BorderLayout.EAST);
        c.add(p_body, BorderLayout.CENTER);
        setVisible(true);

        String imagePath = "Desert.png"; // 실제 이미지 파일
        addImageToPanel(imagePath);

        p_body.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        timerButton = new JButton("타이머 시작");
        timerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer == null) {
                    startTimer();
                } else {
                    stopTimer();
                }
            }
        });
        p_body.add(timerButton);

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

    // 우측 Panel 힌트 추가를 위한 메소드
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

    // 타이머 시작
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                timerButton.setText("타이머: " + count + "초");
                // 원하는 작업을 여기에 추가할 수 있습니다.
            }
        });
        timer.start();
        timerButton.setText("타이머 정지");
    }

    // 타이머 정지
    private void stopTimer() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        timerButton.setText("타이머 시작");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new mainPuzzle(10));
    }
}
