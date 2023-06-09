import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BgMusic {
    private Clip clip;
    

    public BgMusic(String audioFilePath) {
        try {
            // 오디오 파일 로드
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath));

            // 오디오 포맷 가져오기
            AudioFormat format = audioInputStream.getFormat();

            // 데이터 라인 정보 설정
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // 데이터 라인 열기
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            // 무한 반복 설정
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // 재생 시작
            clip.start();
        }
    }
    
    public void playClear() {
    	if (clip!= null) {
    		clip.start();
    	
    	}
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            // 재생 중지
            clip.stop();
            System.out.println("Stop audio");
        }
    }
    public void adjustVolume(int volume) {
        if (clip != null) {
            try {
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float volumeDB = (float) (Math.log10(volume / 100.0) * 20);
                gainControl.setValue(volumeDB);
            } catch (Exception ex) {
                ex.printStackTrace();
            
        }
    }
    }
}
    
 
