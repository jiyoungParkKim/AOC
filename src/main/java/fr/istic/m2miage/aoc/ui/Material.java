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
	
	static Beeper getBeeper(){
		return new BeeperImpl();
	}
	
	static Display getDisplay(){
		return new DisplayImpl();
	}

}
