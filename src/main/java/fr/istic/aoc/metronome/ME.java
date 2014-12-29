package fr.istic.aoc.metronome;

import fr.istic.aoc.metronome.observer.Subject;

/**
 * Metronome Engine's Interface. This class is a Subject also.
 * @author Jiyoung Park
 *
 */
public interface ME extends Subject{

	/**
	 * Sets the isRunning flag. 
	 * IF isRunning field of the MEImpl class is true then executes tick method periodically.
	 * 
	 * <dt><b>Precondition:</b><dd>
	 * MEImpl's beats value must be grater than 0.
	 * @param running
	 * The boolean that signifies the Metronome is running or not.
	 */
	void setRunning(boolean running);

	/**
	 * Increase the BPM value by 5.
	 */
	void speedUp();
	
	/**
	 * Decrease the BPM value by 5.
	 */
	void speedDown();

	/**
	 * Sets the BPM value and executes BeatsChangedCmd command to update related JavaFX's Text component
	 * If the isRunning flag is true then the tick method will be executed periodically with new bpm
	 * @param bpm
	 */
	void setBeats(int bpm);

	/**
	 * Sets the Bar value and executes BarChangedCmd command to update related JavaFX's Text component
	 * @param bar
	 */
	void setBar(int bar);

	int getBeats();

	int getBar();

	/**
	 * If the isRunning is true then executes BeatEventCmd and barEventCmd
	 */
	void tick();

}
