package fr.istic.aoc.metronome.ui;

import fr.istic.aoc.metronome.observer.Subject;

/**
 * Interface for the Slider. This class acts like a Subject.
 * @author Jiyoung Park
 *
 */
public interface Slider extends Subject{
	double getPosition();
	void setPosition(int bpm);
}
