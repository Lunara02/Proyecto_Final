package GUI;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * La clase Sonido permite reproducir archivos de sonido en formato WAV.
 */
public class Sonido {
    private Clip clip;

    /**
     * Reproduce un archivo de sonido.
     * @param s el nombre del archivo de sonido
     */
    public void playSonido(String s) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(s + ".wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}