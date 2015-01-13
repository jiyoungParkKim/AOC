package fr.istic.aoc.metronome.adapter;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.material.Horloge;
import fr.istic.aoc.metronome.ui.Timer;

public class HorlogeAdapter implements Horloge {
	
	private Timer timer;
	public HorlogeAdapter(Timer timer){
		this.timer = timer;
	}

	@Override
	public void activatePeriodically(Command c, int delayInSeconds) {
		timer.activatePeriodically(c, delayInSeconds);
	}

	@Override
	public void activateAfterDelay(Command c, int delayInSeconds) {
		timer.activateAfterDelay(c, delayInSeconds);
	}

	@Override
	public void disable(Command c) {
		timer.disable(c);
	}

}
