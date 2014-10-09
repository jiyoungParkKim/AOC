package fr.istic.m2miage.aoc.command;

import fr.istic.m2miage.aoc.ctl.Controller;

public class SliderChangedCmd implements Command{
	private Controller ctl;
	public SliderChangedCmd(Controller ctl) {
		this.ctl = ctl;
	}

	public void execute() {
		ctl.sliderChanged();
	}
}
