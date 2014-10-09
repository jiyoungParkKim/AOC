package fr.istic.m2miage.aoc.ui;

import fr.istic.m2miage.aoc.command.Command;


public interface Slider{
	double position();
	void setSliderChangedCmd(Command sliderChangedCmd);
	void moveSlider(double position);
}
