import java.awt.*;
import javax.swing.*;

public class mainPuzzle extends JFrame {
    private JPanel p_right;

    public mainPuzzle() {
        setTitle("Team4 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);

        Container c = getContentPane();

        JPanel p_body = new JPanel(); // 가운데
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
        
        String imagePath = "./pic/Luffy.jpg"; // 실제 이미지 파일
        addImageToPanel(imagePath);
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
