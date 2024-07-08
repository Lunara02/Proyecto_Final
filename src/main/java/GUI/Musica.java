package GUI;

import javax.sound.sampled.*;
import java.io.IOException;

public class Musica {
    private Clip clip;
    private static Musica instance;
    public void playMusica(String s) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(s + ".wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void stopMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
    public static Musica getInstance() {
        if (instance == null) {
            instance = new Musica();
        }
        return instance;
    }
}