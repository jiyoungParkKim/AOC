package fr.istic.aoc.metronome.anti_adapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.istic.aoc.metronome.Controller;
import fr.istic.aoc.metronome.JavaFXThreadingRule;
import fr.istic.aoc.metronome.command.BpmSliderChangedCmd;
import fr.istic.aoc.metronome.command.MeasureSliderChangedCmd;
import fr.istic.aoc.metronome.ui.SliderType;

public class SliderAdapterTest {

	@Rule public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	private double defaultBeats=140.0;
	private double defaultBar=4.0;
	private double beatsSliderMaxValue=250.0;
	private double barSliderMaxValue=7.0;
	
	private Controller ctl;
	
	@Before
	public void setup(){
		ctl = new Controller();
	}
	
	@Test
	public void bpmSliderAdapterTest() {
		javafx.scene.control.Slider  fxSlider = new javafx.scene.control.Slider(0, beatsSliderMaxValue, defaultBeats);
		SliderAdapter bpmSlider = new SliderAdapter(SliderType.BPM, fxSlider);
		bpmSlider.register(new BpmSliderChangedCmd(ctl));
		
		Assert.assertEquals(defaultBeats / beatsSliderMaxValue, bpmSlider.getPosition(), 0);
		
		fxSlider.setValue(150);
		Assert.assertEquals(0.6, bpmSlider.getPosition(), 0);
	}
	
	@Test
	public void measureSliderAdapterTest() {
		javafx.scene.control.Slider  fxSlider = new javafx.scene.control.Slider(0, barSliderMaxValue, defaultBar);
		SliderAdapter barSlider = new SliderAdapter(SliderType.MEASURE, fxSlider);
		barSlider.register(new MeasureSliderChangedCmd(ctl));
		
		Assert.assertEquals(defaultBar / barSliderMaxValue, barSlider.getPosition(), 0);
		
		fxSlider.setValue(2);
		Assert.assertEquals(0.2857, barSlider.getPosition(), 0.01);
	}

}
