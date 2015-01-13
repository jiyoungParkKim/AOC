package fr.istic.aoc.metronome;

import fr.istic.aoc.metronome.command.BpmEventCmd;
import fr.istic.aoc.metronome.command.MeasureChangedCmd;
import fr.istic.aoc.metronome.observer.Subject;

/**
 * Base Moteur interface acting as a Subject
 * @author Jiyoung Park
 *
 */
public interface ME extends Subject{
	
	/**
	 * Sets the running flag to perform the tick method whether the flag is true.
	 * @param flag
	 */
	void setRunning(boolean flag);

	/**
	 * Sets the BPM value and executes BeatsChangedCmd command to update related JavaFX's Text component
	 * If the isRunning flag is true then the tick method will be executed periodically with the new bpm
	 * @param bpm
	 */
	void setBPM(int bpm);

	int getBPM();

	int getMeasure();

	/**
	 * Sets the Measure value and executes {@link MeasureChangedCmd} command to update related JavaFX's Text component
	 * @param measure
	 */
	void setMeasure(int measure);

	void inc();

	void dec();

	/**
	 * Executes the {@link BpmEventCmd} and {@link BarEventCmd} periodically
	 */
	void tick();

}
