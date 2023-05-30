import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
	 public JLabel timerLabel2, timerLabel3;
     public Timer timer;
     public int seconds;
	 public JLabel timerLabel; 
	 public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
		}
	 public void run() {
		int n=0; 
		while(true) { 
			timerLabel.setText(Integer.toString(n)); 
			n++; 
			try {
				Thread.sleep(1000); // 1초 동안 잠을 잔다.
				}
			catch(InterruptedException e) {
				return; // 예외가 발생하면 스레드 종료
				}
			
			}
		}
	 
	}

    
