package fr.istic.aoc.metronome.observer;

import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.command.Command;

/**
 * Subject interface
 * @author Jiyoung Park
 *
 */
public interface Subject {
	void register(Command cmd) throws ConfigurationException;
	void unRegister(Command cmd) throws ConfigurationException;
}
