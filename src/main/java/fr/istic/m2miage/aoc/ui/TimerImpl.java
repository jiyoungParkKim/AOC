package fr.istic.m2miage.aoc.ui;

import fr.istic.m2miage.aoc.command.Command;

public class TimerImpl implements Timer{
	private java.util.Timer timer;
	public void activatePeriodically(final Command c, int delayInSeconds) {
		timer = new java.util.Timer();
		timer.scheduleAtFixedRate(new java.util.TimerTask() {
			@Override
			public void run() {
				c.execute();
			}
		}, 0, delayInSeconds);
		
	}

	public void activateAfterDelay(Command c, int delayInSeconds) {
		// TODO Auto-generated method stub
		
	}

	public void disable(Command c) {
		timer.cancel();
		c.execute();
	}

}
