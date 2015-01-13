package fr.istic.aoc.metronome.material;

/**
 * Clavier interface
 * @author Jiyoung Park
 *
 */
public interface Clavier {
	/**
	 * Returns true if the button number is pressed, false if it is released.
	 * @param number n° : Start, n°2 : stop, n°3 : INC and n°4 : DEC
	 * @return return true if the button number is pressed
	 */
	boolean touchePressed(int number);
	
}
