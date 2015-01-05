package fr.istic.aoc.metronome.ui;

/**
 * Enumeration for the Display type.
 * Provides 3 types : BPMText and MeasureText and TempoName.
 * @author Jiyoung Park
 *
 */
public enum DisplayType {
	BPMText(0), MeasureText(1), TempoName(2);
	
	int value;
	private DisplayType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
