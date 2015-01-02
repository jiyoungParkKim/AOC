package fr.istic.aoc.metronome.view;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Implementation of the Beeper interface.
 * @author Jiyoung Park
 *
 */
public class BeeperImpl implements Beeper{
	URL url = null;
    Clip clip;
    AudioInputStream audioIn;
    
    /**
     * Constructor of this class. 
     * @param path
     * AudioIn resource path
     */
	public BeeperImpl(String path){
		try {
			audioIn = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(path));
			// Get a sound clip resource.
	        clip = AudioSystem.getClip();
	        // Open audio clip and load samples from the audio input stream.
	        clip.open(audioIn);
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public synchronized void beep() {
		if (clip.isRunning()) {
			clip.stop();
		}
		clip.setFramePosition(0);
		clip.start();
	}
}
