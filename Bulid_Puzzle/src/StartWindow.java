import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StartWindow extends JFrame {
    private String imagePath;
    private JLabel previewLabel;

    public StartWindow() {
        setTitle("Team4 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.YELLOW);

        // Left 패널 생성
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(400, 400));
        leftPanel.setLayout(null); // Absolute Layout
        // 제목 라벨
        JLabel titleLabel = new JLabel("SLIDE PUZZLE");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(100, 65, 200, 30);
        titleLabel.setForeground(Color.WHITE); // 글꼴 색상을 흰색으로 설정
        leftPanel.add(titleLabel);

        // 도형 패널
        JPanel shapePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 도형 그리기
                g.setColor(Color.YELLOW);
                g.drawRect(105, 50, 50, 50);
                g.setColor(Color.YELLOW);
                g.drawRect(70, 30, 100, 100);
                g.setColor(Color.YELLOW);
                g.drawRect(265, 58, 20, 20);
                g.setColor(Color.YELLOW);
                g.drawOval(90, 170, 20, 20);
                g.setColor(Color.YELLOW);
                g.drawOval(90, 220, 20, 20);
                g.setColor(Color.YELLOW);
                g.drawOval(90, 270, 20, 20);
                g.setColor(Color.YELLOW);
                g.drawRect(10, 370, 200, 20);
                g.setColor(Color.YELLOW);
                g.drawRect(30, 375, 200, 20);
                g.setColor(Color.YELLOW);
                g.drawRect(300, 370, 20, 20);
                g.setColor(Color.YELLOW);
                g.drawRect(305, 360, 20, 20);
                g.setColor(Color.YELLOW);
                g.drawRect(320, 340, 30, 30);
                g.setColor(Color.YELLOW);
                g.drawRect(340, 310, 40, 40);
               
            }
        };
        shapePanel.setBackground(Color.BLACK);
        shapePanel.setBounds(5, 6, 700, 400);
        leftPanel.add(shapePanel);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(130, 170, 150, 150);

        JButton btn3x3 = new JButton("3x3");
        btn3x3.setBackground(Color.WHITE);
        btn3x3.setBounds(0, 0, 130, 30);
        buttonPanel.add(btn3x3);

        JButton btn4x4 = new JButton("4x4");
        btn4x4.setBackground(Color.WHITE);
        btn4x4.setBounds(0, 50, 130, 30);
        buttonPanel.add(btn4x4);

        JButton btn5x5 = new JButton("5x5");
        btn5x5.setBackground(Color.WHITE);
        btn5x5.setBounds(0, 100, 130, 30);
        buttonPanel.add(btn5x5);

        leftPanel.add(buttonPanel);

        add(leftPanel, BorderLayout.WEST);

        // Right 패널 생성
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setPreferredSize(new Dimension(400, 400));
        rightPanel.setLayout(new BorderLayout());

        JButton openButton = new JButton("Open");
        openButton.setBackground(Color.BLACK);
        openButton.setForeground(Color.WHITE);
        openButton.setPreferredSize(new Dimension(100, 50)); // 버튼의 크기를 수동으로 조절
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(StartWindow.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("File path selected: " + imagePath);
                    updatePreviewImage();
                }
            }
        });
        rightPanel.add(openButton, BorderLayout.CENTER);

        previewLabel = new JLabel();
        previewLabel.setHorizontalAlignment(JLabel.CENTER);
        previewLabel.setPreferredSize(new Dimension(300, 300));
        rightPanel.add(previewLabel, BorderLayout.NORTH);

        add(rightPanel, BorderLayout.EAST);

        btn3x3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imagePath != null && !imagePath.isEmpty()) {
                    dispose();
                    new GameWindow(3, imagePath, StartWindow.this);
                } else {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image Not Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btn4x4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imagePath != null && !imagePath.isEmpty()) {
                    dispose();
                    new GameWindow(4, imagePath, StartWindow.this);
                } else {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image Not Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btn5x5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imagePath != null && !imagePath.isEmpty()) {
                    dispose();
                    new GameWindow(5, imagePath, StartWindow.this);
                } else {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image Not Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    private void updatePreviewImage() {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            previewLabel.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StartWindow startWindow = new StartWindow();
                startWindow.setVisible(true);
            }
        });
    }
}

