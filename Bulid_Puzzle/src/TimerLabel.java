import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerLabel extends JPanel {
	private JLabel timeLabel;
	public Thread th;
	public int sec;

	public TimerLabel() {
		JLabel timerLabel3 = new JLabel("걸린 시간: ");
		JLabel timerLabel2 = new JLabel("초");
		timeLabel = new JLabel();

		TimerRunnable runnable = new TimerRunnable(timeLabel);
		th = new Thread(runnable); // 스레드 생성
		
		sec = runnable.n;
		th.start(); // 스레드 동작시킴

		add(timerLabel3);
		add(timeLabel);
		add(timerLabel2);
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void resetTimer() {
		if (th != null && th.isAlive()) {
			th.interrupt(); // 기존의 타이머 스레드 중단
		}
		th = new Thread(new TimerRunnable(timeLabel)); // 새로운 타이머 스레드 생성
		th.start(); // 새로운 타이머 스레드 시작
	}

}
