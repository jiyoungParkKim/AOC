package fr.istic.aoc.metronome.observer;

import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.command.Command;
/**
 * Subject interface
 * @author Jiyoung Park
 *
 */
public interface Subject {
	Subject registerObserver(Command observer) throws ConfigurationException;
	void unregisterObserver(Command observer) throws ConfigurationException;
}
