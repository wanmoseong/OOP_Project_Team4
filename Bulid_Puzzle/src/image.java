package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class image extends JFrame {
	
    private JLabel imageLabel;
    private String AbsolutePath;		// 이미지의 절대경로

    public image(JPanel Right) {
        // 이미지를 표시할 JLabel 생성
        imageLabel = new JLabel();
        // 이미지를 가운데로 정렬
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // "열기" 버튼 생성
        JButton openButton = new JButton("열기");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 파일 선택 대화상자 열기
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image File", "jpg","png"));

                int result = fileChooser.showOpenDialog(image.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // 선택한 파일 가져오기
                    File selectedFile = fileChooser.getSelectedFile();
                    AbsolutePath = selectedFile.getAbsolutePath();
                    // 이미지 로드 및 JLabel에 표시
                    try {
                        // 선택한 이미지 파일을 읽어옴
                        BufferedImage originalImage = ImageIO.read(selectedFile);

                        // 프레임의 크기
                        int frameWidth = imageLabel.getWidth();
                        int frameHeight = imageLabel.getHeight();

                        // 이미지의 가로 너비
                        int imageWidth = originalImage.getWidth();
                        int imageHeight = originalImage.getHeight();

                        // 이미지를 프레임에 맞게 비율 조정
                        int scaledWidth, scaledHeight;
                        if (imageWidth > imageHeight) {
                            scaledWidth = frameWidth;
                            scaledHeight = (int) (((double) imageHeight / imageWidth) * frameWidth);
                        } else {
                            scaledHeight = frameHeight;
                            scaledWidth = (int) (((double) imageWidth / imageHeight) * frameHeight);
                        }

                        // 비율 조정된 이미지를 생성
                        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

                        // 조정된 이미지를 JLabel에 표시
                        ImageIcon icon = new ImageIcon(scaledImage);
                        imageLabel.setIcon(icon);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        
       
        openButton.setBounds(10, 10, 70, 30);
        // 프레임에 컴포넌트 추가
        Right.setLayout(new BorderLayout());
        Right.add(openButton);
        Right.add(imageLabel, BorderLayout.CENTER);

        // 프레임 표시
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    String getImageAbsolutePath() {
    	return AbsolutePath;
    }

}