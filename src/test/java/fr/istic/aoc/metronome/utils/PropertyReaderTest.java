package fr.istic.aoc.metronome.utils;

import java.io.IOException;

import javafx.scene.paint.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Verify properties in the config.properties
 * @author Jiyoung Park
 *
 */
public class PropertyReaderTest {
//	defaultBeats=140
//	defaultBar=4
//	beatsSliderMaxValue=250.0
//	barSliderMaxValue=7.0
//	beatsLEDColor=DEEPSKYBLUE
//	barLEDColor=PINK

	private PropertiesReader propReader;
	@Before
	public void setup() throws IOException {
		propReader = PropertiesReader.getReader("config.properties");
		Assert.assertNotNull(propReader);
	}

	@Test
	public void testGetDouble() {
		Assert.assertEquals(140.0, propReader.getDouble("defaultBeats").doubleValue(), 0.0);
		Assert.assertEquals(250.0, propReader.getDouble("beatsSliderMaxValue").doubleValue(), 0.0);
		Assert.assertEquals(7.0, propReader.getDouble("barSliderMaxValue").doubleValue(), 0.0);
	}

	@Test
	public void testGetInteger() {
		Assert.assertEquals(4, propReader.getDouble("defaultBar"), 0.0);
	}

	@Test
	public void testGetColor() {
		Assert.assertEquals(Color.DEEPSKYBLUE, propReader.getColor("beatsLEDColor"));
		Assert.assertEquals(Color.PINK, propReader.getColor("barLEDColor"));
	}
}
