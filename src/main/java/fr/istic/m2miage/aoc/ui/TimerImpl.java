package fr.istic.m2miage.aoc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.istic.m2miage.aoc.command.Command;

public class TimerImpl implements Timer{
	private javax.swing.Timer timer;
	public void activatePeriodically(final Command c, final int delayInSeconds) {
		timer = new javax.swing.Timer(delayInSeconds, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	c.execute();
		    }    
		});
		timer.start();
	}

	public void activateAfterDelay(Command c, int delayInSeconds) {
		// TODO Auto-generated method stub
		
	}

	public void disable(Command c) {
		timer.stop();
		c.execute();
	}

}
