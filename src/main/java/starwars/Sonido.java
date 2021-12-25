package starwars;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sonido {
	public static Clip LoadSound(String direction) {
		try {
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(Sonido.class.getClassLoader().getResource(direction).getPath()));
	        DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
	        Clip clip = (Clip)AudioSystem.getLine(info);
	        clip.open(inputStream);
			return clip;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
