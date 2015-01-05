package fr.istic.aoc.metronome.ui;

/**
 * Enumeration for the LED type.
 * Provides 2 types : BPMLED and MeasureLED.
 * @author Jiyoung Park
 *
 */
public enum LEDType {
	BPMLED(0), MeasureLED(1);
	
	int value;
	private LEDType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
