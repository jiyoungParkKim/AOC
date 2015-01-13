package fr.istic.aoc.metronome.ui.fx;

import org.junit.Assert;
import org.junit.Test;

import fr.istic.aoc.metronome.ControllerTest;

public class FxSliderTest extends ControllerTest{

	@Test
	public void testFxSlider() {
		mock.getBeatsSlider().setValue(defaultBPM);
		FxSlider slider = new FxSlider(mock.getBeatsSlider());
		Assert.assertEquals(defaultBPM / maxBPM, slider.getPosition(), 0);
	}

}
