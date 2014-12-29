package fr.istic.aoc.metronome;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.model.Statement;

public class EventHandlingControllerTest {
	
	@Rule public JavaFXThreadingRule javafxRule;
	
	@Before
	public void setup(){
		javafxRule = new JavaFXThreadingRule();
	}

	@Test
	public void testEventHandlingController() {
	}

	@Test
	public void testStart() {
		
	}

	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

	@Test
	public void testBeatsSliderChanged() {
		fail("Not yet implemented");
	}

	@Test
	public void testBarSliderChanged() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpeedUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpeedDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testBeatsChanged() {
		fail("Not yet implemented");
	}

	@Test
	public void testBarChanged() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleBeatEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleBarEvent() {
		fail("Not yet implemented");
	}

}
