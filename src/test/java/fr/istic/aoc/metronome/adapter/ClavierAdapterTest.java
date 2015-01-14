package fr.istic.aoc.metronome.adapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.Controller;
import fr.istic.aoc.metronome.JavaFXThreadingRule;
import fr.istic.aoc.metronome.MeImpl;
import fr.istic.aoc.metronome.MockComponentsInitializer;
import fr.istic.aoc.metronome.anti_adapter.AdapterTestBase;
import fr.istic.aoc.metronome.anti_adapter.ButtonAdapter;
import fr.istic.aoc.metronome.command.DecCmd;
import fr.istic.aoc.metronome.command.IncCmd;
import fr.istic.aoc.metronome.command.StartCmd;
import fr.istic.aoc.metronome.command.StopCmd;
import fr.istic.aoc.metronome.ui.ButtonType;

public class ClavierAdapterTest extends AdapterTestBase{
	@Rule public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	private Controller ctl;
	private MockComponentsInitializer mock;
	
	@Before
	public void setup() throws ConfigurationException{
		mock = new MockComponentsInitializer();
		mock.initialize();
		ctl = mock.getCtl();
	}
	
	@Test
	public void testStartStopButton() {
		
		Assert.assertFalse(((MeImpl)ctl.getMe()).isRunning());
		
		javafx.scene.control.Button fxBtn = new javafx.scene.control.Button();
		fr.istic.aoc.metronome.ui.Button startBtn = new ButtonAdapter(ButtonType.START, fxBtn);
		startBtn.setCommand(new StartCmd(ctl));
		startBtn.click();
		
		Assert.assertTrue(((MeImpl)ctl.getMe()).isRunning());
		
		fr.istic.aoc.metronome.ui.Button stopBtn = new ButtonAdapter(ButtonType.STOP, fxBtn);
		stopBtn.setCommand(new StopCmd(ctl));
		stopBtn.click();
		
		Assert.assertFalse(((MeImpl)ctl.getMe()).isRunning());
	}
	
	@Test
	public void testIncDecButton(){
		
		int defaultBpm = 140;
		
		javafx.scene.control.Button fxBtn = new javafx.scene.control.Button();
		fr.istic.aoc.metronome.ui.Button incBtn = new ButtonAdapter(ButtonType.INC, fxBtn);
		incBtn.setCommand(new IncCmd(ctl));
		
		assertInTimeline(new TestAdapterCommand(defaultBpm));

		// increase by 1 bpm
		incBtn.click();
		
		assertInTimeline(new TestAdapterCommand(defaultBpm+1));
	
		
		fr.istic.aoc.metronome.ui.Button decBtn = new ButtonAdapter(ButtonType.INC, fxBtn);
		decBtn.setCommand(new DecCmd(ctl));
		// decrease by 1 bpm
		decBtn.click();
		
		Assert.assertEquals(defaultBpm, ctl.getMe().getBPM());
		Assert.assertEquals(defaultBpm, ctl.getView().getBpmSlider().getPosition()*250, 0);
	}
	
	@Override
	protected void doTest(double expectedValue) {
		Assert.assertEquals(expectedValue, ctl.getView().getBpmSlider().getPosition()*250, 0);	
	}

}
