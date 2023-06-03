import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLabel extends JPanel {
    private JLabel timeLabel;
    private Thread th;
    private JButton startButton;

    public TimerLabel() {
        JLabel timerLabel3 = new JLabel("걸린 시간: ");
        JLabel timerLabel2 = new JLabel("초");
        timeLabel = new JLabel();
        startButton = new JButton("시작");

        TimerRunnable runnable = new TimerRunnable(timeLabel);
        th = new Thread(runnable); // 스레드 생성

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimer(); // 시작 버튼 클릭 시 타이머 시작
            }
        });

        add(timerLabel3);
        add(timeLabel);
        add(timerLabel2);
        add(startButton);
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void startTimer() {
        if (!th.isAlive()) {
            th = new Thread(new TimerRunnable(timeLabel)); // 새로운 타이머 스레드 생성
            th.start(); // 타이머 스레드 시작
        }
    }

    public void resetTimer() {
        if (th != null && th.isAlive()) {
            th.interrupt(); // 기존의 타이머 스레드 중단
        }
        timeLabel.setText(""); // 타이머 레이블 초기화
    }
}
