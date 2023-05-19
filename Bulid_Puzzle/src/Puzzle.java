import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Puzzle extends JFrame implements ActionListener {
    MyButton[] buttons;
    MyButton reset;

    public Puzzle() {
        super("puzzle");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 4, 2, 2));
        buttons = new MyButton[16];
        for (int i = 0; i < 15; i++)
            buttons[i] = new MyButton("" + (i + 1));
        buttons[15] = new MyButton(" ");
        for (int i = 0; i < 16; i++)
            panel.add(buttons[i]);
        for (int i = 0; i < 16; i++)
            buttons[i].addActionListener(this);
        add(panel, BorderLayout.CENTER);
        reset = new MyButton("reset");
        reset.setBackground(Color.red);
        reset.setForeground(Color.yellow);
        add(reset, BorderLayout.SOUTH);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        MyButton b = (MyButton) e.getSource();
        if (b.getText().equals(" ") == true) return;
        if (b.index == 0) {
            if (buttons[1].getText().equals(" ")) {
                buttons[1].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[4].getText().equals(" ")) {
                buttons[4].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 1) {
            if (buttons[0].getText().equals(" ")) {
                buttons[0].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[2].getText().equals(" ")) {
                buttons[2].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[5].getText().equals(" ")) {
                buttons[5].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 2) {
            if (buttons[1].getText().equals(" ")) {
                buttons[1].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[3].getText().equals(" ")) {
                buttons[3].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[6].getText().equals(" ")) {
                buttons[6].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 3) {
            if (buttons[2].getText().equals(" ")) {
                buttons[2].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[7].getText().equals(" ")) {
                buttons[7].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 4) {
            if (buttons[0].getText().equals(" ")) {
                buttons[0].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[5].getText().equals(" ")) {
                buttons[5].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[8].getText().equals(" ")) {
                buttons[8].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 5) {
            if (buttons[1].getText().equals(" ")) {
                buttons[1].setText(b.getText());
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
            if (buttons[9].getText().equals(" ")) {
                buttons[9].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 6) {
            if (buttons[2].getText().equals(" ")) {
                buttons[2].setText(b.getText());
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
            if (buttons[10].getText().equals(" ")) {
                buttons[10].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 7) {
            if (buttons[3].getText().equals(" ")) {
                buttons[3].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[6].getText().equals(" ")) {
                buttons[6].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[11].getText().equals(" ")) {
                buttons[11].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 8) {
            if (buttons[4].getText().equals(" ")) {
                buttons[4].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[9].getText().equals(" ")) {
                buttons[9].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[12].getText().equals(" ")) {
                buttons[12].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 9) {
            if (buttons[5].getText().equals(" ")) {
                buttons[5].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[8].getText().equals(" ")) {
                buttons[8].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[10].getText().equals(" ")) {
                buttons[10].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[13].getText().equals(" ")) {
                buttons[13].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 10) {
            if (buttons[6].getText().equals(" ")) {
                buttons[6].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[9].getText().equals(" ")) {
                buttons[9].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[11].getText().equals(" ")) {
                buttons[11].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[14].getText().equals(" ")) {
                buttons[14].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 11) {
            if (buttons[7].getText().equals(" ")) {
                buttons[7].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[10].getText().equals(" ")) {
                buttons[10].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[15].getText().equals(" ")) {
                buttons[15].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 12) {
            if (buttons[8].getText().equals(" ")) {
                buttons[8].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[13].getText().equals(" ")) {
                buttons[13].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 13) {
            if (buttons[9].getText().equals(" ")) {
                buttons[9].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[12].getText().equals(" ")) {
                buttons[12].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[14].getText().equals(" ")) {
                buttons[14].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 14) {
            if (buttons[10].getText().equals(" ")) {
                buttons[10].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[13].getText().equals(" ")) {
                buttons[13].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[15].getText().equals(" ")) {
                buttons[15].setText(b.getText());
                b.setText(" ");
            }
        }
        if (b.index == 15) {
            if (buttons[11].getText().equals(" ")) {
                buttons[11].setText(b.getText());
                b.setText(" ");
            }
            if (buttons[14].getText().equals(" ")) {
                buttons[14].setText(b.getText());
                b.setText(" ");
            }
        }
    }

    class MyButton extends JButton {
        static int count = 0;
        int index;

        public MyButton(String s) {
            super(s);
            index = count++;
        }
    }
}