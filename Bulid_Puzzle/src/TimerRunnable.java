import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
	public JLabel timerLabel2, timerLabel3;
	public Timer timer;
	public JLabel timerLabel;
	public int seconds;
	public int n = 0;
	
	public TimerRunnable() {}

	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void run() {
		while (true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000); // 1초 동안 잠을 잔다.
			} catch (InterruptedException e) {
				seconds = n;
				return; // 예외가 발생하면 스레드 종료
			}

		}
	}
	public int getSeconds() {
		return seconds;
	}

}
