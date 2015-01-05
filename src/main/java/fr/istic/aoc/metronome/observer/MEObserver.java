package fr.istic.aoc.metronome.observer;

public interface MEObserver {
	/**
	 * This method is called whenever the beats field of the MEImpl class is changed
	 * to update the bpm value on the UI component 
	 */
	void bpmChanged();
	
	/**
	 * This method is called whenever the bar field of the MEImpl class is changed
	 * Updates the bar value on the UI component 
	 */
	void measureChanged();
	
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
	void handleBpmEvent();
	
	/**
	 * Flashes LED2 and gives a beep for Bar (Measure)
	 */
	void handleMeasureEvent();
	
	/**
	 * Decrease the bpm value of the relative slider and Metronome Engine respectively.
	 */
	void inc();
	
	/**
	 * Increase the bpm value of the relative slider and Metronome Engine respectively.
	 */
	void dec();
}
