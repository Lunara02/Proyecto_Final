package GUI;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * La clase Musica se encarga de reproducir y detener música de fondo en formato WAV.
 * Utiliza el patrón Singleton para asegurarse de que solo haya una instancia de Musica en toda la aplicación.
 *
 * @author Sebastian Ignacio Vega Varela
 */
public class Musica {
    private Clip clip;
    private static Musica instance;

    /**
     * Método que reproduce un archivo de música en formato WAV.
     * @param s El nombre del archivo de música (sin la extensión .wav).
     */
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

    /**
     * Método que detiene la reproducción de la música y cierra el clip de audio.
     */
    public void stopMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }


    /**
     * Obtiene la única instancia de la clase Musica.
     * Utiliza el patrón Singleton.
     * @return La instancia única de Musica.
     */
    public static Musica getInstance() {
        if (instance == null) {
            instance = new Musica();
        }
        return instance;
    }
}