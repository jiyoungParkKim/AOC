package fr.istic.aoc.metronome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.istic.aoc.metronome.utils.PropertyReader;
import fr.istic.aoc.metronome.utils.Utils;
import fr.istic.aoc.metronome.view.LEDDecorator;

//@RunWith(MockitoJUnitRunner.class)
public class EventHandlingControllerTest {
	public class PropertyReaderTest {}
//		defaultBeats=140
//		defaultBar=4
//		beatsSliderMaxValue=250.0
//		barSliderMaxValue=7.0
//		beatsLEDColor=DEEPSKYBLUE
//		barLEDColor=PINK	
		
	// JavaFX Runtime env rule
	@Rule public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	MockEventHandlingController spy;
	private PropertyReader propReader;
	
	@Before
	public void setup(){
		spy = new MockEventHandlingController();		
		//spy = spy(new MockEventHandlingController());
		
		spy.initialize();
		propReader = PropertyReader.getReader("config.properties");
		assertNotNull(propReader);
	}
	
	@Test
	public void propertiesSettingTest(){
		assertEquals(propReader.getInteger("defaultBeats") + " BPM", spy.getBeats().getText());
		assertEquals(propReader.getInteger("defaultBar") + " beats", spy.getBar().getText());
		assertEquals(propReader.getInteger("defaultBar"), spy.getBarSlider().getValue(), 0);
		assertEquals(propReader.getInteger("defaultBeats"), spy.getBeatsSlider().getValue(), 0);
	}

	@Test
	public void testStart() throws InterruptedException {
		spy.start();
		assertTrue(spy.me.isRunning());
	}

	@Test
	public void testStop() {
		spy.stop();
		assertFalse(spy.me.isRunning());
	}

	@Test
	public void testBeatsSliderChanged() {
		spy.getBeatsSlider().setValue(150);
		assertEquals(spy.me.getBeats() + " BPM", spy.getBeats().getText());
		assertEquals(Utils.getTempoMarking(spy.me.getBeats()), spy.getTempoMarking().getText());
	}

	@Test
	public void testBarSliderChanged() {
		spy.getBarSlider().setValue(5);
		assertEquals(spy.me.getBar() + " beats", spy.getBar().getText());
	}

	@Test
	public void testSpeedUp() {
		spy.speedUp();
		assertEquals(spy.me.getBeats() + 5 + " BPM", spy.getBeats().getText());
	}

	@Test
	public void testSpeedDown() {
		spy.speedDown();
		assertEquals(spy.me.getBeats() - 5 + " BPM", spy.getBeats().getText());
	}

	@Test
	public void testBeatsChanged() {
		int newBeats = 100;
		spy.me.setBeats(newBeats);
		assertEquals(newBeats + " BPM", spy.getBeats().getText());
	}

	@Test
	public void testBarChanged() {
		int newBar = 5;
		spy.me.setBar(newBar);
		assertEquals(newBar + " beats", spy.getBar().getText());
	}

	@Test
	public void testHandleBeatEvent() throws ConfigurationException {
		spy.view.setBeatsLED(new LEDDecorator(spy.beatsLedImpl, "Beats LED"));
		spy.handleBeatEvent();
	}

	@Test
	public void testHandleBarEvent() throws ConfigurationException {
		spy.view.setBarLED(new LEDDecorator(spy.barLedImpl, "Bar LED"));
		spy.handleBarEvent();
	}

}
