package fr.istic.aoc.metronome.adapter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.Controller;
import fr.istic.aoc.metronome.JavaFXThreadingRule;
import fr.istic.aoc.metronome.MeImpl;
import fr.istic.aoc.metronome.MockComponentsInitializer;
import fr.istic.aoc.metronome.anti_adapter.ButtonAdapter;
import fr.istic.aoc.metronome.command.DecCmd;
import fr.istic.aoc.metronome.command.IncCmd;
import fr.istic.aoc.metronome.command.StartCmd;
import fr.istic.aoc.metronome.command.StopCmd;
import fr.istic.aoc.metronome.ui.ButtonType;

public class ClavierAdapterTest {
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
		
		Assert.assertEquals(defaultBpm, ctl.getView().getBpmSlider().getPosition()*250, 0);
		Assert.assertEquals(defaultBpm, ctl.getMe().getBPM());
		// increase by 1 bpm
		incBtn.click();
		
		
		// we need wait to obtain the right value
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(
		        Duration.millis(200),
		        ae -> testBpm(defaultBpm+1)));
		timeline.play();
	
		
		fr.istic.aoc.metronome.ui.Button decBtn = new ButtonAdapter(ButtonType.INC, fxBtn);
		decBtn.setCommand(new DecCmd(ctl));
		// decrease by 1 bpm
		decBtn.click();
		
		Assert.assertEquals(defaultBpm, ctl.getMe().getBPM());
		Assert.assertEquals(defaultBpm, ctl.getView().getBpmSlider().getPosition()*250, 0);
	}
	
	private void testBpm(int expectedBpm){
		Assert.assertEquals(expectedBpm, ctl.getMe().getBPM());		
		Assert.assertEquals(expectedBpm, ctl.getView().getBpmSlider().getPosition()*250, 0);	
	}

}
