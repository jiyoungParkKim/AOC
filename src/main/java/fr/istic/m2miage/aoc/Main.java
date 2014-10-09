package fr.istic.m2miage.aoc;

import fr.istic.m2miage.aoc.ctl.Controller;
import fr.istic.m2miage.aoc.me.Engine;
import fr.istic.m2miage.aoc.me.EngineImpl;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		Engine eg = new EngineImpl();
		Controller ctl = new Controller(eg);
		
		ctl.setBeat(130);
		ctl.setBar(4);
		ctl.getView().getStartBtn().click();
		
		
		Thread.sleep(10000);
		
		ctl.getView().getStopBtn().click();
		
		
	}
}
