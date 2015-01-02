package fr.istic.aoc.metronome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import fr.istic.aoc.metronome.command.SpeedDownCmd;
import fr.istic.aoc.metronome.command.SpeedUpCmd;
import fr.istic.aoc.metronome.command.StartCmd;
import fr.istic.aoc.metronome.command.StopCmd;
import fr.istic.aoc.metronome.command.TurnOffLEDCmd;
import fr.istic.aoc.metronome.view.ButtonImpl;
import fr.istic.aoc.metronome.view.DisplayImpl;
import fr.istic.aoc.metronome.view.LEDImpl;
import fr.istic.aoc.metronome.view.SliderImpl;
import fr.istic.aoc.metronome.view.View;

public class MockEventHandlingController extends EventHandlingController{

	private Button startBtn = new Button();
	private Button stopBtn = new Button();
	private Button speedUpBtn = new Button();
	private Button speedDownBtn = new Button();
	
	private Text bar = new Text();
	private Text beats = new Text();
	private Text tempoMarking = new Text();
	private Circle led1 = new Circle();
	private Circle led2 = new Circle();
	private Slider beatsSlider = new Slider();
	private Slider barSlider = new Slider();
	
	LEDImpl barLedImpl;
	LEDImpl beatsLedImpl;
	
	public MockEventHandlingController() {
		super();
	}

	/**
	 * Initialize a instance after loading the FXML
	 * @throws ConfigurationException 
	 */
	@FXML void initialize(){
		try {
			beats.setText(props.getInteger("defaultBeats") + " BPM");
			bar.setText(props.getInteger("defaultBar") + " beats");
			
			beatsSlider.setMax(props.getDouble("beatsSliderMaxValue"));
			beatsSlider.setValue(props.getDouble("defaultBeats"));
			
			barSlider.setMax(props.getDouble("barSliderMaxValue"));
			barSlider.setValue(props.getDouble("defaultBar"));
			
			barLedImpl = (LEDImpl) LEDImpl.build().setFxComponent(led2).setFillColor(barLEDColor).registerObserver(new TurnOffLEDCmd(led2));
			beatsLedImpl = (LEDImpl) LEDImpl.build().setFxComponent(led1).setFillColor(beatsLEDColor).registerObserver(new TurnOffLEDCmd(led1));
			
			view = View.build()
			  // Texts
			  .setBeatsText(DisplayImpl.build().setFxComponent(beats))
			  .setBarText(DisplayImpl.build().setFxComponent(bar))
			  .setTempoMarking(DisplayImpl.build().setFxComponent(tempoMarking))
			  // LEDs
			  .setBeatsLED(beatsLedImpl)
			  .setBarLED(barLedImpl)
			  // sliders
			  
			  .setBeatsSlider(SliderImpl.build().setFxComponent(beatsSlider).setMaxSliderValue(beatsSliderMaxValue).registerObserver(new BeatsSliderChangedCmd()))
			  .setBarSlider(SliderImpl.build().setFxComponent(barSlider).setMaxSliderValue(barSliderMaxValue).registerObserver(new BarSliderChangedCmd()))
			  // buttons
		      .setStartButton(ButtonImpl.build().setFxComponent(startBtn).setCommand(new StartCmd(this))) 
		      .setStopButton(ButtonImpl.build().setFxComponent(stopBtn).setCommand(new StopCmd(this))) 
		      .setSpeedUpButton(ButtonImpl.build().setFxComponent(speedUpBtn).setCommand(new SpeedUpCmd(this))) 
		      .setSpeedDownButton(ButtonImpl.build().setFxComponent(speedDownBtn).setCommand(new SpeedDownCmd(this)));
			
		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public Text getBar() {
		return bar;
	}
	
	public Text getBeats() {
		return beats;
	}
	
	public Slider getBeatsSlider() {
		return beatsSlider;
	}
	
	public Slider getBarSlider() {
		return barSlider;
	}
	
	public Text getTempoMarking() {
		return tempoMarking;
	}

	@Override
	public void handleBeatEvent() {
		System.out.println("Beep!");
		View.getBeatBeeper().beep();
		view.getBeatsLED().flash();
	}
	
	@Override
	public void handleBarEvent() {
		System.out.println("Bar!");
		View.getBarBeeper().beep();
		view.getBarLED().flash();
	}
}
