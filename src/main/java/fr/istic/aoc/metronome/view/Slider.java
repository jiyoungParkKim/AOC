package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.observer.Subject;

/**
 * Slider interface for show the position of the BPM or the Measure. 
 * This interface extends Subject interface for acting as a subject.
 * @author Jiyoung Park
 *
 */
public interface Slider extends Subject{
	double getPosition();
	void setPosition(double position);
	void speedUp();
	void speedDown();
}
