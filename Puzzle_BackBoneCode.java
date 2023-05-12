/****************/
/* BackBoneCode */
/****************/

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyButton extends JButton {
	static int count = 0;// 정적변수
	int index;
	public MyButton(String s) {
		super(s);// 조상클래스 생성자 호출
		index = count++;// 후행증가
	}// 생성자오버로딩
}// MyButton class

class Puzzle extends JFrame implements ActionListener {
	MyButton[] buttons;// 버튼배열 선언
	MyButton reset;
	public Puzzle() {
		super("퍼즐게임");// 조상클래스 생성자 호출해서 프레임윈도우창 제목설정
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 2, 2)); // 행은 가변적, 열개수는 3. 2, 2는 격자사이 간격
		buttons = new MyButton[9];// 배열크기가 9 버튼 배열생성
		
		for (int i = 0; i < 8; i++) {
			buttons[i] = new MyButton(" " + (i + 1));// 1부터 8까지 출력되는 버튼 캡션문자열 설정
		} // for

		buttons[8] = new MyButton(" ");// 마지막은 버튼은 공백처리
		
		for (int i = 0; i < 9; i++) {// 9개의 버튼을 패널에 추가
			panel.add(buttons[i]);
		}
		
		for (int i = 0; i < 9; i++) {// 9개의 버튼 이벤트 등록
			buttons[i].addActionListener(this);
		}

		add(panel, BorderLayout.CENTER);// 패널을 프레임 중앙에 배치
		reset = new MyButton("reset");
		reset.setBackground(Color.pink);// 버튼 배경색 설정
		reset.setForeground(Color.DARK_GRAY);// 버튼캡슐 문자열 글자색 설정
		reset.addActionListener(this);
		add(reset, BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 기본생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton b = (MyButton) e.getSource();
		if (b.getText().equals(" ") == true) {// 빈 버튼 누르면 아무 동작 안함
			return;// 이벤트 종료
// getText()메서드는 버튼위 캡션문자열을 가져옴.
// equals()는 객체주소가 다르고 내용물만 같아도 true를 반환
		} // if
		
		if (b.index == 0) {// 1번 버튼 눌렀을 때
			if (buttons[1].getText().equals(" ")) {// 2번 자리 캡션이 비어 있다면

// ==true가 생략 됨
				buttons[1].setText(b.getText());
// 2번쨰 버튼 캡션문자열을 첫번쨰 버튼캡션문자열로 설정
				b.setText(" ");
// 첫번째 버튼 캡션문자열을 빈공백으로 처리
			} // if

			if (buttons[3].getText().equals(" ")) {
				buttons[3].setText(b.getText());
				b.setText(" ");
			} // if
		} // 1번 버튼 눌렀을 때

		if (b.index == 1) {
			if (buttons[0].getText().equals(" ")) {
				buttons[0].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[2].getText().equals(" ")) {
				buttons[2].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(b.getText());
				b.setText(" ");
			}

		} // 2번 버튼 눌렀을 때

		if (b.index == 2) {// 3번 버튼 눌렀을 때
			if (buttons[1].getText().equals(" ")) {// 2번 자리 캡션이 비어 있다면
				buttons[1].setText(b.getText());
// 2번 자리에 1번 캡션을 넣고
				b.setText(" ");
// 1번 자리 캡션을 지운다.
// 즉 1번 버튼 눌렀을 때 2번자리가 비어있다면 그쪽으로 자리 바꿈.
			}

			if (buttons[5].getText().equals(" ")) {
				buttons[5].setText(b.getText());
				b.setText(" ");

			}

		} // 3번 버튼 눌렀을 때

		if (b.index == 3) {
			if (buttons[0].getText().equals(" ")) {
				buttons[0].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(b.getText());
				b.setText(" ");

			}

			if (buttons[6].getText().equals(" ")) {
				buttons[6].setText(b.getText());
				b.setText(" ");

			}

		} // 4번 버튼 눌렀을 때

		if (b.index == 4) {

			if (buttons[1].getText().equals(" ")) {
				buttons[1].setText(b.getText());
				b.setText(" ");

			}

			if (buttons[3].getText().equals(" ")) {
				buttons[3].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[5].getText().equals(" ")) {
				buttons[5].setText(b.getText());
				b.setText(" ");

			}
			if (buttons[7].getText().equals(" ")) {
				buttons[7].setText(b.getText());
				b.setText(" ");
			}

		} // 5번 버튼 눌렀을 때

		if (b.index == 5) {
			if (buttons[2].getText().equals(" ")) {
				buttons[2].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(b.getText());
				b.setText(" ");

			}

			if (buttons[8].getText().equals(" ")) {
				buttons[8].setText(b.getText());
				b.setText(" ");

			}

		} // 6번 버튼 눌렀을 때

		if (b.index == 6) {
			if (buttons[3].getText().equals(" ")) {
				buttons[3].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[7].getText().equals(" ")) {
				buttons[7].setText(b.getText());
				b.setText(" ");
			}

		} // 7번 버튼 눌렀을 때

		if (b.index == 7) {
			if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(b.getText());
				b.setText(" ");

			}

			if (buttons[6].getText().equals(" ")) {
				buttons[6].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[8].getText().equals(" ")) {
				buttons[8].setText(b.getText());
				b.setText(" ");
			}

		} //// 8번 버튼 눌렀을 때

		if (b.index == 8) {

			if (buttons[5].getText().equals(" ")) {
				buttons[5].setText(b.getText());
				b.setText(" ");
			}

			if (buttons[7].getText().equals(" ")) {
				buttons[7].setText(b.getText());
				b.setText(" ");
			}

		} // 9번 버튼 눌렀을 때

		if (b.getText().equals("reset")) {
			for (int i = 0; i < 8; i++) {
				buttons[i].setText("" + (i + 1));
			}
			buttons[8].setText(" ");
		}

	}

}

//main code
public class Puzzle_BackBoneCode {
	public static void main(String[] args) {
		new Puzzle();
	}
}
