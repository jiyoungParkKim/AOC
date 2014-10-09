package fr.istic.m2miage.aoc.ctl;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	private Controller ctl;
	
	@Before
	public void setup(){
		ctl = new Controller();
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
