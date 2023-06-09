import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class BgVolumeSlider extends JPanel {
    private JSlider volumeSlider;
    private BgMusic bgmusic;

    public BgVolumeSlider() {
        setLayout(new FlowLayout());

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        volumeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int volume = volumeSlider.getValue();
                adjustVolume(volume);
            }
        });

        add(volumeSlider);
    }

    public void setBgMusic(BgMusic bgmusic) {
        this.bgmusic = bgmusic;
    }

    private void adjustVolume(int volume) {
        if (bgmusic != null) {
            bgmusic.adjustVolume(volume);
        }
    }
}

