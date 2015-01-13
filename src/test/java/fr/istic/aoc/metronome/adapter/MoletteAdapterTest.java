package fr.istic.aoc.metronome.adapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.istic.aoc.metronome.JavaFXThreadingRule;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.SliderType;

public class MoletteAdapterTest {
	
	@Rule public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	private double defaultBeats=140.0;
	private double defaultBar=4.0;
	private double beatsSliderMaxValue=250.0;
	private double barSliderMaxValue=7.0;
	private MoletteAdapter madapter;
	
	@Before
	public void setup(){
		madapter = (MoletteAdapter)Material.getMolette();
	}
	
	@Test
	public void defaultPositionValueTest() {
		Assert.assertEquals(defaultBeats / beatsSliderMaxValue, madapter.getPosition(SliderType.BPM.getValue()), 0.0);
		Assert.assertEquals(defaultBar / barSliderMaxValue, madapter.getPosition(SliderType.MEASURE.getValue()), 0.0);
	}
	
	@Test
	public void setChangedListenerTest(){
		javafx.scene.control.Slider fxSlider = new javafx.scene.control.Slider(0.0, beatsSliderMaxValue, defaultBeats);
		madapter.setChangedListener(SliderType.BPM, fxSlider);
		
		fxSlider.setValue(150.0);
		Assert.assertEquals(150.0 / beatsSliderMaxValue, madapter.getPosition(SliderType.BPM.getValue()), 0.0);
		
		fxSlider.setValue(defaultBeats);
	}


}
