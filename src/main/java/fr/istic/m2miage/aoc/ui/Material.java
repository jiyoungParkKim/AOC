package fr.istic.m2miage.aoc.ui;

public class Material {
	
	static Timer getTimer(){
		return new TimerImpl();
	}
	
	static Keybord getKeybord(){
		return new KeybordImpl();
	}
	
	static Slider getSlider(){
		return new SliderImpl();
	}
	
	static Display getDisplay(){
		return new DisplayImpl();
	}

	public static Beeper getBeatBeeper() {
		return new BeatBeeper();
	}
	
	public static Beeper getBarBeeper() {
		return new BarBeeper();
	}

}
