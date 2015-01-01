package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.observer.Subject;
/**
 * LED interface to execute the flash method. 
 * This interface extends Subject interface for acting as a subject.
 * @author Jiyoung Park
 *
 */
public interface LED extends Subject{
	
	/**
	 * Flash the led.
	 */
	void flash();
}
