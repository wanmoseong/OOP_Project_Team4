package TeamProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;
// import javax.swing.*; 로 간단하게 가능

public class StartWindow extends JFrame {
    private String imagePath;
    private JLabel previewLabel;
    private int level;
    public static BgMusic bgmusic;
    private BgVolumeSlider volumeSlider;

    public StartWindow() {
        {
            loadAudio();
            startAudio();
        }

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
        shapePanel.setLayout(null);
        shapePanel.setBounds(0, 0, 700, 450);

        JButton btn3x3 = new JButton("3x3");
        btn3x3.setBackground(Color.WHITE);
        btn3x3.setBounds(140, 165, 150, 30);
        shapePanel.add(btn3x3);

        JButton btn4x4 = new JButton("4x4");
        btn4x4.setBackground(Color.WHITE);
        btn4x4.setBounds(140, 215, 150, 30);
        shapePanel.add(btn4x4);

        JButton btn5x5 = new JButton("5x5");
        btn5x5.setBackground(Color.WHITE);
        btn5x5.setBounds(140, 265, 150, 30);
        shapePanel.add(btn5x5);


        JButton topButton = new JButton("상");
        topButton.setBackground(Color.WHITE);
        topButton.setBounds(200,105,50,30);
        shapePanel.add(topButton);

        JButton middleButton = new JButton("중");
        middleButton.setBackground(Color.WHITE);
        middleButton.setBounds(260,105,50,30);
        shapePanel.add(middleButton);

        JButton bottomButton = new JButton("하");
        bottomButton.setBackground(Color.WHITE);
        bottomButton.setBounds(320,105,50,30);
        shapePanel.add(bottomButton);

        leftPanel.add(shapePanel);

        add(leftPanel, BorderLayout.WEST);

        BgVolumeSlider volumeSlider = new BgVolumeSlider();
        leftPanel.add(volumeSlider);
        volumeSlider.setBounds(100,320,200,50);
        volumeSlider.setBgMusic(bgmusic);

        // Right 패널 생성
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setPreferredSize(new Dimension(400, 400));
        rightPanel.setLayout(new BorderLayout());

        JButton openButton = new JButton("Open");
        openButton.setBackground(Color.BLACK);
        openButton.setForeground(Color.WHITE);
        openButton.setPreferredSize(new Dimension(100 , 50)); // 버튼의 크기를 수동으로 조절
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image File", "jpg","png"));
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
                if (imagePath != null &&level!=0) {
                    dispose();
                    new GameWindow(3, imagePath, StartWindow.this, level,bgmusic);
                }
                else if(imagePath != null&&level!=0) {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image Not Selected", JOptionPane.WARNING_MESSAGE);
                }
                else if(imagePath != null && level ==0) {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please set the game level", "Level Not Selected" , JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image and Level Not Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btn4x4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imagePath != null && level!=0) {
                    dispose();
                    new GameWindow(4, imagePath, StartWindow.this, level,bgmusic);
                }
                else if(imagePath != null&&level!=0) {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image Not Selected", JOptionPane.WARNING_MESSAGE);
                }
                else if(imagePath != null&& level ==0) {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please set the game level", "Level Not Selected" , JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image and Level Not Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btn5x5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imagePath != null&&level!=0) {
                    dispose();
                    new GameWindow(5, imagePath, StartWindow.this, level,bgmusic);
                }
                else if(imagePath != null&&level!=0) {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image Not Selected", JOptionPane.WARNING_MESSAGE);
                }
                else if(imagePath != null&& level ==0) {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please set the game level", "Level Not Selected" , JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(StartWindow.this, "Please select an image first.",
                            "Image and Level Not Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        //마우스리스너
        topButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("The top button has been clicked.");
                level = 3;
                // 여기에 상 버튼 클릭 시 동작하는 내용을 추가
            }
        });

        middleButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("The middle button has been clicked");
                level = 2;
                // 여기에 중 버튼 클릭 시 동작하는 내용을 추가
            }
        });

        bottomButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("The bottom button has been clicked");
                level = 1;
                // 여기에 하 버튼 클릭 시 동작하는 내용을 추가
            }
        });

        setVisible(true);
    }
    public void loadAudio() {
        String audioFilePath = "audio/SSKirby.wav";
        bgmusic = new BgMusic(audioFilePath);

    }

    public void startAudio() {
        if (bgmusic != null) {
            bgmusic.play();
        }
    }

    public void stopAudio() {
        if (bgmusic != null) {
            bgmusic.stop();
        }
    }
    public void adjustVolume(int volume) {
        if (bgmusic != null) {

        }
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
}
