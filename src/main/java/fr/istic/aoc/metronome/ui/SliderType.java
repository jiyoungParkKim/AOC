package fr.istic.aoc.metronome.ui;

/**
 * Enumeration for the Slider type.
 * Provides 2 types : BPM and MEASURE
 * @author Jiyoung Park
 *
 */
public enum SliderType {
	BPM(0), MEASURE(1);
	
	private int value;
	private SliderType(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
