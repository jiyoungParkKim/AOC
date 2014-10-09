package fr.istic.m2miage.aoc;

import fr.istic.m2miage.aoc.ctl.Controller;
import fr.istic.m2miage.aoc.me.Engine;
import fr.istic.m2miage.aoc.me.EngineImpl;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		// create controller
		Controller ctl = new Controller();
		// set beat & bar
		ctl.setBeat(130);
		ctl.setBar(4);
		// start metronome
		ctl.getView().getStartBtn().click();
		
		// wait 10 seconds
		Thread.sleep(20000);
		
		// stop metronome
		ctl.getView().getStopBtn().click();
		
		
		// change slider
		ctl.moveSlider(0.7);
		// start metronome
		ctl.getView().getStartBtn().click();
		// wait 10 seconds
		Thread.sleep(20000);
		// stop metronome
		ctl.getView().getStopBtn().click();
		
		
	}
}
