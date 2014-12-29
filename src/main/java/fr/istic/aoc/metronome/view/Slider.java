package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.observer.Subject;

/**
 * This interface acts as a subject.
 * @author Jiyoung Park
 *
 */
public interface Slider extends Subject{
	double getPosition();
	void setPosition(double position);
	void speedUp();
	void speedDown();
}
