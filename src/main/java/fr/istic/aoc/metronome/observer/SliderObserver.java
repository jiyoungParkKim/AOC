package fr.istic.aoc.metronome.observer;

public interface SliderObserver {
	
	/**
	 * Calls ME's setBeats method to :
	 *   1. change the beats value
	 *   2. executes registered BeatsChangedCmd (as a Observer) to signal the change to Controller
	 *   3. change timer's duration if the 'isRunning' status is true
	 */
	void beatsSliderChanged();
	
	/**
	 * Calls ME's setBeats method to :
	 *   1. change the bar value
	 *   2. executes registered BarChangedCmd (as a Observer) to signal the change to Controller
	 */
	void barSliderChanged();
}
