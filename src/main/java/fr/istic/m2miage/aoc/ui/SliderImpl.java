package fr.istic.m2miage.aoc.ui;

import fr.istic.m2miage.aoc.command.Command;

public class SliderImpl implements Slider{
	private double position;
	private Command sliderChangedCmd;
	
	public void setSliderChangedCmd(Command c) {
		this.sliderChangedCmd = c;
	}

	public double position() {
		return position;
	}

	@Override
	public void moveSlider(double position) {
		this.position = position;
		this.sliderChangedCmd.execute();
		
	}
}
