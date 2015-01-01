package fr.istic.aoc.metronome;


/**
 * Exception thrown when configuration of a bean failed. Carries the original exception messages.
 * @author Jiyoung Park
 *
 */
public class ConfigurationException extends Exception {

	public ConfigurationException(String string) {
		super(string);
	}

}
