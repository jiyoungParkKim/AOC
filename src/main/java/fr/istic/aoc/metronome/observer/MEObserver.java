package fr.istic.aoc.metronome.observer;

/**
 * A class can implement the MEObserver interface when it wants to be informed of changes in the ME type classes. 
 * This interface acts as a observer for ME implementations
 * @author Jiyoung Park
 *
 */
public interface MEObserver {
	
	/**
	 * This method is called whenever the beats field of the MEImpl class is changed
	 * to update the bpm value on the UI component 
	 */
	void beatsChanged();
	
	/**
	 * This method is called whenever the bar field of the MEImpl class is changed
	 * Updates the bar value on the UI component 
	 */
	void barChanged();
	
	/**
	 * This method is called whenever the bar field of the MEImpl class is changed
	 * Updates the bar value on the UI component  Starts the metronome.
	 */
	void start();
	
	/**
	 * Stops the metronome.
	 */
	void stop();
	
	/**
	 * Flashes LED1 and gives a beep for Beats (BPM)
	 */
	void handleBeatEvent();
	
	/**
	 * Flashes LED2 and gives a beep for Bar (Measure)
	 */
	void handleBarEvent();
	
	/**
	 * Decrease the bpm value of the relative slider and Metronome Engine respectively.
	 */
	void speedDown();
	
	/**
	 * Increase the bpm value of the relative slider and Metronome Engine respectively.
	 */
	void speedUp();
}
