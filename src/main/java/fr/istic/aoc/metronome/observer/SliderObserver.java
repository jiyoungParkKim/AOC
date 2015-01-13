package fr.istic.aoc.metronome.observer;

/**
 * Observer interface to observe the slider objects.
 * @author Jiyoung Park
 *
 */
public interface SliderObserver extends Observer{
	/**
	 * Calls ME's setBPM method to :
	 *   1. change the bpm value
	 *   2. executes registered BpmChangedCmd (as a Observer) to signal the change to Controller
	 *   3. change timer's duration if the 'running' status is true
	 */
	void bpmSliderChanged();
	
	/**
	 * Calls ME's setMeasure method to :
	 *   1. change the measure value
	 *   2. executes registered MeasureChangedCmd (as a Observer) to signal the change to Controller
	 */
	void measureSliderChanged();
}
