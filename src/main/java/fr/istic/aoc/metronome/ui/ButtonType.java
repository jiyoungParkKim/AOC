package fr.istic.aoc.metronome.ui;

/**
 * Enumeration for the Button type.
 * Provides 4 types : START, STOP, INC and DEC.
 * @author Jiyoung Park
 *
 */
public enum ButtonType {
	START(0), STOP(1), INC(2), DEC(3);

	int value;
	private ButtonType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
