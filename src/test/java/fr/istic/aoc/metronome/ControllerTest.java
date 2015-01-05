package fr.istic.aoc.metronome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.istic.aoc.metronome.ui.View;
import fr.istic.aoc.metronome.utils.Utils;

public class ControllerTest {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	protected MockComponentsInitializer mock;
	protected Controller ctl;
	protected View view;
	protected MeImpl me;
	protected int defaultBPM = 140;
	protected double maxBPM = 250.0;
	protected int defaultMeasure = 4;
	protected double maxMeasure = 7.0;
	
	@Before
	public void setup() throws ConfigurationException {
		mock = new MockComponentsInitializer();
		mock.initialize();
		ctl = mock.getCtl();
		me = (MeImpl)ctl.getMe();
		view = mock.getView();
		
		Assert.assertEquals(defaultBPM, mock.getBeatsSlider().getValue(), 0.0);
		Assert.assertEquals(defaultMeasure, mock.getBarSlider().getValue(), 0.0);
	}
	
	@Test
	public void bpmSliderChangedTest(){
		mock.getBeatsSlider().setValue(150);		
		Assert.assertEquals(0.6, view.getBpmSlider().getPosition(), 0.0);
	}
	
	@Test
	public void measureSliderChangedTest(){
		mock.getBarSlider().setValue(5);		
		Assert.assertEquals(0.7, view.getMeasureSlider().getPosition(), 0.1);
	}
	
	@Test
	public void startStopTest(){
		Assert.assertEquals(false, me.isRunning());
		view.getStartBtn().click();
		Assert.assertEquals(true, me.isRunning());
		view.getStopBtn().click();
		Assert.assertEquals(false, me.isRunning());
	}
	
	@Test
	public void incDecTest(){
		view.getIncBtn().click();
		Assert.assertEquals(defaultBPM + 1, me.getBPM(), 0.0);
		view.getDecBtn().click();
		Assert.assertEquals(defaultBPM, me.getBPM(), 0.0);
	}
	
	@Test
	public void bpmChangedTest() {
		Assert.assertEquals(defaultBPM, me.getBPM(), 0.0);
		view.getBpmText().setText(defaultBPM + " BPM");
		Assert.assertEquals(defaultBPM + " BPM", mock.getBeats().getText());
		view.getTempoNameText().setText(Utils.getTempoName(defaultBPM));
		Assert.assertEquals("Allegro", mock.getTempoMarking().getText());
	}
	

}
