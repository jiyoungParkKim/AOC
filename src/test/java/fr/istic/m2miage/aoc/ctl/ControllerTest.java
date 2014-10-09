package fr.istic.m2miage.aoc.ctl;

import org.junit.Before;
import org.junit.Test;

import fr.istic.m2miage.aoc.me.Engine;
import fr.istic.m2miage.aoc.me.EngineImpl;

public class ControllerTest {
	private Controller ctl;
	private Engine eg;
	
	@Before
	public void setup(){
		eg = new EngineImpl();
		ctl = new Controller(eg);
	}

	@Test
	public void setBeat(){
		ctl.setBeat(130);
		ctl.setBar(4);
		ctl.getView().getStartBtn().click();
		System.out.println("");
	}
	
	@Test
	public void sliderChange(){
		ctl.getView().getSlider().moveSlider(0.5);
	}
}
