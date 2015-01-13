package fr.istic.aoc.metronome;

import org.junit.Assert;
import org.junit.Test;

import fr.istic.aoc.metronome.command.BpmEventCmd;
import fr.istic.aoc.metronome.command.MeasureChangedCmd;
import fr.istic.aoc.metronome.command.MeasureEventCmd;
import fr.istic.aoc.metronome.command.StartCmd;

public class MeImplTest extends ControllerTest{

	@Test
	public void testSetRunning() {
		Assert.assertEquals(false, me.isRunning());
		view.getStartBtn().click();
		Assert.assertEquals(true, me.isRunning());
		view.getStopBtn().click();
		Assert.assertEquals(false, me.isRunning());
	}

	@Test(expected=ConfigurationException.class)
	public void testRegister() throws ConfigurationException {
		me.register(new StartCmd(ctl));// StartCmd is not the Observer command
		me.register(new MeasureChangedCmd(ctl));
		me.register(new BpmEventCmd(ctl));
		me.register(new MeasureEventCmd(ctl));
	}
}
