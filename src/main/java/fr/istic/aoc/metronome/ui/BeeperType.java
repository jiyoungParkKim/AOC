package fr.istic.aoc.metronome.ui;

public enum BeeperType {
	BEEP1(0), BEEP2(1);

	int value;
	private BeeperType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
