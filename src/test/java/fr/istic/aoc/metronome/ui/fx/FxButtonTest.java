package fr.istic.aoc.metronome.ui.fx;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.istic.aoc.metronome.ControllerTest;
import fr.istic.aoc.metronome.command.StartCmd;
import fr.istic.aoc.metronome.ui.Button;

public class FxButtonTest extends ControllerTest{

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFxButton() {
		Button startBtn = new FxButton(mock.getStartBtn());
		startBtn.setCommand(new StartCmd(ctl));
		startBtn.click();
		Assert.assertTrue(me.isRunning());
	}

	@Test
	public void testGetFxComponent() {
		FxButton startBtn = new FxButton(mock.getStartBtn());
		Assert.assertEquals(mock.getStartBtn(), startBtn.getFxComponent());
	}

}
