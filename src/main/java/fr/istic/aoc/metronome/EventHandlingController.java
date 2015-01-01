package fr.istic.aoc.metronome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import fr.istic.aoc.metronome.command.BarChangedCmd;
import fr.istic.aoc.metronome.command.BarEventCmd;
import fr.istic.aoc.metronome.command.BeatEventCmd;
import fr.istic.aoc.metronome.command.BeatsChangedCmd;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.SpeedDownCmd;
import fr.istic.aoc.metronome.command.SpeedUpCmd;
import fr.istic.aoc.metronome.command.StartCmd;
import fr.istic.aoc.metronome.command.StopCmd;
import fr.istic.aoc.metronome.command.TickCmd;
import fr.istic.aoc.metronome.command.TurnOffLEDCmd;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.observer.MEObserver;
import fr.istic.aoc.metronome.observer.SliderObserver;
import fr.istic.aoc.metronome.utils.PropertyReader;
import fr.istic.aoc.metronome.utils.Utils;
import fr.istic.aoc.metronome.view.ButtonImpl;
import fr.istic.aoc.metronome.view.DisplayImpl;
import fr.istic.aoc.metronome.view.LEDImpl;
import fr.istic.aoc.metronome.view.SliderImpl;
import fr.istic.aoc.metronome.view.View;

/**
 * Concrete controller class. This class has a observer role for the {@link fr.istic.aoc.metronome.ME} class 
 * and the {@link fr.istic.aoc.metronome.view.Slider} class.
 * @see fr.istic.aoc.metronome.ME
 * @see fr.istic.aoc.metronome.view.Slider
 * @author Jiyoung Park.
 *
 */
public class EventHandlingController implements MEObserver, SliderObserver{
	
	@FXML private Button startBtn;
	@FXML private Button stopBtn;
	@FXML private Button speedUpBtn;
	@FXML private Button speedDownBtn;
	@FXML private Text bar;
	@FXML private Text beats;
	@FXML private Text tempoMarking;
	@FXML private Circle led1;
	@FXML private Circle led2;
	@FXML private Slider beatsSlider;
	@FXML private Slider barSlider;
	
	View view;
	ME me;
	PropertyReader props;
	
	Color beatsLEDColor = Color.DEEPSKYBLUE;
	Color barLEDColor = Color.PINK;
	double beatsSliderMaxValue = 250.0;
	double barSliderMaxValue = 7.0;

	/**
	 * Constructs a instance of EventHandlingController by creating the ME instance   
	 *  using the specified observer commands.
	 */
	public EventHandlingController(){
		try {
			me = MEImpl.build()
			  .registerObserver(new BeatsChangedCmd(this))
			  .registerObserver(new BarChangedCmd(this))
			  .registerObserver(new BeatEventCmd(this)) 
			  .registerObserver(new BarEventCmd(this));	
			me.registerObserver(new TickCmd(me));
			props = PropertyReader.getReader("config.properties");
			if(props != null){
				beatsLEDColor = props.getColor("beatsLEDColor");
				barLEDColor = props.getColor("barLEDColor");
				beatsSliderMaxValue = props.getDouble("beatsSliderMaxValue");
				barSliderMaxValue = props.getDouble("barSliderMaxValue");
			}
		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	/**
	 * Performs the actual initialization work after loading the FXML
	 */
	@FXML void initialize(){
		try {
			beats.setText(props.getInteger("defaultBeats") + " BPM");
			bar.setText(props.getInteger("defaultBar") + " beats");
			
			view = View.build()
			  // Texts
			  .setBeatsText(DisplayImpl.build().setFxComponent(beats))
			  .setBarText(DisplayImpl.build().setFxComponent(bar))
			  .setTempoMarking(DisplayImpl.build().setFxComponent(tempoMarking))
			  // LEDs
			  .setBeatsLED(LEDImpl.build().setFxComponent(led1).setFillColor(beatsLEDColor).registerObserver(new TurnOffLEDCmd(led1)))
			  .setBarLED(LEDImpl.build().setFxComponent(led2).setFillColor(barLEDColor).registerObserver(new TurnOffLEDCmd(led2)))
			  // sliders
			  .setBeatsSlider(SliderImpl.build().setFxComponent(beatsSlider).setMaxSliderValue(beatsSliderMaxValue).setValue(props.getInteger("defaultBeats")).registerObserver(new BeatsSliderChangedCmd()))
			  .setBarSlider(SliderImpl.build().setFxComponent(barSlider).setMaxSliderValue(barSliderMaxValue).setValue(props.getInteger("defaultBar")).registerObserver(new BarSliderChangedCmd()))
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
	
	/**
	 * Starts the Metronome.
	 */
	@Override
	public void start() {
		me.setRunning(true);
	}
	
	/**
	 * Stops the Metronome.
	 */
	@Override
	public void stop() {
		me.setRunning(false);
	}
	
	/**
	 * This method called by BeatsSliderChangedCmd Command of this class when the beats slider is changed.
	 */
	@Override
	public void beatsSliderChanged() {
		me.setBeats((int)Math.round(view.getBeatsSlider().getPosition() * 250));
	}
	/**
	 * This method called by BeatsSliderChangedCmd Command of this class when the bar slider is changed.
	 */
	@Override
	public void barSliderChanged() {
		me.setBar((int)Math.round(view.getBarSlider().getPosition() * 7));
	}
	/**
	 * This method is called by speed up event.
	 */
	@Override
	public void speedUp() {
		view.getBeatsSlider().speedUp();
		me.speedUp();
	}
	/**
	 * This method is called by speed down event.
	 */
	@Override
	public void speedDown() {
		view.getBeatsSlider().speedDown();
		me.speedDown();
	}

	/**
	 * This method is called by BeatsChangedCmd command
	 */
	@Override
	public void beatsChanged() {
		view.getBeatsText().setText(me.getBeats() + " BPM");
		view.getTempoMarking().setText(Utils.getTempoMarking(me.getBeats()));
	}

	/**
	 * This method is called by BarChangedCmd command
	 */
	@Override
	public void barChanged() {
		view.getBarText().setText(me.getBar() + " beats");
	}
	
	/**
	 * Handles the Beat Event. Flashes the beats led and beep
	 */
	@Override
	public void handleBeatEvent() {
		Material.getBeatBeeper().beep();
		view.getBeatsLED().flash();
	}
	/**
	 * Handles the Bar Event. Flashes the beats led and beep
	 */
	@Override
	public void handleBarEvent() {
		Material.getBarBeeper().beep();
		view.getBarLED().flash();
	}
	
	/////////////// Inner commands //////////////////
	
	class BeatsSliderChangedCmd implements Command{
		@Override
		public void execute() {
			beatsSliderChanged();
		}
	}
	
	class BarSliderChangedCmd implements Command{
		@Override
		public void execute() {
			barSliderChanged();
		}
	}
}
