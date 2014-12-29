package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.observer.Subject;

public interface LED extends Subject{
	void flash();
}
