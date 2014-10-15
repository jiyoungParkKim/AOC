package fr.istic.m2miage.aoc.ui;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BarBeeper implements Beeper{
	public void beepClick() {
		System.out.println("Bar!  ");
		URL url = this.getClass().getClassLoader().getResource("PingHi.wav");
        AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
	        Clip clip = AudioSystem.getClip();
	        // Open audio clip and load samples from the audio input stream.
	        clip.open(audioIn);
	        clip.start();
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}

}
